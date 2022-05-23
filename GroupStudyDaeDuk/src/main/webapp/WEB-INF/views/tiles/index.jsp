<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix = "tiles" uri = "http://tiles.apache.org/tags-tiles" %>
<c:set var="CONTEXT_PATH" value="${pageContext.request.contextPath}" scope="application"/>
<c:set var="RESOURCES_PATH" value="${CONTEXT_PATH}/resources" scope="application"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${RESOURCES_PATH}/css/common.css">
<title><tiles:insertAttribute name="title" /></title>
</head>
<body>
	<tiles:insertAttribute name="aside" />
	<tiles:insertAttribute name="header" />
	<div id="body">
		<tiles:insertAttribute name="body" /> 
	</div>
	<%-- <tiles:insertAttribute name="footer" /> --%>
</body>
</html>