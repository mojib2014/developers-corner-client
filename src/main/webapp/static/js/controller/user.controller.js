(function() {
	'use strict';

	angular.module('developersCorner').controller('UserController', UserController);

	function UserController($scope, UserService, AuthService) {

		$scope.user = { id: null, firstName: '', lastName: '', nickName: '', type: '', email: '', password: '' };
		$scope.users = [];
		$scope.submit = submit;
		$scope.getUserById = getUserById;
		$scope.updateUserById = updateUserById;
		$scope.deleteUserById = deleteUserById;

		if (AuthService.getToken()) fetchAllUsers();

		function fetchAllUsers() {
			UserService.fetchAllUsers()
				.then((data) => {
					$scope.users = data
				})
				.catch((err) => console.log(err));
		}

		function getUserById(userId) {
			UserService.getUserById(userId)
				.then((user) => $scope.user = user)
				.catch((err) => console.log(err));
		}

		function updateUserById(user) {
			UserService.updateUserById(user)
				.then((res) => console.log(res))
				.catch((err) => console.log(err));
		}

		function deleteUserById(user) {
			UserService.deleteUserById(user)
				.then((res) => console.log(res))
				.catch((err) => console.log(err));
		}

		function submit() {
			if ($scope.user.id === null) {
				AuthService.register($scope.user)
					.then(fetchAllUsers)
					.catch((err) => console.log(err));
			} else {
				console.log('User updated with id ', $scope.user.id);
			}
		}
	}
})();
