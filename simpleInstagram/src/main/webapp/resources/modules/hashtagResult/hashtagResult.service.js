/**
 * http://usejsdoc.org/
 */
angular.module('hashtagResultPage').service('HashtagResultService',
		[ '$http', function($http) {

			this.searchForHashTag = function(hashtag,callBack) {
				$http({
					method : 'GET',
					url : 'searchForHashTag?hashtag=' + hashtag
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