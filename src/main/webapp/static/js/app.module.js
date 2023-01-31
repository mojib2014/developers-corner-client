(function() {
	'use strict';

	const app = angular.module('developersCorner', ['angular-jwt', 'ngRoute']);

	app.config(Config);

	app.run(function(authManager, $rootScope, $location) {
		authManager.checkAuthOnRefresh();
		$rootScope.$on('$locationChageStart', function() {
			console.log("in locationChangeStart...");
			$rootScope.previousPage = $location.pathname;
		});
		$rootScope.$on('$routeChangeError', function(event, current, previous, rejection) {
			console.log("routeChageError")
			if (rejection === 'Not Authenticated') {
				$location.path('/');
			}

		});

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
			.when('/',
				{
					templateUrl: 'home',
					requireLogin: true,
					resolve: {
						'auth': function(AuthService) {
							return AuthService.getToken();
						}
					}
				})
			.when('/login', { templateUrl: 'login' })
			.when('/register', { templateUrl: 'register' })
			.when('/questions', { templateUrl: 'questions' })
			.when('/profile', { templateUrl: 'profile' })
			.otherwise({ redirectTo: '/login' });
	}
})();
