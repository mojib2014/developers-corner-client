(function() {
	angular.module('developersCorner').factory('NotificationService', NotificationService);

	function NotificationService() {

		const modals = [];

		const factory = {
			add,
			remove,
			open,
			close,
		}
		
		return factory;

		function add(modal) {
			modals.push(modal);
			console.log(modals);
		}

		function remove(id) {
			modals = modals.filter(m => m.id !== id);
		}

		function open(id) {
			const modal = modals.filter(m => m.id === id)[0];
			console.log("modal", modal);
			modal.open();
		};

		function close() {
			const modal = modals.filter(m => m.id === id)[0];
			modal.close();
		};
	};
})();
