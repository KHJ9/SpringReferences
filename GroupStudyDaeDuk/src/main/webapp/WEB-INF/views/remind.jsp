<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>김현준</title>
</head>
<body>
	<!-- 컨트롤러에서 보낸 모델을 가져올 때는 달러+중괄호를 작성하여 속성명을 입력하면 된다. -->
	<h1>${name}</h1>
	
	<!-- ${name} -->  <!-- 달러+중괄호를 인식한다. -->
	<%-- ${name} --%> <!-- 달러+중괄호를 인식하지 않도록 한다. 자바주석은 이 기호를 알고 있기 때문이다. -->
	
	<!-- 묶음데이터, 모델 안의 컬렉션이 있다면 toString으로 먼저 값을 확인해보자. -->
	<h1>${song}</h1> <!-- 배열을 출력한다. -->
	<h1>${habit[0]}</h1>
	<h1>${habit.size()}</h1>
</body>
</html>