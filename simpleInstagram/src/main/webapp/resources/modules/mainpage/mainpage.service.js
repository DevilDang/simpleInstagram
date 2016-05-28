/**
 * http://usejsdoc.org/
 */
angular.module('mainpage').service('MainPageService',
		[ '$http', function($http) {

			this.getListPhotoFeed = function(callBack) {
				$http({
					method : 'POST',
					url : 'getListPhotoFeed',
					headers : {
						'Content-Type' : 'application/json'
					}
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

			this.createNewPhotoFeed = function(photoFeedInfo, callBack) {
				$http({
					method : 'POST',
					url : 'createNewPhotoFeed',
					headers : {
						'Content-Type' : 'application/json'
					},
					data : JSON.stringify(photoFeedInfo), 
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