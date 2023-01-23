(function() {
	angular.module('developersCorner').controller("ProfileController", ["$scope", "ProfileService", "AuthService", function($scope, ProfileService, AuthService) {
		$scope.user = null;
		$scope.showModal = false;
		$scope.getUserProfile = getUserProfile;
		$scope.editUserProfile = editUserProfile;
		$scope.deleteUserProfile = deleteUserProfile;
		$scope.openModal = openModal;
		$scope.closeModal = closeModal;

		async function init() {
			const user = await AuthService.getCurrentUser();
			if (user) getUserProfile(user.id);
		}

		if(AuthService.getToken()) init();

		function getUserProfile(userId) {
			ProfileService.getUserProfile(userId)
				.then((data) => {
					$scope.user = data
				})
				.then((err) => console.log(err));
		}
		function editUserProfile(user) {
			ProfileService.editUserProfile(user)
				.then((data) => {
					$scope.user = data
					getUserProfile(user.id);
					closeModal();
				})
				.catch((err) => console.log(err.message));
		}
		function deleteUserProfile(userId) {
			ProfileService.deleteUserProfile(userId)
				.then((data) => {
					console.log(data);
				})
				.then((err) => console.log(err));
		}

		function openModal(question) {
			$scope.question = question;
			$scope.showModal = true;
		}

		function closeModal() {
			$scope.showModal = false;
		}

	}]);
})();
