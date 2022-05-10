<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>채팅</title>
<style>
	#id_chatwin {
		width:80vw;
		height:50vh;
		background-color:black;
		border:1px solid pink;
		color:white;
	}
</style>
</head>
<body>
	<h1>간이 채팅방</h1>
	<div>
		<div id="id_chatwin"></div>
		<input type="text" id="id_message" /> 
		<input type="text" id="id_my" value="" placeholder="아이디 입력"/> 
		<input type="button" id="id_send" value="전송">
		<input type="button" id="id_con" value="연결">
		<input type="button" id="id_exit" value="나가기">
	</div>
</body>
<script>
		// 클라이언트쪽 기본 틀, 훨씬 고급 API도 많은데
		// 온전히 제대로 하려면 Message 서버도 추가적으로 필요함
		
		let webSocket;
		let nickname;
		const c_chatWin = document.querySelector("#id_chatwin");
		const c_message = document.querySelector("#id_message");		
		const c_nickname = document.querySelector("#id_my");		
		const c_send = document.querySelector("#id_send");
		const c_con = document.querySelector("#id_con");
		const c_exit = document.querySelector("#id_exit");

		c_send.addEventListener("click", function(){
			send();
		});
		
		c_con.addEventListener("click", function(){
			nickname = c_nickname.value;
			connect();
		});
		
		// 연결 끊깅
		c_exit.addEventListener("click", function(){
			disconnect();
		});

		function connect() {
			if(webSocket == null)
				webSocket = new WebSocket("ws://localhost:8405/ddit/ws-chat"); // End Point
			//이벤트에 이벤트핸들러 뜽록 
			webSocket.onopen = onOpen; // 웹소켓이 연결되면 발동하는 이벤트
			webSocket.onmessage = onMessage; // 메시지가 오면 발동하는 이벤트
		}

		//연결 시
		function onOpen() {
			webSocket.send("['"+nickname + "' 님이 입장 했습니다.]");
		} 
		function send() {
			let msg = c_message.value;
			webSocket.send(nickname + ":" + msg);
			c_message.value = "";
		}
		function onMessage() {
			let data = event.data;
			// 서버에서 보내준 데이터는 event.data에 담겨옴
			c_chatWin.innerHTML = c_chatWin.innerHTML + "<br/>" + data;
		}
		function disconnect() {
			webSocket.send("['"+nickname + "' 님이 방을 나갔습니다.]");
			webSocket.close();
			webSocket = null;
		}
</script>
</body>
</html>