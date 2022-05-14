package kr.or.ddit.controller.module1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/module1")
public class Module1Controller {

	@GetMapping("/view")
	public String getView() {
		return "module1/module1";
	}
	
}
