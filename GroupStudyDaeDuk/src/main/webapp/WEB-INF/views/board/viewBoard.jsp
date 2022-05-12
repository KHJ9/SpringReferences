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
        <table id="viewTable" class="table">
		    <tbody>
		    	<tr>
			        <th class="col-md-2">제목</th>
			        <td class="col-md-10">최종 프로젝트</td>
		      	</tr>
			    <tr>
			        <th>작성자</th>
			        <td>김현준</td>
			    </tr>
			    <tr>
			        <th>내용</th>
			        <td>빨리 취업하고 싶다.</td>
			    </tr>
		    </tbody>
		</table>
		<div id="btns" class="container-fluid">
			<button id="updateBtn" type="button" class="btn btn-primary">수정</button>
			<button id="deleteBtn" type="button" class="btn btn-danger">삭제</button>
		</div>
    </div>
</body>
</html>