/**
 * 
 */
(function() {
	angular.module('developersCorner').directive('myModal', myModal);

	function myModal(NotificationService) {
		const $ = (selector) => document.querySelector(selector);
		return {
			link: function(scope, element, attrs) {
				scope.message = NotificationService.message;
				scope.type = NotificationService.type;
				// ensure id attribute exists
				if (!attrs.id) {
					console.error('modal must have an id');
					return;
				}

				// move element to bottom of page (just before </body>) so it can be displayed above everything else
				$('body').append(element);

				// close modal on background click
				element.on('click', function(e) {
					const target = $(e.target);
					if (!target.closest('.modal-body').length) {
						scope.$evalAsync(close);
					}
				});

				// add self (this modal instance) to the modal service so it's accessible from controllers
				const modal = {
					id: attrs.id,
					open,
					close
				};
				NotificationService.add(modal);

				// remove self from modal service when directive is destroyed
				scope.$on('$destroy', function() {
					NotificationService.remove(attrs.id);
					element.remove();
				});

				// open modal
				function open() {
					element.show();
					$('body').addClass('modal-open');
				}

				// close modal
				function close() {
					element.hide();
					$('body').removeClass('modal-open');
				}
			}
		}
	}
})();