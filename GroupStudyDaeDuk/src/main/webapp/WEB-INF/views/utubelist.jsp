<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="UTF-8" %>
<html>
<head>
	<title>utube</title>
	<!-- css경로를 사용할 수 있는 것은 servlet-context에서 별도로 설정을 했기 때문이다. -->
	<!-- request.getContextPath() : /ddit (루트 경로를 반환) -->
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/mystyle.css">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/x2js/1.2.0/xml2json.min.js"></script>
	<style type="text/css">
		
	</style>
</head>
<body>
	<iframe id="">
	
	</iframe>
	<input type="text" id="id_sch" value="cantaloupe">
	<input type="button" id="id_btn" value="검색">
	<script type="text/javascript">
		const search = document.querySelector("#id_sch");
		const button = document.querySelector("#id_btn");
		
		const c_videoList = [];
		const ckARR = [];
		
		function getTitle(p_code){
			const xhr = new XMLHttpRequest();
		    var url = "http://localhost:8405/ddit/bypass/utube?schCode="+p_code;
			xhr.open("get", url, true);
	        xhr.onreadystatechange = function(){
	            if(xhr.readyState == 4 && xhr.status == 200){
	            	const readBody = xhr.responseText;
	            	//console.log(readBody);
	            	let startIndex = readBody.indexOf("<title>")+7;
	            	let endIndex = readBody.indexOf("</title>");
	            	let title = readBody.substring(startIndex, endIndex);

	            	let videoVO = {}; // 관련있는 데이터는 묶어주는 게 대세
	            	videoVO.code = p_code;
	            	videoVO.title = title;
	            	
	            	c_videoList.push(videoVO);
	            	
	            	//console.log(p_code, "==>", title);
	            }
	        }
	        xhr.send();
	        return c_videoList;
		}
		
		function bypass(){
			const xhr = new XMLHttpRequest();
		    var url = "http://localhost:8405/ddit/bypass/utubeList";
	        url += "?schWord=" + search.value;
			xhr.open("get", url, true);
	        xhr.onreadystatechange = function(){
	            if(xhr.readyState == 4 && xhr.status == 200){
	            	const readBody = xhr.responseText;
	            	
	            	let atIndex = 0; // 찾기시작 위치
	            	let sIndex; // 찾은 위치 저장 변수
	            	// 메소드 indexOf("찾을문자열", 찾기시작위치지정)
	            	while((sIndex = readBody.indexOf("watch?", atIndex)) != -1){
	            		// videoCode 중복제거도 숙제
	            		let startIndex = sIndex + 8;
	            		let endIndex = startIndex + 11;
	            		atIndex = endIndex;
	            		let videoCode = readBody.substring(startIndex, endIndex);
	            		
	            		let isIn = false;
	            		for(let i=0; i<ckARR.length; i++){
	            			if(ckARR[i] == videoCode){
	            				isIn = true;
	            				break;
	            			}
	            		}
	            		
	            		if(!isIn){
	            			ckARR.push(videoCode);
	            		}
	            		
	            		getTitle(videoCode);
	            		//return;
	            	}
	            }
	        }
	        xhr.send(); // POST방식일 때만 인자를 입력해주면 된다.
	        
		}
		
		function enter(){
			if(event.code == "Enter") bypass();
		}
		
		search.addEventListener("keypress", enter);
		button.addEventListener("click", bypass);
	</script>
</body>
</html>