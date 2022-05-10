package kr.or.ddit.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.slf4j.Slf4j;

// HandlerInterceptor 인터페이스에는 구현체가 있다.
// java 1.8 이상부터 인터페이스에도 구현체를 만드는 것이 가능하다.
// 그래서 adapter를 상속받아도 차이가 별로 없다.
@Slf4j
public class MyFirstInterceptor extends HandlerInterceptorAdapter {

	// Handler에 요청을 전달하기 전
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if(request.getParameter("nm_admin").equalsIgnoreCase("admin")) {
			log.info("너 관리자 맞구나");
			return true; // true : 컨트롤러로 이동
		}
		
		response.sendRedirect("/ddit/user/form"); // 다시 이 경로로 되돌려주기
		return false; // false : 컨트롤러로 이동 금지
	}
	
	// Handler에 요청을 전달한 후 
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.info("언제 실행되요");
	}
	
	// afterCompletion : '완성' 후에
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		log.info("난 또 언제 실행되어요?");
	}	
	
}
