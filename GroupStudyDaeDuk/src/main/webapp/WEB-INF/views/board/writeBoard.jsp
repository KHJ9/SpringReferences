<%@page import="kr.or.ddit.domain.BoardVO"%>
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
        
        #writeBtn, #updateBtn {
            float : right;
        }
	</style>    
</head>
<body>
	<div class="container">
        <h2>간이 게시판</h2>
        <p>작성란</p> 
        <% BoardVO board = (BoardVO)request.getAttribute("board"); %>
        <form id="writeForm" method="post">
	        <div id="titleDiv" class="form-group">
	            <label for="title">제목:</label>
	            <input id="title" type="text" name="boardTitle" class="form-control" id="title"
	            	value = "<%if(board!=null){out.print(board.getBoardTitle());}%>">
	        </div>
			<div id="contentDiv" class="form-group">
				<label for="content">내용:</label>
				<textarea class="form-control" name="boardContent" rows="5" id="content"><%if(board!=null){out.print(board.getBoardContent());}%></textarea>
			</div>
			<input type="hidden" name="boardWriter" value="<sec:authentication property="principal.username"/>">
			<input type="hidden" name="boardNum" 
				value="<%if(board!=null){out.print(board.getBoardNum());}%>">
			<% if(board==null) { %>
				<button id="writeBtn" type="submit" class="btn btn-success">글쓰기</button>
			<% } else { %>
				<button id="updateBtn" type="submit" class="btn btn-primary">수정</button>
			<% } %>
		</form>
		<script>
			const writeForm = document.querySelector("#writeForm");
			<% if(board==null) { %>
				writeForm.action="<%=request.getContextPath()%>/board/writeBoard";
			<% } else { %>
				writeForm.action="<%=request.getContextPath()%>/board/updateBoard";
			<% } %>
		</script>
    </div>
</body>
</html>