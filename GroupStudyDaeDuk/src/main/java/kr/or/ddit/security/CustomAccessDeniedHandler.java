package kr.or.ddit.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import lombok.extern.slf4j.Slf4j;

// 보통 AccessDeniedHandler를 상속받아 직접 핸들러를 구현해서도 많이 사용한다.
@Slf4j
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException aDE) throws IOException, ServletException {
		// TODO Auto-generated method stub
		log.info("여기로 온 표식"); // 요런 표시가 디버깅시 중요
		log.info("error : " + aDE.getMessage());
		
		// 에러 시 이동할 페이지(홈으로 이동)
		response.sendRedirect(request.getContextPath()+"/accessError");
	}

}
