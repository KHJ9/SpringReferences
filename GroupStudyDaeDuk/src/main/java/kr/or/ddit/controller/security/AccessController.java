package kr.or.ddit.controller.security;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

/**
 * AccessController
 * 
 * @author Kim Hyun Jun
 * @version 1.0
 * @see ""
 */
@Slf4j
@Controller
@RequestMapping("/fbi")
public class AccessController {

	@GetMapping("/all")
	public String getAll(Model model) {
		log.info("All Access");
		model.addAttribute("accessUser", "All");
		return "allaccess";
	}
	
	@GetMapping("/member")
	public String getMeber(Model model) {
		log.info("Member Access");
		model.addAttribute("accessUser", "Member");
		return "memberaccess";
	}
	
	@GetMapping("/admin")
	public String getAdmin(Model model) {
		log.info("Admin Access");
		model.addAttribute("accessUser", "Admin");
		return "adminaccess";
	}
	
	@GetMapping("/blue")
	public String getBlue(Model model) {
		log.info("Blue Access");
		
		/*
		// 백단에서 로그인한 사용자의 정보를 받아오는 방법
		SecurityContext context = SecurityContextHolder.getContext();
		context.getAuthentication().getDetails();
		*/
		
		model.addAttribute("accessUser", "Blue");
		return "userDetailsCK";
	}
	
}
