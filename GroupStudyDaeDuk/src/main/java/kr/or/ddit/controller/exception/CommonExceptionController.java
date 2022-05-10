package kr.or.ddit.controller.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

// 예외처리를 모두 관리하는 컨트롤러
// @ControllerAdvice는 모든 @Controller 즉, 전역에서 발생할 수 있는 예외를 잡아 처리해주는 annotation이다.
@ControllerAdvice // 클라이언트와 서버 간 문제 시 그 중간을 가로채는 역할
public class CommonExceptionController {

	@ExceptionHandler(NullPointerException.class)
	public String nullHandler(NullPointerException ne, Model model) {
		model.addAttribute("exception", "["+ne.toString().replace(".",  " ")+"]");
		return "error/error";
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public String notFoundHandler(NoHandlerFoundException ne, Model model) {
		model.addAttribute("exception", "["+ne.getMessage()+"]");
		return "error/error";
	}
	
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e, Model model) {
		model.addAttribute("exception", "["+e.getMessage()+"]");
		return "error/error";
	}
	
}
