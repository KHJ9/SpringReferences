<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <form action="<%=request.getContextPath()%>/gangkuk/inputFormMultipart" method="post"
        enctype="multipart/form-data">
        <!-- "application/x-www-form-urlencoded" : "name1=value1&name2=value2" 방식으로 데이터를 보낸다는 뜻 -->
        이름<input type="text" name="nm_name" id="id_name" value="홍길동"><br>
        특기<input type="text" name="nm_special" id="id_special" value="그림그리기"><br>
        취미<input type="password" name="nm_hobby" id="id_hobby" value="재즈듣기"><br>
        <input type="file" name="files" accept=".jpg,.png,.gif" multiple>
        <input type="submit" id="id_btn1" value="전송1">
        <input type="submit" id="id_btn2" value="전송2">
    </form>
    <script type="text/javascript">
        const c_btn1 = document.querySelector("#id_btn1");
        const c_btn2 = document.querySelector("#id_btn2");
        const c_name = document.querySelector("#id_name");
        const c_special = document.querySelector("#id_special");
        const c_hobby = document.querySelector("#id_hobby");

        const c_btnClick1 = () => {
        	event.preventDefault();
        	
            const c_xhr = new XMLHttpRequest();
            c_xhr.open("post", "<%=request.getContextPath()%>/gangkuk/inputForm4", true);
            c_xhr.onreadystatechange = function(){
                if(c_xhr.readyState == 4 && c_xhr.status == 200){
                	console.log(JSON.parse(c_xhr.responseText));
                }
            }

            let l_data = {
                nm_name:c_name.value,
                nm_special:c_special.value,
                nm_hobby:c_hobby.value
            }

            // header세팅은 항상 send 전에
            c_xhr.setRequestHeader("Content-Type", "application/json");
            // JSON을 JSON 문자열 방식으로 변환해주어야 한다.
            // 문자열화 했지만. 형식이 기본 URL Encoding 방식(name=value)이 아니고, JSON문법임을 알려줘야 한다.
            // 그래서 헤더의 content type을 json 타입으로 지정해야 한다.
            // ! JSON타입으로 데이터를 보낼 때는 ajax로만 가능하다.
            c_xhr.send(JSON.stringify(l_data));
        }
        
        const c_btnClick2 = () => {
        	event.preventDefault();
        	
            const c_xhr = new XMLHttpRequest();
            c_xhr.open("post", "<%=request.getContextPath()%>/gangkuk/inputForm", true);
            c_xhr.onreadystatechange = function(){
                if(c_xhr.readyState == 4 && c_xhr.status == 200){
                    console.log(JSON.parse(c_xhr.responseText));
                }
            }

            let l_data = {
                nm_name:["홍길동", "이순신", "세종대왕"],
                nm_special:["의적", "장군", "왕"],
                nm_hobby:["1", "2", "3"]
            }

            // header세팅은 항상 send 전에
            c_xhr.setRequestHeader("Content-Type", "application/json");
            // JSON을 JSON 문자열 방식으로 변환해주어야 한다.
            // 문자열화 했지만. 형식이 기본 URL Encoding 방식(name=value)이 아니고, JSON문법임을 알려줘야 한다.
            // 그래서 헤더의 content type을 json 타입으로 지정해야 한다.
            c_xhr.send(JSON.stringify(l_data));
        }

        //c_btn1.addEventListener("click", c_btnClick1);
        //c_btn2.addEventListener("click", c_btnClick2);
    </script>
</body>
</html>