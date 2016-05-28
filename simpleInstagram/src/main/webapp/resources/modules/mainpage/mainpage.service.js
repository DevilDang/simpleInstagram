/**
 * http://usejsdoc.org/
 */
angular
		.module('mainpage')
		.service('MainPageService',
				    ['$http',
				     function ($http){
				    	
						this.getListReturnAddress = function(callBack) {
							$http({
								method : 'POST',
								url : '/getListReturnAddress',
								headers : {
									'Content-Type' : 'application/json'
								},
								data : {
									'pageIndex' : 0
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
				    	
				    
}]);