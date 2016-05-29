<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<script type="text/javascript">
		window.photoFeedID = "${photoFeedID}";
</script>
<spring:url value="/resources/modules/photofeed/photofeed.module.js"
	var="photofeedPageModuleJS" />
<script type="text/javascript" src="${photofeedPageModuleJS}"></script>

<spring:url value="/resources/modules/photofeed/photofeed.controller.js"
	var="photofeedPageControllerJS" />
<script type="text/javascript" src="${photofeedPageControllerJS}"></script>

<spring:url value="/resources/modules/photofeed/photofeed.service.js"
	var="photofeedPageServiceJS" />
<script type="text/javascript" src="${photofeedPageServiceJS}"></script>

<script type="text/javascript">
	var mainApplicationModuleName = 'simpleInstagram';
	var mainApplicationModule = angular.module(mainApplicationModuleName,
			[ 'photoFeedPage','ngSanitize' ], function($interpolateProvider) {
				$interpolateProvider.startSymbol('[[');
				$interpolateProvider.endSymbol(']]');
			});

	angular.element(document).ready(function() {
		angular.bootstrap(document, [ mainApplicationModuleName ]);
	});
</script>