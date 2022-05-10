package kr.or.ddit.controller.interceptor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(path = "/user")
public class InterceptorController {

	@GetMapping("/form")
	public String ckForm() {
		return "formCk";
	}
	
	@PostMapping(path = "/login")
	public String ckInterceptor() {
		log.info("로그인 인터셉터");
		return "formCk";
	}
	
}
