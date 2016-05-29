<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<spring:url value="/resources/modules/profile/profile.module.js"
	var="profilePageModuleJS" />
<script type="text/javascript" src="${profilePageModuleJS}"></script>

<spring:url value="/resources/modules/profile/profile.controller.js"
	var="profilePageControllerJS" />
<script type="text/javascript" src="${profilePageControllerJS}"></script>

<spring:url value="/resources/modules/profile/profile.service.js"
	var="profilePageServiceJS" />
<script type="text/javascript" src="${profilePageServiceJS}"></script>

<script type="text/javascript">
	var mainApplicationModuleName = 'simpleInstagram';
	var mainApplicationModule = angular.module(mainApplicationModuleName,
			[ 'profilePage','ngSanitize' ], function($interpolateProvider) {
				$interpolateProvider.startSymbol('[[');
				$interpolateProvider.endSymbol(']]');
			});

	angular.element(document).ready(function() {
		angular.bootstrap(document, [ mainApplicationModuleName ]);
	});
</script>