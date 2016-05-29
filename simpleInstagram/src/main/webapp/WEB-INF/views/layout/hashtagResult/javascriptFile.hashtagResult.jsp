<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<script type="text/javascript">
		window.hashtag = "${hashtag}";
</script>

<spring:url value="/resources/modules/hashtagResult/hashtagResult.module.js"
	var="hashtagResultPageModuleJS" />
<script type="text/javascript" src="${hashtagResultPageModuleJS}"></script>

<spring:url value="/resources/modules/hashtagResult/hashtagResult.controller.js"
	var="hashtagResultPageControllerJS" />
<script type="text/javascript" src="${hashtagResultPageControllerJS}"></script>

<spring:url value="/resources/modules/hashtagResult/hashtagResult.service.js"
	var="hashtagResultPageServiceJS" />
<script type="text/javascript" src="${hashtagResultPageServiceJS}"></script>

<script type="text/javascript">
	var mainApplicationModuleName = 'simpleInstagram';
	var mainApplicationModule = angular.module(mainApplicationModuleName,
			[ 'hashtagResultPage','ngSanitize' ], function($interpolateProvider) {
				$interpolateProvider.startSymbol('[[');
				$interpolateProvider.endSymbol(']]');
			});

	angular.element(document).ready(function() {
		angular.bootstrap(document, [ mainApplicationModuleName ]);
	});
</script>