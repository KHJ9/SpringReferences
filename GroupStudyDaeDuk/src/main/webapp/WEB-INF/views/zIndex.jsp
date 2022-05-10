<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>z-index</title>
<style>
    #container, #container * {
        width : 500px;
        height : 500px;
    }

    #container {
        position : relative;
    }

    #container * {
        position : absolute;
        z-index : 0;
    }
    
    #container *:nth-child(1) {
        background-color : pink;
    }
    
    #container *:nth-child(2) {
        background-color : lightyellow;
    }
    
    #container *:nth-child(3) {
        background-color : lightblue;
    }
    
    #container *:nth-child(4) {
        background-color : lavender;
    }
</style>
</head>
<body>
	<input id="btn" type="button" value="변환">
	<div id="container">
        <div id="background1"></div>
        <div id="background2"></div>
        <div id="background3"></div>
        <div id="background4"></div>
    </div>
    <script>
        var back = document.querySelectorAll("#container *");
        
        var target = 0;
        function switchLayers(){
            var r = Math.ceil(Math.random()*255);
            var g = Math.ceil(Math.random()*255);
            var b = Math.ceil(Math.random()*255);
            back[target%4].style.zIndex++;
            back[target%4].style.backgroundColor = 'rgb('+r+','+g+','+b+')';
            target++;
        }
        
        for(var bak of back){
        	console.log(bak);
        }
        
        for(var bak in back){
        	console.log(bak);
        }

        //document.querySelector("#btn").
        //addEventListener("click", switchLayers);
        setInterval(switchLayers, 500);
    </script>
</body>
</html>