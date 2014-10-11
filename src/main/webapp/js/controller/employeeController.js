/**
 * Created by svenklemmer on 11.10.14.
 */
angular.module('controller.employeeController', [
    'services.crudService'
])
        .controller('employeeController', function ($scope, $rootScope, $log, crudService, ENV) {
                        $scope.enviroment = ENV;

                        $scope.employees = $("#employees").data('employees');

                        $scope.show = false;

                        $scope.select = function(index) {
                            $scope.employee = $scope.employees[index];
                            if ($scope.show == false) {
                                $scope.show = true;
                            }
                        }


                        $scope.save = function (index) {
                            var data = $scope.employees[index];
                            /*crudService.update() */
                        };

                    });
