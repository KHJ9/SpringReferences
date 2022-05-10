<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="UTF-8" %>
<html>
<head>
	<title>bypass</title>
	<!-- css경로를 사용할 수 있는 것은 servlet-context에서 별도로 설정을 했기 때문이다. -->
	<!-- request.getContextPath() : /ddit (루트 경로를 반환) -->
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/mystyle.css">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/x2js/1.2.0/xml2json.min.js"></script>
	<style type="text/css">
		#id_disp {
			border : 1px solid pink;
		}
		
		a {
			text-decoration: none;
			color : green;
		}
	</style>
</head>
<body>
	<select id="id_lang">
		<option value="1" selected>영어권</option>
		<option value="2">한국</option>
	</select>
	검색어<input type="text" id="id_search" name="nm_search" value="">
	<input type="button" id="id_btn" value="뉴스검색">
	<input type="button" id="id_btn2" value="뉴스검색2"><br>
	<div id="id_disp">
		<!-- 여기에 구글 News가 나오도록 -->
	</div>

	<!-- 
        Origin : 프로토콜 + 서버명(도메인명) + 포트번호 3개로 구성
        1게라도 다르면 다른 오리진, 포트번호 64K(64 * 2의 10승)
        오리진이 섞이는 걸 Cross Origin이라고 부름
        울 부모님이 아닌 옆집 부모님에게 요청하는 것
        AJAX(,Axios)에서만 기본적으로 Cross-Origin 제약사항이 있음
        (script src, img src는 문제없음 : 이를 JSONP(제이슨 패딩)이라고 함)
        (서버 관리자가 설정으로 풀어주거나 다른 것까지 막을 수 있음)
        CORS Cross Origin Resource Sharing 
        
        CORS가 있는 이유 : url을 통한 페이지 이동이 아닌, 받아온 값을
        가지고 조작을 하는 것에대해 이를 막기 위함.

        그래서 이를 해결하기 위해 서버 우회 방식을 사용한다.
        클라이언트가 서버(백단)에 부탁해 타겟 서버에 값을 받아오도록 요청하면 된다.

        예) 아파치(XAMPP, 포트번호 80)에서 톰캣(포트번호 8405)로 ajax 요청을 하면
        포트번호가 일치하지 않아 CORS 오류가 발생하게 된다.
    -->
    
    <script>
	    const btn = document.querySelector("#id_btn");
	    const btn2 = document.querySelector("#id_btn2");
		const search = document.querySelector("#id_search");
		const board = document.querySelector("#id_disp");
		const lang = document.querySelector("#id_lang");
    	
		function bypass(){
    		const xhr = new XMLHttpRequest();
    	    var url = "http://localhost:8405/ddit/bypass/googleXmlToJson";
            url += "?st=" + search.value;
            url += "&ln=" + lang.value;
    		xhr.open("get", url, true);
            xhr.onreadystatechange = function(){
                if(xhr.readyState == 4 && xhr.status == 200){
                    console.log(JSON.parse(xhr.responseText));
                    
                    let result = JSON.parse(xhr.responseText);
                    let tem = result.channel.item;
                    board.innerHTML = '';
                    
                    let table = document.createElement("table");
                    table.border = 1;
                    board.appendChild(table);
                    
                    let tr = document.createElement("tr");
            		table.appendChild(tr);
                    
                    let th1 = document.createElement("th");
            		th1.style.width = "50%";
            		th1.textContent = "제목";
            		tr.appendChild(th1);
            		
            		let th2 = document.createElement("th");
            		th2.style.width = "10%";
            		th2.textContent = "날짜";
            		tr.appendChild(th2);
            		
            		let th3 = document.createElement("th");
            		th3.style.width = "40%";
            		th3.textContent = "링크";
            		tr.appendChild(th3);
            		
                    for(let i in tem){
                    	if(tem.length >= i){
                    		
                    		let tr = document.createElement("tr");
                    		table.appendChild(tr);
                    		
                    		let th1 = document.createElement("td");
                    		tr.appendChild(th1);
                    		
                    		let th2 = document.createElement("td");
                    		tr.appendChild(th2);
                    		
                    		let th3 = document.createElement("td");
                    		tr.appendChild(th3);
                    		
                    		let span1 = document.createElement("span");
                            span1.textContent = (parseInt(i)+1) + ". " + tem[i].title;
                            th1.appendChild(span1);
                            
                            let span2 = document.createElement("span");
                            span2.textContent = tem[i].pubDate;
                            th2.appendChild(span2);
                            
                            let a = document.createElement("a");
                    		a.href = tem[i].link;
                    		a.text = tem[i].link;
                    		th3.appendChild(a);
                    	}
                    }
                }
            }
            xhr.send(); // POST방식일 때만 인자를 입력해주면 된다.
    	}
		
		function bypass2(){
    		const xhr = new XMLHttpRequest();
    	    var url = "http://localhost:8405/ddit/bypass/googleXml";
            url += "?st=" + search.value;
            url += "&ln=" + lang.value;
    		xhr.open("get", url, true);
            xhr.onreadystatechange = function(){
                if(xhr.readyState == 4 && xhr.status == 200){
                	
                	// 클라이언트에서도 제공된다.
                	// xml to json
                	// json to xml
                	
                	// 큰 데이터의 변환 작업의 경우
                	// 서버단 보다는 클라이언트 단에서 변환해주는 것이
                	// '성능'면에서 더 낫다.
                	// 서버는 다수의 클라이언트의 요청을 받기 때문이다.
                	// 트래픽 문제, '비용' 문제
                	
                    const x2js = new X2JS();
                    const json = x2js.xml_str2json(xhr.responseText);
                    
                    console.log(xhr.responseXML);
                    console.log(json);
                }
            }
            xhr.send(); // POST방식일 때만 인자를 입력해주면 된다.
    	}
    	
    	function enter(){
    		if(event.code == "Enter") bypass();
    	}
    	
        btn.addEventListener("click", bypass);
        btn2.addEventListener("click", bypass2);
        search.addEventListener("keypress", enter);
    </script>
</body>
</html>