/**
 * Created by Lobedan on 27.09.2014.
 */
angular.module('controller.invoiceController', [
	'services.crudService'
])
		.controller('invoiceController', function ($scope, $rootScope, $log, crudService) {

						$scope.invoices = $("#invoices").data('invoices');

						$scope.setted_invoice = 0;

						$scope.setInvoice = function (invoice) {
							$scope.setted_invoice = invoice;
						};

						$scope.setted_par_invoice = 0;

						$scope.previous = function () {
							$scope.setted_par_invoice -= 1;
							$scope.complete_count
							= $scope.invoices[$scope.setted_invoice].partials[$scope.setted_par_invoice].income
							  - $scope.invoices[$scope.setted_invoice].partials[$scope.setted_par_invoice].billAmount
							  - $scope.invoices[$scope.setted_invoice].partials[$scope.setted_par_invoice].ecamount;

							$log.log($scope.setted_par_invoice);
						};

						$scope.next = function () {
							$scope.setted_par_invoice += 1;
							$scope.complete_count
							= $scope.invoices[$scope.setted_invoice].partials[$scope.setted_par_invoice].income
							  - $scope.invoices[$scope.setted_invoice].partials[$scope.setted_par_invoice].billAmount
							  - $scope.invoices[$scope.setted_invoice].partials[$scope.setted_par_invoice].ecamount;

							$log.log($scope.setted_par_invoice);
						};

						$scope.complete_count
						= $scope.invoices[$scope.setted_invoice].partials[$scope.setted_par_invoice].income
						  - $scope.invoices[$scope.setted_invoice].partials[$scope.setted_par_invoice].billAmount
						  - $scope.invoices[$scope.setted_invoice].partials[$scope.setted_par_invoice].ecamount;


					});
