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
            padding-top : 60px;
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
	<% List<BoardVO> boardList = (List<BoardVO>)request.getAttribute("board"); %>
	<div class="container">
        <h2>간이 게시판</h2>
        <p>나중에 참고할 간이용 게시판</p> 
        
        <div id="searchDiv" class="form-group">
            <label for="usr">검색:</label>
            <input id="searchInput" type="text" class="form-control">
            <button id="searchBtn" type="button" class="btn btn-primary">검색</button>
        </div>

        <table class="table table-striped">
          <thead>
            <tr>
              <th style="width:20%;">번호</th>
              <th style="width:20%;">작성자</th>
              <th>제목</th>
            </tr>
          </thead>
          <tbody>
          	<%
				for(BoardVO board : boardList){
					%>
						<tr>
			              <td><%=board.getBoardRowNum()%></td>
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
        	<% 
	        	String searchText = null; 
        		if(boardList.size() != 0) {
	        		BoardVO board = boardList.get(0);
	        		searchText = board.getSearchText();
	        		int cur = board.getCurrentPageNum();
	        		int tot = board.getTotalPageNum(); 
	        		int page_area = 5;
	        		int page_start = 1;
	        		int page_end = page_start + page_area - 1;
	        		
	        		while(cur - page_start > page_area - 1){
	        			page_start += page_area;
	        			page_end = page_start + page_area - 1;
	        		}
	        		
	        		if(page_end > tot) page_end = tot;
	        		if(page_start != 1){
	        			%>
	        				<li>
	        					<a href="<%=request.getContextPath()%>/board/getBoard?currentPageNum=<%=page_start-1%>&searchText=<%if(searchText != null) out.print(searchText);%>">
	        						Previous
	       						</a>
	     					</li>
	    				<%
	        		}
        	%>
            <li>
	            <ul class="pagination pagination-sm">
	                <%
	                	for(int i=page_start; i<=page_end; i++) {
	                		if(i == cur) {
	                %>
				                <li class="disabled">
				                	<a href="#">
				                		<%=i%>
			                		</a>
			                	</li>
	                <%
	                		} else {
             		%>
	                			<li>
	                				<a href="<%=request.getContextPath()%>/board/getBoard?currentPageNum=<%=i%>&searchText=<%if(searchText != null) out.print(searchText);%>">
	                					<%=i%>
                					</a>
                				</li>
	                <%
	                		}
	                	}
	                %>
	            </ul>
            </li>
            <%
		            if(tot - page_start >= page_area){
	        			%>
	        				<li>
	        					<a href="<%=request.getContextPath()%>/board/getBoard?currentPageNum=<%=page_end+1%>&searchText=<%if(searchText != null) out.print(searchText);%>">
	        						Next
	        					</a>
	        				</li>
	        			<%
	        		}
        		}
        	%>
            <li><button id="writeBtn" type="button" class="btn btn-success">글쓰기</button></li>
        </ul>
    </div>
    <script>
		const searchInput = document.querySelector("#searchInput");
		const searchBtn = document.querySelector("#searchBtn");
		const writeBtn = document.querySelector("#writeBtn");
		if(<%=searchText%> != "null")
			searchInput.value = <%=searchText%>;	
		
		searchInput.onkeypress = function(){
			if(event.code == "Enter"){
				searchBtn.click();
			}
		}
			
		searchBtn.onclick = function(){
			var searchText = searchInput.value;
			location.href = "<%=request.getContextPath()%>/board/getBoard?searchText="+searchText;
		}
		
		writeBtn.onclick = function(){
			location.href = "<%=request.getContextPath()%>/board/writeBoard";
		}
    </script>
</body>
</html>