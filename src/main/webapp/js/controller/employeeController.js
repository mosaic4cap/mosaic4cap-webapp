/**
 * Created by svenklemmer on 11.10.14.
 */
angular.module('controller.employeeController', [
	'services.crudService'
])
		.controller('employeeController', function ($scope, $rootScope, $log, crudService) {

			            crudService.get("/rest/employee/all/")
					            .success(function (data) {
						                     $log.log("[employeeController.get] reading data", data);
						                     $scope.employees = data;
					                     })
					            .error(function (data, status) {
						                   $log.log("[employeeController.get] could not read data", status);
						                   if (data.error) {
							                   $rootScope.messages = {message: data.error, type: "alert-danger"};
						                   }
					                   });

			            $scope.show = false;

			            $scope.select = function (index) {
				            $scope.employee = $scope.employees[index];
				            if ($scope.show == false) {
					            $scope.show = true;
				            }
			            };

			            $scope.save = function (index) {
				            var data = $scope.employees[index];
				            /*crudService.update() */
			            };

		            });
