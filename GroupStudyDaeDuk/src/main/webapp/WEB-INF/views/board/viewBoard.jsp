<%@page import="kr.or.ddit.domain.BoardVO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
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
    <c:set var="boardPath" value="${pageContext.request.contextPath}/board"></c:set>
	<c:set var="replyPath" value="${pageContext.request.contextPath}/reply"></c:set>
	<style>
		.container {
            padding-top : 60px;
        }
        
        #btns {
        	display : inline-block;
            float : right;
        }
        
        #replyInsertDiv {
        	width : 100%;
        }
        
        #replyListDiv {
        	padding-top : 0;
        }
        
        textarea {
        	resize: none;
        }
        
        #replyContent {
        	margin-bottom : 30px;
        }
        
        #replyBtn {
        	width : 30px;
        	height : 20px;
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
		<div id="btns">
			<button id="updateBtn" type="button" class="btn btn-primary">수정</button>
			<button id="deleteBtn" type="button" class="btn btn-danger">삭제</button>
			<button id="listBtn" type="button" class="btn btn-info">목록</button>
		</div>
		<div id="replyInsertDiv" class="container">
			<form id="writeReplyForm">
				<textarea class="form-control" name="replyContent" rows="5" id="replyContent"></textarea>
				<input type="hidden" name="boardNum" value="${board.boardNum}"/>
				<div id="btns">
					<button id="insertBtn" type="button" class="btn btn-success">등록</button>
				</div>
			</form>
		</div>
		<div id="replyListDiv" class="container">
			<h3>댓글</h3>
			<table id="viewTable" class="table">
			    <tbody id="replyTbody">
			    	
			    </tbody>
			</table>
		</div>
		<script>
			const writeReplyForm = document.querySelector("#writeReplyForm");
			const replyTbody = document.querySelector("#replyTbody");
			const updateBtn = document.querySelector("#updateBtn");
			const deleteBtn = document.querySelector("#deleteBtn");
			const insertBtn = document.querySelector("#insertBtn");
			const listBtn = document.querySelector("#listBtn");
			const boardNum = '<%=board.getBoardNum()%>';
			let formData = new FormData();
			
			let replyAjax = function(requestType, formParam){
				let xhr = new XMLHttpRequest();
				
				if(requestType == "select"){
					xhr.open("get", "${replyPath}/"+requestType+"Reply?boardNum=${board.boardNum}", true);
				} else {
					formData = new FormData(writeReplyForm);	
					xhr.open("post", "${replyPath}/"+requestType+"Reply", true);
				}
				
				xhr.onreadystatechange = function () {
				    if(xhr.readyState == 4 && xhr.status == 200) {
				    	console.log(xhr.responseText);
				    	let replyList = JSON.parse(xhr.responseText);
				    	replyTbody.innerHTML = "";
				    	for(let i=0; i<replyList.length; i++){
				    		let tr = document.createElement("tr");
				    		let th = document.createElement("th");
				    		let td1 = document.createElement("td");
				    		let td2 = document.createElement("td");
				    		let textField = document.createElement("input");
				    		let button1 = document.createElement("button");
				    		let button2 = document.createElement("button");
				    		
				    		th.style.width = "150px";
				    		th.textContent = replyList[i].replyWriter;
				    		td2.style.width = "150px";
				    		
				    		textField.setAttribute("type", "text");
				    		textField.value = replyList[i].replyContent;
				    		
				    		button1.setAttribute("id", "updateReplyBtn replyBtn");
				    		button1.setAttribute("type", "button");
				    		button1.classList.add("btn");
				    		button1.classList.add("btn-primary");
				    		button1.style.marginRight = "3px";
				    		button1.textContent = "수정";
				    		
				    		button1.onclick = function(){
				    			let formData2 = new FormData();
				    			formData2.append("replyNum", replyList[i].replyNum);
				    			formData2.append("boardNum", replyList[i].boardNum);
				    			formData2.append("replyWriter", replyList[i].replyWriter);
				    			formData2.append("replyContent", textField.value);
			    				replyAjax("update", formData2);
			    			}
				    		
				    		button2.setAttribute("id", "deleteReplyBtn replyBtn");
				    		button2.setAttribute("type", "button");
				    		button2.classList.add("btn");
				    		button2.classList.add("btn-danger");
				    		button2.textContent = "삭제";
				    		
				    		let formData3 = new FormData();
			    			formData3.append("replyNum", replyList[i].replyNum);
			    			formData3.append("boardNum", replyList[i].boardNum);
				    		button2.onclick = replyAjax.bind(this, "delete", formData3);
				    		
				    		td1.appendChild(textField);
				    		
				    		td2.appendChild(button1);
				    		td2.appendChild(button2);
				    		
				    		tr.appendChild(th);
				    		tr.appendChild(td1);
				    		tr.appendChild(td2);
				    		
				    		replyTbody.appendChild(tr);
				    	}
				    }
				}
				
				if(requestType == "select") {
					xhr.send();	
				} else if(requestType == "insert") {
					xhr.send(formData);
				} else {
					xhr.send(formParam);	
				} 
			}
			
			replyAjax("select");
			
			insertBtn.onclick = function(){
				event.preventDefault();
				replyAjax("insert");
			}
			
			listBtn.onclick = function(){
				location.href="<%=request.getContextPath()%>/board/getBoard";
			}
			
			updateBtn.onclick = function(){
				location.href="<%=request.getContextPath()%>/board/updateBoard?boardNum=<%=board.getBoardNum()%>";
			}
			
			deleteBtn.onclick = function(){
				var formData = new FormData();
				
				formData.append('boardNum', boardNum);
				var xml = new XMLHttpRequest();
				xml.open("POST", "<%=request.getContextPath()%>/board/deleteBoard", true);
				xml.onreadystatechange = function() {
		            if(xml.readyState== 4 && xml.status == 200) { // 성공 시
		            	alert(xml.responseText);
		                location.href="<%=request.getContextPath()%>/board/getBoard";
		            }
		        }
				xml.send(formData);
			}
		</script>
    </div>
</body>
</html>