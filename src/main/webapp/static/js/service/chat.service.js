(function() {
	angular.module('developersCorner').factory('ChatService', ChatService);

	function ChatService($q, $timeout, AuthService, $http) {
		const service = {};
		const listener = $q.defer();
		const socket = {
			client: null,
			stomp: null
		};

		service.RECONNECT_TIMEOUT = 30000;
		service.SOCKET_URL = "http://localhost:8083/secured-room";
		service.CHAT_TOPIC = "/queue/messages";
		service.CHAT_BROKER = "/queue/messages";

		service.receive = function() {
			return listener.promise;
		};

		service.send = function(message) {
			console.log("message sent", message);
			socket.stomp.send(service.CHAT_BROKER, {
				priority: 9,
				username: AuthService.getCurrentUser().email
			}, JSON.stringify(message));
	
		}
		
		/*function getMessages() {
			$http.get('http://localhost:8083/messages')
				.then((res) => console.log(res))
				.catch((err) => listener.reject(err));
		}
		*/
		//getMessages();

		var reconnect = function() {
			$timeout(function() {
				initialize();
			}, this.RECONNECT_TIMEOUT);
		};

		var getMessage = function(data) {
			var message = JSON.parse(data), out = {};
			out.message = message.message;
			out.time = new Date(message.time);
			return message;
		};

		var startListener = function() {
			socket.stomp.subscribe(service.CHAT_TOPIC, function(data) {
				listener.notify(getMessage(data.body));
			});
		};

		var initialize = function() {
			socket.client = new SockJS(service.SOCKET_URL);
			socket.stomp = Stomp.over(socket.client);
			socket.stomp.connect({username: AuthService.getCurrentUser().email}, startListener);
			socket.stomp.onclose = reconnect;
		};

		initialize();
		return service;
	}
})();