<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><tiles:getAsString name="title" /></title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<tiles:insertAttribute name="customCSSFiles" />
</head>
<body>

	<!-- header -->
	<tiles:insertAttribute name="header" />
	<!-- header -->

	<!-- content -->
	<tiles:insertAttribute name="body" />
	<!-- content -->

	<!-- footer -->
	<tiles:insertAttribute name="footer" />
	<!-- footer -->

	<tiles:insertAttribute name="customJavascriptFiles" />
</body>
</html>