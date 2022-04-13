package kr.or.ddit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {
	
	@ResponseBody /* 엄청중요 어노테이션 jsp를 찾지않고 바로 클라이언트로 리턴 */
	/* 잊지말고 저녁에 한번만 jsp로 보내는 거랑 구분해서 연습해 둘 것 */
	@RequestMapping("/ajax")
	public List<Map<String, String>> rawResponse() {
		
		List<Map<String, String>> mylist = new ArrayList<Map<String,String>>();
		
		Map<String, String> myMap = new HashMap<String, String>();
		
		myMap.put("star1", "roze");
		myMap.put("star2", "jenni");
		myMap.put("star3", "risa");
		myMap.put("star4", "jisu");
		
		mylist.add(myMap);
		
		// http://localhost:8405/ddit/ajax.json
		
		// 자동으로 json/xml로 변환되어 리턴
		return mylist;
	}
	
}
