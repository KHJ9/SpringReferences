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
    <div id="id_disp"></div>
    <input type="button" value="GET"    id="id_get"><br>
    <input type="button" value="POST"   id="id_post"><br>
    <input type="button" value="PUT"    id="id_put"><br>
    <input type="button" value="DELETE" id="id_delete"><br>
    <script>
        const c_getBtn      = document.querySelector("#id_get");
        const c_postBtn     = document.querySelector("#id_post");
        const c_putBtn      = document.querySelector("#id_put");
        const c_deleteBtn   = document.querySelector("#id_delete");

        const f_getClick = () => {
            const c_xhr = new XMLHttpRequest();
            c_xhr.open("get", "<%=request.getContextPath()%>/ajax/get", true);
            c_xhr.onreadystatechange = () => {
                if(c_xhr.readyState == 4 && c_xhr.status == 200){
                    console.log(c_xhr.responseText);
                }
            }
            c_xhr.send(null); // get일 때는 공백이나 null로 채워준다.
        }
        const f_postClick = () => {
            const c_xhr = new XMLHttpRequest();
            c_xhr.open("post", "<%=request.getContextPath()%>/ajax/post", true);
            c_xhr.onreadystatechange = () => {
                if(c_xhr.readyState == 4 && c_xhr.status == 200){
                    console.log(c_xhr.responseText);
                }
            }
            c_xhr.send(null); // get일 때는 공백이나 null로 채워준다.
        }
        const f_putClick = () => {
            const c_xhr = new XMLHttpRequest();
            c_xhr.open("put", "<%=request.getContextPath()%>/ajax/put", true);
            c_xhr.onreadystatechange = () => {
                if(c_xhr.readyState == 4 && c_xhr.status == 200){
                    console.log(c_xhr.responseText);
                }
            }
            c_xhr.send(null); // get일 때는 공백이나 null로 채워준다.
        }
        const f_deleteClick = () => {
            const c_xhr = new XMLHttpRequest();
            c_xhr.open("delete", "<%=request.getContextPath()%>/ajax/delete", true);
            c_xhr.onreadystatechange = () => {
                if(c_xhr.readyState == 4 && c_xhr.status == 200){
                    console.log(c_xhr.responseText);
                }
            }
            c_xhr.send(null); // get일 때는 공백이나 null로 채워준다.
        }

        c_getBtn.addEventListener("click", f_getClick);
        c_postBtn.addEventListener("click", f_postClick);
        c_putBtn.addEventListener("click", f_putClick);
        c_deleteBtn.addEventListener("click", f_deleteClick);
    </script>
</body>
</html>