<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비동기 통신</title>
<script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
</head>
<body>
	<input type="button" value="ajax" onclick="goAjax();">
</body>
<script>
	function goAjax(){
		$.ajax({
			url : 'getAjax',
			type : 'GET',
			data : null,
			success : function(data){
				console.log(data);
			},
			error : function(data){
				alert("에러 : " + data.status);
			},
			dataType : 'json'
		});
	}
</script>
</html>