/**
 * Created by Lobedan on 27.09.2014.
 */
angular.module('controller.invoiceController', [
	'services.crudService'
])
		.controller('invoiceController', function ($scope, $rootScope, $log, crudService, ENV) {

			            /** need sample array cause otherwise side will not display loaded data
			             * maybe this changes when intercepter for loading is implementet
			             * TODO: make issue and implement
			             */
			            $scope.invoices = [
				            {
					            "date": '',
					            "partials": [
						            {
							            "id": 0,
							            "income": 0.00,
							            "bills": [],
							            "ecpayment": [],
							            "driver": {
								            "id": 0,
								            "firstName": "",
								            "lastName": "",
								            "birthDay": ""
							            },
							            "car": {
								            "id": 0,
								            "badge": "",
								            "available": false
							            },
							            "date": "",
							            "state": "OPEN",
							            "modDate": 0,
							            "billAmount": 0.00,
							            "ecamount": 0.00
						            }
					            ],
					            "store": {
						            "id": 0,
						            "storeKey": "",
						            "storeType": "",
						            "drivers": [],
						            "cars": [],
						            "invoices": []
					            },
					            "state": "OPEN",
					            "amount": 0.00,
					            "ecAmount": 0.00,
					            "billAmount": 0.00,
					            "ecCount": 0.00,
					            "billCount": 0.00
				            }
			            ];

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

			            $scope.setInvoice = function (invoice) {
				            $log.log("setInvoice to " + invoice);
				            $scope.setted_invoice = invoice;
			            };

			            $scope.previousInvoice = function () {
				            $log.log("previous invoice");
				            $scope.setted_par_invoice -= 1;
				            $scope.complete_count
				            = $scope.invoices[$scope.setted_invoice].partials[$scope.setted_par_invoice].income
				              - $scope.invoices[$scope.setted_invoice].partials[$scope.setted_par_invoice].billAmount
				              - $scope.invoices[$scope.setted_invoice].partials[$scope.setted_par_invoice].ecamount;

				            $log.log($scope.setted_par_invoice);
			            };

			            $scope.nextInvoice = function () {
				            $log.log("nextInvoice");
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
