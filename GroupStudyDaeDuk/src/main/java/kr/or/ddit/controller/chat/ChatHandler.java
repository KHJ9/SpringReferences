package kr.or.ddit.controller.chat;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.slf4j.Slf4j;

/**
 * TextWebSocketHandler
 * 
 * @author Kim Hyun Jun
 * @version 1.0
 * @see "텍스트를 주고 받도록 도와주는 핸들러, 채팅 핸들러"
 */
@Component 
@Slf4j
//context.xml에서 bean태그를 별도로 작성하지 않고 이렇게 어노테이션으로 대체할 수 있다.
public class ChatHandler extends TextWebSocketHandler implements WebSocketConfigurer {
	
	// 세션들을 저장하는 리스트
	private static List<WebSocketSession> list = new ArrayList<WebSocketSession>();
	
	// 클라이언트가 추가될 때 발동하는 메소드
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		log.info("## 누군가 접속");
		list.add(session);
	}

	// 클라이언트가 메시지를 보낼 때 발동하는 메소드
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		String uMsg = message.getPayload();
		for (WebSocketSession webSocketSession : list) {
			webSocketSession.sendMessage(new TextMessage(session.getAcceptedProtocol() + uMsg));
		}
	}
	
	// 특정 클라이언트가 연결을 종료할 때 발동하는 메소드
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		log.info("## 누군가 떠남");
		list.remove(session);
	}
	
	// 핸들러를 저장소에 추가하는 메소드
	// url은 context.xml에 등록한 url과 동일하게 작성할 것(/ws-chat)
	// setAllowedOrigins("*"); : *로 표기한다.
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(this, "/ws-chat").setAllowedOrigins("*");
	}

}