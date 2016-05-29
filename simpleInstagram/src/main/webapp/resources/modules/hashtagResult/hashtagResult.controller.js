/**
 * http://usejsdoc.org/
 */
angular.module('hashtagResultPage').controller(
		'resultHashTagController',
		[
				'$scope',
				'$interval',
				'HashtagResultService',
				function($scope, $interval, HashtagResultService) {

					if(window.hashtag !== undefined){
						HashtagResultService.searchForHashTag(window.hashtag,
								function(noError, data) {
						
							if(noError){
								$scope.photoFeeds = data;
							}
							

						});
					}
					

				} ]);