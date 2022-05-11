<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- jsp 태그 라이브러리 -->
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유저 상세정보 페이지</title>
</head>
<body>
	<h1>ADMIN</h1>
	<p><sec:authentication property="principal"/></p>
	<p><sec:authentication property="principal.member"/></p>
	<p><sec:authentication property="principal.member.userName"/></p>
	<p><sec:authentication property="principal.username"/></p>
	<p><sec:authentication property="principal.member.authList"/></p>
</body>
</html>