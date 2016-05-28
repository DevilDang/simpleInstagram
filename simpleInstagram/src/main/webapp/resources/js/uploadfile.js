/**
 * http://usejsdoc.org/
 */
$(document).ready(
		function() {
			$('progress').hide();
			$("input:file").change(
					function() {
						$('progress').show();
						var file = document.getElementById('file').files;
						var formData = new FormData();
						formData.append("file",file[0]);
					
						$.ajax({
							url : "/simpleInstagram/uploadFile", // Server script to process
													// data
							type : 'POST',
							xhr : function() { // Custom XMLHttpRequest
								var myXhr = $.ajaxSettings.xhr();
								if (myXhr.upload) {
									myXhr.upload.addEventListener('progress',
											progressHandlingFunction, false);
								}
								return myXhr;
							},
							// Ajax events
							beforeSend : beforeSendHandler,

							error : errorHandler,
							// Form data
							data : formData,
							// Options to tell jQuery not to process data or
							// worry about content-type.
							cache : false,
							contentType : false,
							processData : false,
							success : function(e) {
								$("#uploadedImg").attr("src",e.uploadedFileUrl);								
								$("#photoFeed input[name=uploadedFilename]").val(e.uploadedFileName);
								$("#photoFeed input[name=uploadedUrlName]").val(e.uploadedFileUrl);
							}

						});
					});

			function beforeSendHandler() {
			}

			function errorHandler(e) {
				alert("An error occurred");
			}

			function progressHandlingFunction(e) {
				if (e.lengthComputable) {
					$('progress').attr({
						value : e.loaded,
						max : e.total
					});
				}
			}
		});