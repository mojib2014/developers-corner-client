(function() {
	angular.module('developersCorner').controller("AuthController", AuthController);

	function AuthController($scope, AuthService) {
		$scope.user = { id: null, firstName: '', lastName: '', nickName: '', type: '', email: '', password: '' };
		$scope.isLoggedIn = localStorage.getItem('isLoggedIn') || false;
		$scope.login = login;
		$scope.register = register;
		$scope.logout = logout;

		function login() {
			AuthService.login($scope.user)
				.then((data) => {
					$scope.user = data
					$scope.isLoggedIn = true;
					openModal("success-modal");
				})
				.then((err) => {
					console.log(err);
				});
		}

		function register(user) {
			AuthService.register(user)
				.then((data) => {
					$scope.user = data;
					$scope.isLoggedIn = true;
					localStorage.setItem("isLoggedIn", true);
				})
				.then((err) => {
					console.log(err);
					openModal("error-modal");
				});
		}

		function logout() {
			AuthService.logout();
			$scope.isLoggedIn = false;
			localStorage.removeItem("isLoggedIn");
		}
	};

})();
