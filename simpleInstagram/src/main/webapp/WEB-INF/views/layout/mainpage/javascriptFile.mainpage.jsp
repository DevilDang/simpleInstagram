<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<spring:url value="/resources/js/uploadfile.js" var="uploadJS" />

<script src="${uploadJS}" type="text/javascript"></script>

<spring:url value="/resources/modules/mainpage/mainpage.module.js"
	var="mainPageModuleJS" />
<script type="text/javascript" src="${mainPageModuleJS}"></script>

<spring:url value="/resources/modules/mainpage/mainpage.controller.js"
	var="mainPageControllerJS" />
<script type="text/javascript" src="${mainPageControllerJS}"></script>

<spring:url value="/resources/modules/mainpage/mainpage.service.js"
	var="mainPageServiceJS" />
<script type="text/javascript" src="${mainPageServiceJS}"></script>

<script type="text/javascript">
	var mainApplicationModuleName = 'simpleInstagram';
	var mainApplicationModule = angular.module(mainApplicationModuleName,
			[ 'mainpage' ], function($interpolateProvider) {
				$interpolateProvider.startSymbol('[[');
				$interpolateProvider.endSymbol(']]');
			});

	angular.element(document).ready(function() {
		angular.bootstrap(document, [ mainApplicationModuleName ]);
	});
</script>