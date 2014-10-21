/**
 * Created by Lobedan on 27.09.2014.
 */
angular.module('controller.invoiceController', [
	'services.crudService'
])
		.controller('invoiceController', function ($scope, $rootScope, $log, crudService, ENV) {
			            crudService.get("/rest/invoice/all/")
					            .success(function (data) {
						                     $log.log("[invoiceController.get] reading data", data);
						                     $scope.invoices = data;
					                     })
					            .error(function (data, status) {
						                   $log.log("[invoiceController.get] could not read data", status);
						                   if (data.error) {
							                   $rootScope.messages = {message: data.error, type: "alert-danger"};
						                   }
					                   });


	                $scope.setted_invoice = 0;
	                $scope.setted_par_invoice = 0;

			            if (typeof $scope.invoices !== 'undefined') {

				            $scope.setInvoice = function (invoice) {
					            $scope.setted_invoice = invoice;
				            };

				            $scope.previousInvoice = function () {
					            $scope.setted_par_invoice -= 1;
					            $scope.complete_count
					            = $scope.invoices[$scope.setted_invoice].partials[$scope.setted_par_invoice].income
					              - $scope.invoices[$scope.setted_invoice].partials[$scope.setted_par_invoice].billAmount
					              - $scope.invoices[$scope.setted_invoice].partials[$scope.setted_par_invoice].ecamount;

					            $log.log($scope.setted_par_invoice);
				            };

				            $scope.nextInvoice = function () {
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

			            }

			            $scope.updateInvoice = function () {
				            $scope.invoices[$scope.setted_invoice].partials[$scope.setted_par_invoice].state = "CLOSED";
				            crudService.post(angular.toJson($scope.invoices[$scope.setted_invoice]),
				                             "/rest/invoice/save")
						            .success(function (data) {
							                     $rootScope.messages
							                     = {
								                     message: "Abrechnungen erfolgreich gespeichert!",
								                     type: "alert-success"
							                     };
							                     $log.log("[invoiceController.post] saved data", data);
						                     })
						            .error(function (data, status) {
							                   $log.log("[invoiceController.post] could not save data", data, status);
							                   if (data.error) {
								                   $rootScope.messages = {message: data.error, type: "alert-danger"};
							                   } else {
								                   $rootScope.messages = {
									                   message: "Server nicht erreichbar!",
									                   type: "alert-danger"
								                   };
							                   }
						                   });
			            }

		            });
