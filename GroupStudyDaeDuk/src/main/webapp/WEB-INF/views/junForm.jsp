<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax Form</title>
<style>
	#id_disp {
		width : 200px;
		height : 200px;
		border : 2px solid orange;
		text-align : center;
	}
</style>
</head>
<body>
	<div id="id_disp" style="margin:5px;">[ 결과 ]</div>
	<!-- 주의 : 루트 경로가 "/"가 아니면 getContextPath를 꼭 붙일 것! -->
	<form id="id_form" action="<%=request.getContextPath()%>/remind/jun2" 
	      method="post" enctype="multipart/form-data">
		첫번째 수 <input type="text" name="nm_first"  value="1" required><br>
		두번째 수 <input type="text" name="nm_second" value="2" required><br>
		연산 <select name="nm_sel">
				<option value="p" selected>더하기</option>
				<option value="m">빼기</option>
				<option value="g">곱하기</option>
				<option value="n">나누기</option>
		   </select><br>
		<input type="file" id="id_file" name="nm_file" multiple><br>
		<button type="submit">전송</button>
	</form>
	
	<script>
		var v_disp = document.querySelector("#id_disp");
		var v_form = document.querySelector("#id_form");
		var v_files = document.querySelector("#id_file");
		
		var f_DataString = function() {
			let retStr = "";
			// v_form.elements 하면 자동으로 사용자가 입력한 값을 가져온다.
			for(let i=0; i<v_form.elements.length; i++){
				retStr += encodeURIComponent(v_form.elements[i].name) +
				"=" + encodeURIComponent(v_form.elements[i].value);
				retStr += "&";
			}
			retStr = retStr.substring(0, retStr.length-3);
			return retStr; // 마지막 & 빼기
		}
		
		var f_submit = function() {
			// 기존의 submit 이벤트 기능을 막는다.
			event.preventDefault();
			const xhr = new XMLHttpRequest();
			xhr.open("post", `<%=request.getContextPath()%>/remind/jun`, true); // true : 비동기
			// 일반적으로 post방식을 실행할 때는 원래 다음과 같은 header를 붙여야 한다.
			// jquery ajax의 경우 post방식일 때 header를 자동으로 붙여준다.
			xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			xhr.onreadystatechange = function() {
	            if(xhr.readyState== 4 && xhr.status == 200) { // 성공 시
	                v_disp.textContent = xhr.responseText; // 결과값
	            }
	        }
			var parameter = f_DataString();
			xhr.send(parameter); // ajax 실행
		}
		
		var f_submit1 = function() {
			// 기존의 submit 이벤트 기능을 막는다.
			event.preventDefault();
			const xhr = new XMLHttpRequest();
			xhr.open("post", `<%=request.getContextPath()%>/remind/jun2`, true); // true : 비동기
			// 일반적으로 post방식을 실행할 때는 원래 다음과 같은 header를 붙여야 한다.
			
			// jquery ajax의 경우 post방식일 때 header를 자동으로 붙여준다.
			// 다만, serialize한 formData의 경우 header를 보내지 않아도 된다.
			// xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			xhr.onreadystatechange = function() {
	            if(xhr.readyState== 4 && xhr.status == 200) { // 성공 시
	                v_disp.textContent = xhr.responseText; // 결과값
	            }
	        }
			
			// !! FormData를 통해 값들을 한데 serialize하여 파라미터 값으로 보낼 수 있다.
			// 직접 formData를 생성하는 방법
			// let formData = new FormData(); // plain
			// formData.append("name", "value");
			
			// 생성자 파라미터로 폼 객체를 넘겨 serialize할 수 있다.
			let formData = new FormData(v_form);
			// 파일을 보낼 때는 파일객체를 따로 보내줘야함 -> ajax인 경우
			formData.append("nm_file",v_files.files);
			
			// formData.values()는 iterator를 반환한다.
			// 실제 검증 빼고는 사용할 일이 별로 없다.
			//for(let value of formData.values()){
			//	console.log(value);
			//}
			xhr.send(formData); // ajax 실행
			
			
			// jquery ajax 첨부파일버젼
			
			// url : url,
			// type : 'post',
			// processData : false, !
			// contentType : false, !
			// data : formData,
			// success : function(result){
			// ...
		}
		
		// 기존 submit 이벤트 발생 '전'에 실행할 함수를 바인딩할 수 있다. 
		v_form.addEventListener("submit", f_submit1);
	</script>
</body>
</html>