package kr.or.ddit.controller.request;

import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.domain.GilDong;
import lombok.extern.slf4j.Slf4j;

/**
 * RequestBodyController
 * 
 * @author Kim Hyun Jun
 * @version 1.0
 * @see "RequestBody를 통해 서버로 넘어온 값을 받는 방법에 대해 서술되어 있는 컨트롤러"
 */
@Slf4j
@Controller
@RequestMapping("/gangkuk")
public class RequestBodyController {
	
	// 사용자에게 입력폼을 보여주려 할때는 보통 get방식으로 받는다.
	@GetMapping("/inputForm")
	public String inputForm() {
		return "inputForm";
	}
	
	// 입력된 값들을 가져와 데이터처리를 수행
	@ResponseBody
	@PostMapping(value = "/inputFormTest1", produces = MediaType.APPLICATION_JSON_VALUE)
	public String postFormTest1(
			@RequestParam("nm_name") String p_name, 
			@RequestParam("nm_special") String p_special, 
			@RequestParam("nm_hobby") String p_hobby) {
		log.debug(p_name + ", " + p_special + ", " + p_hobby);
		return "OK";
	}
	
	// 입력된 값들을 가져와 데이터처리를 수행
	@ResponseBody
	@PostMapping(value = "/inputFormTest2", produces = MediaType.APPLICATION_JSON_VALUE)
	public GilDong postFormTest2(GilDong gilDong) {
		log.debug(gilDong.toString());
		return gilDong;
	}
	
	@ResponseBody
	@PostMapping(value = "/inputFormTest3", produces = MediaType.APPLICATION_JSON_VALUE)
	public String postFormTest3(@RequestBody String query) throws Exception {
		// @RequestBody : nm_name=홍길동&nm_special=그림그리기&nm_hobby=재즈듣기
		// ㄴ 문자열로 받은 경우
		return URLDecoder.decode(query, "UTF-8");
	}
	
	@ResponseBody
	@PostMapping(value = "/inputForm4", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, String> postFormTest4(@RequestBody Map<String, String> map) throws Exception {
		// 기본적으로 @RequestBody : nm_name=홍길동&nm_special=그림그리기&nm_hobby=재즈듣기
		// + 그래서 Map 타입으로 데이터를 받아오려면 프론트 단에서 json문자열 방식으로 값을 보내줘야 한다.
		log.debug(map.toString());
		return map;
	}
	
	// @RequestBody는 Post에서만 사용할 수 있다.
	// value 데이터타입이 섞여있을 때는 Object를 사용, 이왕이면 일관성있게 타입을 통일시키는 것이 좋다.
	@ResponseBody
	@PostMapping(value = "/inputFormMultipart", produces = MediaType.APPLICATION_JSON_VALUE)
	public GilDong postFormMultipart(GilDong gilDong) throws Exception {
		log.debug(gilDong.toString());
		StringBuilder builder = new StringBuilder();
		
		for(MultipartFile file : gilDong.getFiles()) {
			builder.append(String.format("%s ", file.getOriginalFilename()));
		}
		log.debug(builder.toString());
		
		return gilDong;
	}
	
	// @RequestBody는 Post에서만 사용할 수 있다.
	// value 데이터타입이 섞여있을 때는 Object를 사용, 이왕이면 일관성있게 타입을 통일시키는 것이 좋다.
	@ResponseBody
	@PostMapping(value = "/inputForm", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, List<String>> postForm(@RequestBody Map<String, List<String>> map) throws Exception {
		// 기본적으로 @RequestBody : nm_name=홍길동&nm_special=그림그리기&nm_hobby=재즈듣기
		// 그래서 Map 타입으로 데이터를 받아오려면 프론트 단에서 json문자열 방식으로 값을 보내줘야 한다.
		// + 프론트 단에서 보낸 value가 배열 타입이면 백엔드 단에서도 배열 타입으로 받아야 한다.
		log.debug(map.toString());
		return map;
	}
}








