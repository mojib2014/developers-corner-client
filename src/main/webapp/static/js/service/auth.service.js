(function() {
	angular.module('developersCorner').factory('AuthService', AuthService);

	function AuthService($http, $q, jwtHelper, UserService, $rootScope) {
		const URL = 'http://localhost:8080';

		const factory = {
			login,
			register,
			logout,
			getCurrentUser,
			getToken
		}

		function login(user) {
			const defered = $q.defer();
			$http.post(URL + "/login", user)
				.then((res) => {
					defered.resolve(res.data);
					localStorage.setItem("token", res.data.token);
					localStorage.setItem("isLoggedIn", true);
					window.location = '/';
				})
				.catch((err) => defered.reject(err));

			return defered.promise;
		}

		function register(user) {
			console.log('resgistring')
			const defered = $q.defer();

			$http.post(URL + "/register", user)
				.then((res) => {
					localStorage.setItem('token', JSON.stringify(res.data.token));
					localStorage.setItem("isLoggedIn", true);
					defered.resolve(res.data);
					window.location = '/';
				})
				.catch((err) => defered.reject(err));

			return defered.promise;
		}

		function logout() {
			localStorage.removeItem("token");
			window.location = '#!/login';
		};

		async function getCurrentUser() {
			const token = getToken();
			const email = token !== null ? jwtHelper.decodeToken(token).sub : null;
			const user = await UserService.getUserByEmail(email);

			return user;
		};

		function getToken() {
			/*const token = localStorage.getItem('token');
			if(token) return token;
			window.location = "#!/login";*/
			return localStorage.getItem('token');
		}
		
		 function authenticate(){
            //Authentication logic here
            if(localStorage.getItem('isLoggedIn')){
                //If authenticated, return anything you want, probably a user object
                return true;
            } else {
                //Else send a rejection
                return $q.reject('Not Authenticated');
            }
        }

		return factory;
	};
})();
