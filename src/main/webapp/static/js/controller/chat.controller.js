(function() {
	angular.module('developersCorner').controller('ChatController', ChatController);
	
	function ChatController($scope, ChatService, AuthService) {
		$scope.messages = [];
		$scope.message = { sender: null, receiver: null, message: '' };
		$scope.modalOpen = false;
		$scope.currentUser = AuthService.getCurrentUser();
		let user;

		$scope.sendMessage = async function() {
			if(AuthService.getToken())
				user = await AuthService.getCurrentUser();
			$scope.message.sender = user.email;
			ChatService.send($scope.message);
			$scope.message.message = "";
		};

		ChatService.receive().then(null, null, function(message) {
			console.log('received message', message);
			$scope.messages.push(message);
		});
		
		$scope.openChatModal = function(receiver) {
			$scope.message.receiver = receiver.email;
			$scope.modalOpen = true;
		}
		
		$scope.closeChatModal = function() {
			console.log('close clicked');
			$scope.modalOpen = false;
		}
	}
})();