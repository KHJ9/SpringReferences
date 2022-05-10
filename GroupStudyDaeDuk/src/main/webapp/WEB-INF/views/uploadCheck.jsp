<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- src 참조 방식은 CORS 영향을 받지 않는다. CORS는 ajax(그러니까 비동기 통신)일 경우에만 발생할 수 있다. -->
<script src="<%=request.getContextPath()%>/resources/ckeditor/ckeditor.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
</head>
<body>
    <!-- form 태그는 여러번 들어갈 수 있음, 단 form안에 form을 넣지 않는다. -->
	<form id="id_form" action="<%=request.getContextPath()%>/gUpload" method="post" enctype="multipart/form-data">
        <input type="file" name="nm_file" id="id_file" accept=".jpg, .jpeg, .png"><br>
        <!-- 바닐라js : 외부 라이브러리나 프레임워크를 쓰지 않는 순수 JavaScript -->
        <input type="submit" value="바닐라js사용">
        <input type="submit" value="jQuery사용">
    </form>
    <script>
        // ! forms 안에는 페이지 내의 form들이 들어있다.
        // const c_form = document.querySelector("#id_form");
        // const c_form = document.forms("id_form"); // #이나 .등을 붙이지 않는다.
        const c_form = document.forms[0];
        const c_file = document.querySelector("#id_file");

        const f_submit = function(){
            event.preventDefault(); // !! 별도의 방식으로 데이터를 전송하려면 이 문장을 꼭 선언할 것!
            
            //console.log(c_file.files);

            // !! script에서 파일을 올리기 위해선 별도로 formData로 묶어 보내줘야 한다.
            let formData = new FormData();						
            formData.append("p_file", c_file.files[0]); // 파일을 보낼 시 .files[index]를 인자로 보낼 것

            const c_xhr = new XMLHttpRequest();
            c_xhr.open('post', '<%=request.getContextPath()%>/gUpload', true);

            // vanilaJS ajax에서 받는 데이터의 타입을 지정하고자 할 때 다음과 같이 작성하면 된다.
            c_xhr.responseType = 'json';
            c_xhr.onreadystatechange = function(){
                if(c_xhr.readyState == 4 && c_xhr.status == 200){
                    console.log("success", c_xhr.response);
                    let l_a = document.createElement("a");
                    /*
                    l_a.onclick = function(){
                        event.preventDefault(); // href 기능을 막기 위해 사용?
                        window.open(c_xhr.response.data[1], "_blank", "width=500px; height=500px; left=200px; top=200px;");
                    }
                    */
                    l_a.href = c_xhr.response.data["fileUrl"];
                    l_a.download = c_xhr.response.data["fileName"];
                    let l_img = document.createElement("img");
                    l_img.src = c_xhr.response.data["fileUrl"];
                    l_img.style.width = "250px";
                    l_img.style.height = "250px";
                    l_a.append(l_img);
                    document.body.append(l_a);
                }
            }
            c_xhr.send(formData);

            return;
            // jquery ajax
            $.ajax({
                type : 'post',
                data : formData,
                url : '<%=request.getContextPath()%>/gUpload',
                contentType : false, // jquery ajax 파일객체 보낼 시 꼭 선언할 것
                processData : false, // jquery ajax 파일객체 보낼 시 꼭 선언할 것
                success : function(response){
                    console.log("success", response);
                },
                error : function(response){
					console.log("error");
                },
                dataType : 'json'
            });
        }

        c_form.addEventListener("submit", f_submit);
    </script>
</body>
</html>