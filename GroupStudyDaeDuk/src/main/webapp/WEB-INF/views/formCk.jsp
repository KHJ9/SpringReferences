<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/user/login" method="post">
        <input type="text" name="nm_admin" id="id_admin" value="admin">
        <input type="submit" value="전송">
    </form>
</body>
</html>