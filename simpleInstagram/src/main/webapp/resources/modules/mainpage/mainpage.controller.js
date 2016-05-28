/**
 * http://usejsdoc.org/
 */
angular.module('mainpage').controller('mainpageController',
		[ '$scope','MainPageService',function($scope,MainPageService) {
			
			$scope.photoFeed = {
					uploadedFilename :'',
					uploadedFileUrl :'',
					description :''
			};
			
			$scope.createPhotoFeed = function(){
				
				
				$scope.photoFeed.uploadedFilename = $("#photoFeed input[name=uploadedFilename]").val();
				$scope.photoFeed.uploadedFileUrl = $("#photoFeed input[name=uploadedFileUrl]").val();
				
				alert(JSON.stringify($scope.photoFeed));
			}
			
		} ]);