/**
 * http://usejsdoc.org/
 */
angular
		.module('profilePage')
		.controller(
				'profileController',
				[
						'$scope',
						'$interval',
						'ProfileService',
						function($scope,$interval, ProfileService) {
							
							ProfileService.getProfile(function(noError,data){
								if(noError){
									$scope.username = data.username;
									$scope.email = data.email;
									$scope.countPostFeed = data.countPostFeed;
									$scope.countFollower = data.countFollower;
									$scope.countFollowing = data.countFollowing;
																
								}
							});
							
												
							$scope.buildGridPostFeed = function (){
								$scope.rows = [];
								var length ;	
								var modulo = $scope.postFeeds.length%3;
								if(modulo === 0)
								{
									var length = $scope.postFeeds.length;
								}else{
									var length = $scope.postFeeds.length - modulo
								}
								
								for(var i =0;i<length;i+=3 ){
									
									var columns = [];
									for(var j = 0;j<3;j++){
										columns[j] = $scope.postFeeds[i + j];
									}
									
									$scope.rows.push(columns);
								}
								
								if(modulo == 1){
									var columns = [];
									columns[0] =  $scope.postFeeds[$scope.postFeeds.length - 1];
									$scope.rows.push(columns);
									
								}else if(modulo == 2){
									var columns = [];
									columns[0] =  $scope.postFeeds[$scope.postFeeds.length - 2];
									columns[1] =  $scope.postFeeds[$scope.postFeeds.length - 1];
									
									$scope.rows.push(columns);
								}
										
							}
								
							ProfileService.getListPostFeeds(function(noError,data){
								if(noError){
									$scope.postFeeds = data;
									$scope.buildGridPostFeed();
								}
							});
						} ]);