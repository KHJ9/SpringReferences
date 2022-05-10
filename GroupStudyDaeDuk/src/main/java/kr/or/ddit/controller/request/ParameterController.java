package kr.or.ddit.controller.request;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.domain.Nums;

// 클래스 위에 requestMapping을 입력하면 하위 메소드의 경로에 공통적으로 적용된다.
// ex) /remind + /hyunjun
@Controller
@RequestMapping("/remind") 
public class ParameterController {
	
	// GET과 POST에 대해...
	
	/*
	 	GET  : 주소에 파라미터값이 붙는다. form없이도 url에 파라미터를 붙여 시도할 수 있다.
	 	POST : form type post일 때 가능한 방식이다.
	 */
	
	@RequestMapping(value = "/void")
	public void getVoid() {
		// 타입이 void인 경우 RequestMapping에 
		// 지정된 Url의 이름을 딴 파일을 찾도록 되어있다.
		// /void.jsp <- 이 파일을 찾을 것이다.
		return;
	}
	
	// 참조 : url + method가 일치하는 메소드가 
	// 2개 이상이면 spring이 인식 오류를 일으킨다.
	// 대신 url이 같고 method가 get, post로 나뉘어지는 건 괜찮다. 
	// 그렇게 나뉘어 메소드를 작성하는 경우는 있다. (RESTful 방식)
	
	// !!! 
	// 통산 get방식 요청에 입력화면을 보여주고, 
	// post 요청에 처리를 해주는 방식으로 많이 대응한다.
	
	// /WEB-INF/views/remind.jsp
	// 스프링에선 자바 파일을 수정하면 서버를 다시 로드해야 한다.
	// method는 다음처럼 작성하면 된다.
	
	@RequestMapping(value = "/getHyunjun", method = RequestMethod.GET)
	public String getHyunJun(Model model) {
		
		return "remindForm";
	}
	
	@RequestMapping(value = "/postHyunjunTest1", method = RequestMethod.POST)
	public ModelAndView postHyunJun1(String nm_name, String nm_song, Model model) {
		// 파라미터에 input태그의 name명을 입력하면 해당 값을 받아올 수 있다.
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", nm_name);
		mav.addObject("song", nm_song);
		mav.setViewName("remind"); // 이 모델은 view도 지정할 수 있다. (Model과의 차이점)
		
		return mav;
	}
	
	@RequestMapping(value = "/postHyunjunTest2", method = RequestMethod.POST)
	public ModelAndView postHyunJun2(
			@RequestParam("nm_name") String p_name, 
			@RequestParam("nm_song") String p_song, Model model) {
		// RequestParam을 작성하여 input태그의 name명을 입력하면 해당 값을 받아올 수 있다.
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", p_name);
		mav.addObject("song", p_song);
		mav.setViewName("remind"); // 이 모델은 view도 지정할 수 있다. (Model과의 차이점)
		
		return mav;
	}
	
	@RequestMapping(value = "/postHyunjun", method = RequestMethod.POST)
	public ModelAndView postHyunJun3(
			// required : 값이 필수적으로 오는가?
			// defaultValue : 값이 오지 않을 때 기본값은 어떻게 되는가?
			@RequestParam(
					value = "nm_name",
					required = false,
					// ㄴ BadRequest 방지, default값으로 0 반환
					// ㄴ RequestParam을 '통해' 값을 반환하지 못한 경우 오류가 발생할 수 있다.
					defaultValue = "기본값") String p_name, 
			@RequestParam(value = "nm_song") String p_song, Model model) {
		// RequestParam을 작성하여 input태그의 name명을 입력하면 해당 값을 받아올 수 있다.
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", p_name);
		mav.addObject("song", p_song);
		mav.setViewName("remind"); // 이 모델은 view도 지정할 수 있다. (Model과의 차이점)
		
		return mav;
	}
	
	@RequestMapping(value = "/jun", method = RequestMethod.GET)
	public String ajaxForm() {
		return "junForm";
	}
	
	@ResponseBody // 엄청중요, 리턴값 이름으로 페이지를 찾지 않고, 리턴값을 데이터로서 ajax에 반환한다.
	// 그렇기 때문에 비동기 데이터 요청(ajax, axiox)에 거의 단골로 사용된다.
	@RequestMapping(value = "/jun", method = RequestMethod.POST)
	public String ajaxHyunJun(String nm_first, String nm_second, String nm_sel, MultipartFile uploadFile) {
		switch(nm_sel) {
			case "p" : return (Integer.parseInt(nm_first) + Integer.parseInt(nm_second))+"";
			case "m" : return (Integer.parseInt(nm_first) - Integer.parseInt(nm_second))+"";
			case "g" : return (Integer.parseInt(nm_first) * Integer.parseInt(nm_second))+"";
			case "n" : return (Integer.parseInt(nm_first) / Integer.parseInt(nm_second))+"";
		}
		return "연산실패";
	}
	
	// form의 name들과 일치하는 class를 만들면 자동으로 매칭되는 값이 해당 객체에 들어감
	@RequestMapping(value = "/jun2", method = RequestMethod.POST)
	public String ajaxHyunJun2(Nums nums, MultipartFile[] nm_file) throws Exception {
		
		// 파라미터 vo의 프로퍼티명이 일치하면 자동으로 값을 받아올 수 있다.
		System.out.println(nums.toString());
		
		for(MultipartFile file : nm_file) {
			System.out.println("==================");
			
			System.out.println("본래 파일명 : " + file.getOriginalFilename());
			System.out.println("파일크기 : " + file.getSize());
			System.out.println("파일명 : " + file.getName());
		}
		
		// fruits.forEach((key, value)
		// 	    -> System.out.println("key: " + key + ", value: " + value));

		// 파일 저장
		// nm_file.transferTo(new File("C:/upload/"+nm_file.getOriginalFilename()));
		nm_file[0].transferTo(new File("C:/upload/"+nm_file[0].getOriginalFilename()));
		return "error";
	}
	
	@RequestMapping(value = "/hyunjun", method = RequestMethod.GET)
	public String hyunJun(Model model) {
		List<String> habit = new ArrayList<String>();
		habit.add("음악감상");
		habit.add("만화보기");
		model.addAttribute("name", "HyunJun");
		model.addAttribute("habit", habit);
		
		return "remind";
	}
	
}
