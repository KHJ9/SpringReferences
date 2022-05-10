package kr.or.ddit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.domain.HyunJun;

@Controller
public class HyunJunController {
	
	// 의존성 주입 Dependency Injection
	// servlet-context에서 객체를 추가하는 코드를 작성해야 한다.
	@Autowired /* 클래스 자동생성  */
	public HyunJun hyunJun;
	
//	@GetMapping("/HyunJun") // 여기에는 getMapping이 없다. (method=get이라고 생각하면 된다.)
	@RequestMapping(value = "/HyunJun", method = RequestMethod.GET)
	public Model getHyunJun(Model model) {
		hyunJun.setName("김현준");
		System.out.println(hyunJun.getName());
		model.addAttribute("hyunjun", hyunJun.getName()+"만세");
		return model;
	}

}
