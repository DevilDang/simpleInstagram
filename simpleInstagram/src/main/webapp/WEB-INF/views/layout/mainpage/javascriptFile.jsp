<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<spring:url value="/resources/js/uploadfile.js" var="uploadJS" />
<script src="${uploadJS}"></script>	