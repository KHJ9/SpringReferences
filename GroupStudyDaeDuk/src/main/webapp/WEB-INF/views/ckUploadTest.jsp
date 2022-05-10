<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<%=request.getContextPath()%>/resources/ckeditor/ckeditor.js"></script>
<script>
</script>
</head>
<body>
	<textarea name="nm_ta" id="id_ta"></textarea>
	<input type="button" value="CKEditor값 가져오기" id="hyunjun">
	<div id="id_disp">
		
	</div>
	
	<script>
		CKEDITOR.replace("nm_ta",{
			 enterMode : CKEDITOR.ENTER_BR,
			 filebrowserUploadMethod : "form",  // 꼭 선언해야 하는 부분
			 // 이미지 업로드는 ajax 비동기 방식으로 진행한다.
			 filebrowserUploadUrl: "<%=request.getContextPath()%>/ckUpload"
		})
		
		const c_hyunjun = document.querySelector("#hyunjun");
		const c_disp = document.querySelector("#id_disp");
		
		const f_click = function(){
			//const contents = CKEDITOR.instances["id_ta"].getData();
			const contents = CKEDITOR.instances.id_ta.getData();
			
			CKEDITOR.instances.id_ta.setData(contents + "<h1>added!</h1>");
			
			//const c_ifrm = document.querySelector("iframe");
			//console.log(c_ifrm.contentDocument.body.innerHTML);
		}
		
		c_hyunjun.onclick = f_click;
	</script>
</body>
</html>