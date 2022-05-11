<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>나의 로그인 폼 페이지</h1>
<h2>가장 많이 헷갈리는 부분 : action URL</h2>
<h2>스프링 security는 post 방식의 /login 맵핑을 통해 실제 로그인 처리를 해 준다.</h2>
<form action="<%=request.getContextPath()%>/login" method="post">
   	 아이디<input type="text" name="username">
   	 패스워드<input type="password" name="password"><br>
   	 
   	<!-- form의 method가 post인 경우에만 다음과 같은 줄을 추가한다.(ajax일 시에도 헤더에 추가해야 한다.) -->
   	<!-- csrf 공격을 막기 위함 -->
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <button>로그인</button>
</form>
</body>
</html>