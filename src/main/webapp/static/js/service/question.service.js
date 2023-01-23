/**
 * 
 */
'use strict';
angular.module('developersCorner').factory("QuestionService", ["$http", "$q", function($http, $q) {
	const URL = 'http://localhost:8080/user/questions';

	const factory = {
		fetchAllUserQuestions,
		updateUserQuestion,
		deleteUserQuestion,
		getQuestionById,
		fetchResourceFromStackOverFlow,
		saveQuestion
	}

	return factory;

	function fetchAllUserQuestions(userId) {
		const defered = $q.defer();

		$http.get(URL + "/question?userId=" + userId)
			.then((res) => defered.resolve(res.data))
			.catch((err) => defered.reject(err));

		return defered.promise;
	}

	function getQuestionById(questionId) {
		const defered = $q.defer();

		$http.get(URL + `/${questionId}`)
			.then((res) => defered.resolve(res.data))
			.catch((err) => defered.reject(err));

		return defered.promise;
	}
	
	function saveQuestion(question) {
		const defered = $q.defer();

		$http.post(URL, question)
			.then((res) => defered.resolve(res.data))
			.catch((err) => defered.reject(err));

		return defered.promise;
	}

	function updateUserQuestion(updates) {
		const defered = $q.defer();
		updates.userId = updates.user.id;

		$http.put(URL + "/" + updates.id, updates)
			.then((res) => defered.resolve(res.data))
			.catch((err) => defered.reject(err));

		return defered.promise;
	}

	function deleteUserQuestion(id) {
		const defered = $q.defer();

		$http.delete(URL + "/" + id)
			.then((res) => defered.resolve(res.data))
			.catch((err) => defered.reject(err));
		return defered.promise;
	}

	// Fetch topics from Stackoverflow
	function fetchResourceFromStackOverFlow(url) {
		const defered = $q.defer();

		$http.get(url)
			.then((res) => defered.resolve(res.data))
			.catch((err) => defered.reject(err));
		return defered.promise;
	}
}]);