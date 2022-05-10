<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>폼</title>
</head>
<body>
	<!-- form태그는 기본적으로 get방식으로 되어있다. -->
	<!-- controller에 매핑한 경로를 여기 action에 입력해주면 된다. -->
	<!-- request.getContextPath() : 루트 경로를 가져오기 위해 사용한다. -->
	<form action="<%=request.getContextPath()%>/remind/postHyunjun" method="post">
		이름 : <input type="text" name="nm_name" value=""><br>
		노래 : <input type="text" name="nm_song" value="" required="required"><br>
		<!-- form태그 안의 button태그는 default로 submit기능을 가진다. -->
		<!-- <button>전송</button> -->
		<button type="submit">전송</button>
	</form>
</body>
</html>









