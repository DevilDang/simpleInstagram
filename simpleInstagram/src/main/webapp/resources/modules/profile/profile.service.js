/**
 * http://usejsdoc.org/
 */
angular.module('profilePage').service('ProfileService',
		[ '$http', function($http) {

			this.getListPostFeeds = function(callBack) {
				$http({
					method : 'GET',
					url : 'getListPostFeeds'
				}).then(function successCallback(response) {
					// this callback will be called asynchronously
					// when the response is available

					callBack(true, response.data);
				}, function errorCallback(response) {
					// called asynchronously if an error occurs
					// or server returns response with an error status.
					callBack(false, response.data);
				});
			};

			this.getProfile = function(callBack) {
				$http({
					method : 'GET',
					url : 'getProfile'		
				}).then(function successCallback(response) {
					// this callback will be called asynchronously
					// when the response is available

					callBack(true, response.data);
				}, function errorCallback(response) {
					// called asynchronously if an error occurs
					// or server returns response with an error status.
					callBack(false, response.data);
				});
			};
			
		} ]);