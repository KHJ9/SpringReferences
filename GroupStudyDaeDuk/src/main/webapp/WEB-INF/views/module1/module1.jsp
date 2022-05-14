<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/es6-promise/4.1.1/es6-promise.auto.js"></script>
	<script src="https://html2canvas.hertzen.com/dist/html2canvas.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.3.4/jspdf.min.js"></script>
	<style>
	</style>
</head>
<body>
	<button id="savePdf">저장</button>
	<div class="pdf_page">
		<div id="capture" style="padding: 10px; color: white; background: blue;">
		    <h4>Hello world!</h4>
		</div>
	</div>
	<div class="pdf_page">
		<div id="capture" style="padding: 10px; color: white; background: blue;">
		    <h4>Hello world!</h4>
		</div>
	</div>
	<div class="pdf_page">
		<div id="capture" style="padding: 10px; color: white; background: blue;">
		    <h4>Hello world!</h4>
		</div>
	</div>
	<div class="pdf_page">
		<div id="capture" style="padding: 10px; color: white; background: blue;">
		    <h4>Hello world!</h4>
		</div>
	</div>
	<div class="pdf_page">
		<div id="capture" style="padding: 10px; color: white; background: blue;">
		    <h4>Hello world!</h4>
		</div>
	</div>
	<div class="pdf_page">
		<div id="capture" style="padding: 10px; color: white; background: blue;">
		    <h4>Hello world!</h4>
		</div>
	</div>
	<div class="pdf_page">
		<div id="capture" style="padding: 10px; color: white; background: blue;">
		    <h4>Hello world!</h4>
		</div>
	</div>
	<div class="pdf_page">
		<div id="capture" style="padding: 10px; color: white; background: blue;">
		    <h4>Hello world!</h4>
		</div>
	</div>
	<div class="pdf_page">
		<div id="capture" style="padding: 10px; color: white; background: blue;">
		    <h4>Hello world!</h4>
		</div>
	</div>
	<div class="pdf_page">
		<div id="capture" style="padding: 10px; color: white; background: blue;">
		    <h4>Hello world!</h4>
		</div>
	</div>
	<div class="pdf_page">
		<div id="capture" style="padding: 10px; color: white; background: blue;">
		    <h4>Hello world!</h4>
		</div>
	</div>
	<div class="pdf_page">
		<div id="capture" style="padding: 10px; color: white; background: blue;">
		    <h4>Hello world!</h4>
		</div>
	</div>
	<div class="pdf_page">
		<div id="capture" style="padding: 10px; color: white; background: blue;">
		    <h4>Hello world!</h4>
		</div>
	</div>
	<div class="pdf_page">
		<div id="capture" style="padding: 10px; color: white; background: blue;">
		    <h4>Hello world!</h4>
		</div>
	</div>
	<div class="pdf_page">
		<div id="capture" style="padding: 10px; color: white; background: blue;">
		    <h4>Hello world!</h4>
		</div>
	</div>
	<div class="pdf_page">
		<div id="capture" style="padding: 10px; color: white; background: blue;">
		    <h4>Hello world!</h4>
		</div>
	</div>
	<div class="pdf_page">2</div>
	<div class="pdf_page">3</div>
	<div class="pdf_page">4</div>
	<div class="pdf_page">5</div>
	<script>
		var renderedImg = new Array();
	  	var contWidth = 200, // 너비(mm) (a4에 맞춤)
		  	padding = 5; //상하좌우 여백(mm)	
	
		$(function() {
		  	$("#savePdf").click(function() { // pdf저장 button id
		      	//$(".ad_i, .wrap_chart_btn").css("display", "none"); // 불필요한 태그 숨김
		    	//document.getElementById("loading").style.display = "block"; // 로딩 이미지 보이기
			    //$("#loading").show(); jquery 사용할 경우
			    //$("#main_frame", parent.document).parents("body").find("#loading").show(); // 부모 frame에 있는 loading 보이기

			    // setTImeout을 하는 이유는 html2canvas를 불러오는게 너무 빨라서 앞의 js가 먹혀도 반영되지 않은 것처럼 보임
			    // 따라서 0.1 초 지연 발생 시킴
		      	setTimeout(function() {
		        	createPdf("");
		      	}, 100);
		  	});
		});
	
		function createPdf(saveFileName) { //이미지를 pdf로 만들기
		  var lists = document.querySelectorAll(".pdf_page"),
		      deferreds = [],
		      doc = new jsPDF("p", "mm", "a4"),
		      listsLeng = lists.length;

		  for (var i = 0; i < listsLeng; i++) { // pdf_page 적용된 태그 개수만큼 이미지 생성
		    var deferred = $.Deferred();
		    deferreds.push(deferred.promise());
		    if(lists[i].style.backgroundColor == "")
		    	lists[i].style.backgroundColor = "white";
	    	lists[i].style.border = "none";
		    generateCanvas(i, doc, deferred, lists[i]);
		  }

		  $.when.apply($, deferreds).then(function () { // 이미지 렌더링이 끝난 후
		    var sorted = renderedImg.sort(function(a,b){return a.num < b.num ? -1 : 1;}), // 순서대로 정렬
		        curHeight = padding, //위 여백 (이미지가 들어가기 시작할 y축)
		        sortedLeng = sorted.length;

		    for (var i = 0; i < sortedLeng; i++) {
		      var sortedHeight = sorted[i].height, //이미지 높이
		          sortedImage = sorted[i].image; //이미지

		      if( curHeight + sortedHeight > 297 - padding * 2 ){ // a4 높이에 맞게 남은 공간이 이미지높이보다 작을 경우 페이지 추가
		        doc.addPage(); // 페이지를 추가함
		        curHeight = padding; // 이미지가 들어갈 y축을 초기 여백값으로 초기화
		        doc.addImage(sortedImage, 'jpeg', padding , curHeight, contWidth, sortedHeight); //이미지 넣기
		        curHeight += sortedHeight; // y축 = 여백 + 새로 들어간 이미지 높이
		      } else { // 페이지에 남은 공간보다 이미지가 작으면 페이지 추가하지 않음
		        doc.addImage(sortedImage, 'jpeg', padding , curHeight, contWidth, sortedHeight); //이미지 넣기
		        curHeight += sortedHeight; // y축 = 기존y축 + 새로들어간 이미지 높이
		      }
		    }
		    doc.save(saveFileName+'.pdf'); //pdf 저장

		    curHeight = padding; //y축 초기화
		    renderedImg = new Array; //이미지 배열 초기화

		    document.getElementById("loading").style.display = "none"; // 로딩 이미지 숨기기
		    //$("#loading").hide(); jquery 사용할 경우
		    //$("#main_frame", parent.document).parents("body").find("#loading").hide(); 부모 frame에 loading 태그가 있는 경우
		    //$(".ad_i, .wrap_chart_btn").css("display", ""); 기존에 숨겼던 태그를 다시 보이게 하기
		  });
		}

		function generateCanvas(i, doc, deferred, curList){ //페이지를 이미지로 만들기
		  var pdfWidth = $(curList).outerWidth() * 0.2645, //px -> mm로 변환
		      pdfHeight = $(curList).outerHeight() * 0.2645,
		      heightCalc = contWidth * pdfHeight / pdfWidth; //비율에 맞게 높이 조절
		  html2canvas( curList ).then(
		    function (canvas) {
		      //saveAs(canvas.toDataURL(), 'fileName.png');
		      var arr = [canvas, 0];
		      var img = canvas.toDataURL('image/jpeg', 1.0); //이미지 형식 지정
		      console.log(canvas);
		      renderedImg.push({num:i, image:img, height:heightCalc}); //renderedImg 배열에 이미지 데이터 저장(뒤죽박죽 방지)
		      deferred.resolve(); //결과 보내기
		    }
		  );
		}
		
		function saveAs(uri, fileName) {
		  const link = document.createElement("a");
		  link.href = uri;
		  link.download = fileName;

		  document.body.appendChild(link);

		  link.click();

		  document.body.removeChild(link);
		}
	</script>
	
</body>
</html>