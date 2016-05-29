/**
 * http://usejsdoc.org/
 */
angular
		.module('mainpage')
		.controller(
				'mainpageController',
				[
						'$scope',
						'$interval',
						'MainPageService',
						function($scope, $interval, MainPageService) {

							$scope.isUploadedPhoto = false;

							$scope.photoFeed = {
								uploadedFilename : '',
								uploadedFileUrl : '',
								description : ''
							};

							$scope.getListPhotoFeed = function() {
								MainPageService.getListPhotoFeed(function(
										noError, data) {
									if (noError) {
										$scope.photoFeeds = data;
									}
								})
							}

							$scope.getListPhotoFeed();

							$interval(function() {

								$scope.getListPhotoFeed();

							}, 60 * 1000 * 5);

							$scope.resetFormCreateFeed = function() {
								$scope.photoFeed = {
									uploadedFilename : '',
									uploadedFileUrl : '',
									description : ''
								};
								$("#uploadedImg").attr("src", "");
								$('progress').hide();
								var file = document.getElementById('file');
								file.value="";
								 $(
									"#photoFeed input[name=uploadedUrlName]")
									.val("");
								 
								 $(
									"#photoFeed input[name=uploadedFilename]")
									.val("");
							}

							$scope.createPhotoFeed = function() {

								$scope.photoFeed.uploadedFilename = $(
										"#photoFeed input[name=uploadedFilename]")
										.val();
								$scope.photoFeed.uploadedFileUrl = $(
										"#photoFeed input[name=uploadedUrlName]")
										.val();

								if ($scope.photoFeed.uploadedFileUrl != '') {
									MainPageService
											.createNewPhotoFeed(
													$scope.photoFeed,
													function(noError, data) {

														if (noError) {
															$scope
																	.getListPhotoFeed();
															$scope
																	.resetFormCreateFeed();

															alert("Create a new feed success");
														}

													});
								} else {
									alert("Please upload a photo");
								}

							}

						} ]);