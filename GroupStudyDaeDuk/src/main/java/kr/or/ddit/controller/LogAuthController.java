package kr.or.ddit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/fbi")
public class LogAuthController {

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
		model.addAttribute("accessUser", "Blue");
		return "blueaccess";
	}
	
}
