/**
 * Created by Lobedan on 27.09.2014.
 */
angular.module('controller.invoiceController', [
	'services.crudService'
])
		.controller('invoiceController', function ($scope, $rootScope, $log, crudService) {
						$scope.invoices = ($("#invoices").data('invoices'));

					});
