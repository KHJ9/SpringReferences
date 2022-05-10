package kr.or.ddit.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginOutController {
	
	@GetMapping("/mylogin")
	public String getLogin(HttpSession session) {
		session.setAttribute("guest", "guest1");
		log.info("This is My Login-Page");
		return "mylogin";
	}
	
	@GetMapping("/logoutpage")
	public String getLogout() {
		log.info("This is My Logout-Page");
		return "logoutpage";
	}
	
	@GetMapping("/accessError")
	public String accessError(HttpServletRequest req, Model model) {
		Enumeration<String> reqAttrNames = req.getAttributeNames();
		while(reqAttrNames.hasMoreElements())
			System.out.println("ck: " + reqAttrNames.nextElement());
		log.info("You are not permitted");
		model.addAttribute("msg", "승인되지 않았습니다.");
		return "accessError";
	}
	
}
