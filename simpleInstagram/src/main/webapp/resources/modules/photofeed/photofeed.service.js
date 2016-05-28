/**
 * http://usejsdoc.org/
 */
angular.module('photoFeedPage').service('PhotoFeedService',
		[ '$http', function($http) {

			this.getListComments = function(callBack) {
				$http({
					method : 'POST',
					url : 'getListComments',
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

			this.getPhotoFeed = function(photoFeedID, callBack) {
				$http({
					method : 'GET',
					url : 'getPhotoFeed?photoFeedID='+photoFeedID
					
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
			
			
			this.addComment = function(content,photoFeedId, callBack) {
				$http({
					method : 'GET',
					url : 'addComment?content='+content+"&photoFeedId="+photoFeedId
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