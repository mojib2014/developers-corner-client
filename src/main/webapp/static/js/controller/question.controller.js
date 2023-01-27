(function() {
	'use strict';
	angular.module('developersCorner').controller('QuestionController', QuestionController);

	function QuestionController($scope, QuestionService, AuthService) {
		$scope.questions = [];
		$scope.question = { id: null, username: '', role: '', tags: '', question: '', userId: null };
		$scope.answers = [];
		$scope.showModal = false;
		$scope.userRole = "";
		$scope.displayAnswers = false;

		if(AuthService.getToken() && window.location.href.indexOf('questions') > -1) {
			fetchAllUserQuestions();
		}
			

		async function fetchAllUserQuestions() {
			const user = await AuthService.getCurrentUser();

			QuestionService.fetchAllUserQuestions(user.id)
				.then((data) => {
					console.log("questions: ", data);
					$scope.questions = data
				})
				.catch((err) => console.log(err));
		}

		$scope.updateUserQuestion = function() {
			QuestionService.updateUserQuestion($scope.question)
				.then((data) => {
					$scope.question = data;
					fetchAllUserQuestions();
					$scope.closeModal();
				})
				.catch((err) => console.log(err));
		}

		$scope.deleteUserQuestion = function(id) {
			QuestionService.deleteUserQuestion(id)
				.then(fetchAllUserQuestions)
				.catch((err) => console.log(err));
		}

		$scope.openModal = function(question) {
			$scope.question = question;
			$scope.showModal = true;
		console.log($scope.showModal);
		}

		$scope.closeModal = function() {
			$scope.showModal = false;
		}

		// External data fetching and dom manipulation
		// StackExchange and MDN api urls
		let stackExchangeQuery = "https://api.stackexchange.com/2.3/search?order=desc&sort=activity&site=stackoverflow&tagged=";
		//let mdnQuery = "https://developer.mozilla.org/en-US/search.json?locale=en-US&q=";

		$scope.fetchAnswersFromMdnAndStackoverflow = async function() {
			const user = await AuthService.getCurrentUser();
			$scope.question.userId = user.id;
			QuestionService.saveQuestion($scope.question);
			stackExchangeQuery += $scope.question.tags + '&intitle=' + $scope.question.question;
			QuestionService.fetchResourceFromStackOverFlow(stackExchangeQuery)
				.then((data) => {
					$scope.answers = data.items;					
					$scope.displayAnswers = true;
				}).catch((err) => console.log(err));
			
			//fetchResourceFromMdn();
		}

		$scope.newQuestion = function() {
			$scope.displayAnswers = false;
		}

		// Fetch topics from mdn
		/*const fetchResourceFromMdn = async (url) => {
			const result = await fetch(url);
			const res = await result.json();
			console.log(res);
			return res;
		}*/
	};
})();
