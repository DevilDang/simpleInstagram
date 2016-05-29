/**
 * http://usejsdoc.org/
 */
angular
		.module('photoFeedPage')
		.controller(
				'photoFeedController',
				[
						'$scope',
						'$interval',
						'PhotoFeedService',
						function($scope,$interval, PhotoFeedService) {
							
							$scope.imgUrl = "";
							$scope.username = "";
							$scope.description = "";
							$scope.comments = [];	

							if(window.photoFeedID != undefined){
								
								PhotoFeedService.getPhotoFeed(window.photoFeedID, function(noError,data){
									
									if(noError){
										$scope.imgUrl = data.imgUrl;
										$scope.username = data.username;
										$scope.description = data.description;
										$scope.comments = data.comments;	
									}
																	
								});
							}
							
							
							$scope.addComment = function(){
								$scope.commentContent
								PhotoFeedService.addComment($scope.commentContent,window.photoFeedID,function (noError,data){
									
									if(noError){
										
										PhotoFeedService.getListComments(window.photoFeedID,function(noError,data){
											
											if(noError){
												$scope.comments = data;
											}
											
										});
										
									}
								});
								
								
							}
								

						} ]);