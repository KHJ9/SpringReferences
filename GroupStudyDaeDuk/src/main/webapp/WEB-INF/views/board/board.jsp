<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.domain.BoardVO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>간이 게시판</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> 
    <style>
        .container {
            padding-top : 100px;
        }

        .table {
            margin-bottom : 50px;
        }

        .pagination {
            margin : -10px 0;
        }

        #writeBtn {
            float : right;
        }

        #searchInput {
            width : 100px;
            display : inline-block;
        }

        #searchDiv {
            float : right;
        }

        #searchInput, #searchBtn {
            height : 30px;
        }
    </style>
</head>
<body>
	<div class="container">
        <h2>간이 게시판</h2>
        <p>나중에 참고할 간이용 게시판</p> 
        
        <div id="searchDiv" class="form-group">
            <label for="usr">검색:</label>
            <input id="searchInput" type="text" class="form-control" id="usr">
            <button id="searchBtn" type="button" class="btn btn-primary">검색</button>
        </div>

        <table class="table table-striped">
          <thead>
            <tr>
              <th>번호</th>
              <th>작성자</th>
              <th>제목</th>
            </tr>
          </thead>
          <tbody>
          	<%
				List<BoardVO> boardList = (List<BoardVO>)request.getAttribute("board");
				for(BoardVO board : boardList){
					%>
						<tr>
			              <td><%=1%></td>
			              <td>
			              	<a href="<%=request.getContextPath()%>/board/viewBoard?boardNum=<%=board.getBoardNum()%>">
			              		<%=board.getBoardWriter()%>
		              		</a>
	              		  </td>
		              	  <td>
			              	<a href="<%=request.getContextPath()%>/board/viewBoard?boardNum=<%=board.getBoardNum()%>">
			              		<%=board.getBoardTitle()%>
		              		</a>
	              		  </td>
			            </tr>	
					<%
				}
			%>
          </tbody>
        </table>
        <ul class="pager">
            <li><a href="#">Previous</a></li> 
            <li>
	            <ul class="pagination pagination-sm">
	                <li><a href="#">1</a></li>
	                <li><a href="#">2</a></li>
	                <li><a href="#">3</a></li>
	                <li class="disabled"><a href="#">4</a></li>
	                <li><a href="#">5</a></li>
	            </ul>
            </li>
            <li><a href="#">Next</a></li>
            <li><button id="writeBtn" type="button" class="btn btn-success">글쓰기</button></li>
        </ul>
    </div>
    <script>
		const writeBtn = document.querySelector("#writeBtn");
		
		writeBtn.onclick = function(){
			location.href = "<%=request.getContextPath()%>/board/writeBoard";
		}
    </script>
</body>
</html>