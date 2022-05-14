<%@page import="kr.or.ddit.domain.BoardVO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시글</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> 
	<style>
		.container {
            padding-top : 100px;
        }
        
        #btns {
        	display : inline-block;
            float : right;
        }
	</style>    
</head>
<body>
	<div class="container">
        <h2>간이 게시판</h2>
        <p>게시글</p> 
        <% BoardVO board = (BoardVO)request.getAttribute("board"); %>
        <table id="viewTable" class="table">
		    <tbody>
		    	<tr>
			        <th style="width : 150px;">제목</th>
			        <td><%=board.getBoardTitle()%></td>
		      	</tr>
			    <tr>
			        <th>작성자</th>
			        <td><%=board.getBoardWriter()%></td>
			    </tr>
			    <tr>
			        <th>내용</th>
			        <td><%=board.getBoardContent()%></td>
			    </tr>
		    </tbody>
		</table>
		<div id="btns" class="container-fluid">
			<button id="updateBtn" type="button" class="btn btn-primary">수정</button>
			<button id="deleteBtn" type="button" class="btn btn-danger">삭제</button>
		</div>
		<script>
			const updateBtn = document.querySelector("#updateBtn");
			const deleteBtn = document.querySelector("#deleteBtn");
			const boardNum = '<%=board.getBoardNum()%>';
			
			deleteBtn.onclick = function(){
				var formData = new FormData();
				
				formData.append('boardNum', boardNum);
				var xml = new XMLHttpRequest();
				xml.open("POST", "<%=request.getContextPath()%>/board/deleteBoard", true);
				xml.send(formData);
			}
		</script>
    </div>
</body>
</html>