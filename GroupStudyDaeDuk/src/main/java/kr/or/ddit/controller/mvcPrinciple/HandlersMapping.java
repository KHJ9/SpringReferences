package kr.or.ddit.controller.mvcPrinciple;

import java.util.HashMap;
import java.util.Map;

// path -> controller를 연결 시킬 애
public class HandlersMapping {

	// String -> Controller를 맵핑 시킬 Map
	Map<String, Controller> mappings;
	
	public HandlersMapping() {
		this.mappings = new HashMap<String, Controller>();
	}

	// setter는 생성자로 대체한다.
	public Map<String, Controller> getMappings() {
		return mappings;
	}
	
}
