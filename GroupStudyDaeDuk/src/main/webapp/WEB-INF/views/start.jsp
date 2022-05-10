<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>start.jsp</title>
</head>
<body>

	<!-- 
		resources : 사용자가 접속할 수 있는 폴더
		WEB-INF : 사용자가 접속할 수 없는 폴더
		resources폴더에 css, js, image등을 넣어두면 
		후에 경로를 입력하여 불러올 수 있다.
	 -->

	<% for(int i=1; i<=5; i++){ %>
		<h1>405호 짜잔</h1>
	<% } %>
</body>
</html>