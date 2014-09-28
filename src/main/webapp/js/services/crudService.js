angular.module('services.crudService', [

]).factory(
		'crudService',
		function ($http) {
			"use strict";
			return {
				get: function (url) {
					return $http.get(url, {headers: {'Content-Type': 'application/json'}});
				},
				post: function (data, url) {
					return $http.post(url, data,
									  {
										  headers: {
											  'Content-Type': 'application/json'
										  }
									  }
					);
				}
			};
		}
);
