/**
 * Created by Lobedan on 20.10.2014.
 */
angular.module('controller.storeController', [
    'services.crudService'
])
        .controller('storeController', function ($scope, $rootScope, $log, crudService) {

                        crudService.get("/rest/store/all/")
                                .success(function (data) {
                                             $log.log("[storeController.get] reading data", data);
                                             $scope.stores = data;
                                         })
                                .error(function (data, status) {
                                           $log.log("[storeController.get] could not read data", status);
                                           if (data.error) {
                                               $rootScope.messages = {message: data.error, type: "alert-danger"};
                                           }
                                       });
                        $scope.select_store = function (id) {
                            $log.log("Selecting store with id " + id);
                            crudService.post(id, "/rest/store/select/")
                                    .success(function (data) {
                                                 $rootScope.messages = {
                                                     message: "Store erfolgreich gewählt!",
                                                     type: "alert-success"
                                                 };

                                                 $log.log("[storeController.select_store.post] saved data", id);
                                                 document.location.href = "/chefui/store/" + id + "/dashboard";
                                             })
                                    .error(function (data, status) {
                                               $log.log("[storeController.select_store.post] could not save data",
                                                        data,
                                                        status);
                                               if (data.error) {
                                                   $rootScope.messages = {message: data.error, type: "alert-danger"};
                                               } else {
                                                   $rootScope.messages = {
                                                       message: "Server nicht erreichbar!",
                                                       type: "alert-danger"
                                                   };
                                               }
                                           })
                        }
                    });
