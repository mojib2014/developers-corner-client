(function() {
	angular.module('developersCorner').factory('ChatService', ChatService);

	function ChatService($q, $timeout, AuthService) {
		const service = {};
		const listener = $q.defer();
		const socket = {
			client: null,
			stomp: null
		};

		service.RECONNECT_TIMEOUT = 30000;
		service.SOCKET_URL = "http://localhost:8083/ws";
		service.CHAT_TOPIC = '/user/specific';
		service.CHAT_BROKER = "/app/private-message";

		service.receive = function() {
			return listener.promise;
		};

		service.send = function(message) {
			console.log("message sent", message);
			if(AuthService.getToken()) {
				socket.stomp.send(service.CHAT_BROKER, {}, JSON.stringify(message));								
			};
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
			}, service.RECONNECT_TIMEOUT);
		};

		var getMessage = function(data) {
			console.log("recevie message: ===========", data);
			var message = JSON.parse(data);
			return message;
		};

		var startListener = async function() {
			const user = await AuthService.getCurrentUser();
			socket.stomp.subscribe(service.CHAT_TOPIC, function(data) {
				console.log("recevie data : 00000000: ", data);
				listener.notify(getMessage(data.body));
			});
		};

		service.initialize = function() {
			if(AuthService.getToken) {
				socket.client = new SockJS(service.SOCKET_URL);
				socket.stomp = Stomp.over(socket.client);
				socket.stomp.connect({}, startListener);
				socket.stomp.onclose = reconnect;								
			}
		};

		return service;
	}
})();