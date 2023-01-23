(function() {
	'use strict';

	const app = angular.module('developersCorner', ['angular-jwt', 'ngRoute']);

	app.config(Config);

	app.run(function(authManager) {
		authManager.checkAuthOnRefresh();
	});

	function Config($httpProvider, jwtOptionsProvider, $routeProvider) {
		jwtOptionsProvider.config({
			unauthenticatedRedirector: ['$state', function($state) {
				$state.go('#!login');
			}],
			tokenGetter: ['AuthService', function(AuthService) {
				return AuthService.getToken();
			}],
			whiteListedDomains: ['http://localhost:8083'],
		});

		$httpProvider.interceptors.push('jwtInterceptor');

		// Routes
		$routeProvider
			.when('/', { templateUrl: 'home' })
			.when('/login', { templateUrl: 'login' })
			.when('/register', { templateUrl: 'register' })
			.when('/questions', { templateUrl: 'questions' })
			.when('/profile', { templateUrl: 'profile' })
			.otherwise({ redirectTo: '/login' });
	}
})();
