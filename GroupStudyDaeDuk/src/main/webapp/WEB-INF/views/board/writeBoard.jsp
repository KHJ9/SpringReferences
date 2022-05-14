<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>작성란</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> 
	<style>
		.container {
            padding-top : 100px;
        }
        
        #writeBtn {
            float : right;
        }
	</style>    
</head>
<body>
	<div class="container">
        <h2>간이 게시판</h2>
        <p>작성란</p> 
        <form id="writeForm" action="<%=request.getContextPath()%>/board/insertBoard" method="post">
	        <div id="titleDiv" class="form-group">
	            <label for="title">제목:</label>
	            <input id="title" type="text" name="boardTitle" class="form-control" id="title">
	        </div>
			<div id="contentDiv" class="form-group">
				<label for="content">내용:</label>
				<textarea class="form-control" name="boardContent" rows="5" id="content"></textarea>
			</div>
			<input type="hidden" name="boardWriter" value="<sec:authentication property="principal.username"/>">
			<button id="writeBtn" type="submit" class="btn btn-success">글쓰기</button>
		</form>
    </div>
</body>
</html>