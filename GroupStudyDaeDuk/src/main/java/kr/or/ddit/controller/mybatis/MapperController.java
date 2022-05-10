package kr.or.ddit.controller.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.mapper.TestMapper;

@Controller
public class MapperController {

	@Autowired
	public TestMapper testMapper;
	
//	@GetMapping(value = "/mybatis", produces = "application/json;charset=UTF-8")
	@GetMapping(value = "/mybatis/select", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody // 브라우저로 바로 출력
	public String select() {
		return testMapper.getBuyer("P10101");
	}
	
	@GetMapping(value = "/mybatis/insert", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody // 브라우저로 바로 출력
	public int insert() {
		return testMapper.insertSimple();
	}
	
	@GetMapping(value = "/mybatis/update", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody // 브라우저로 바로 출력
	public int update() {
		return testMapper.updateSimple();
	}
	
	@GetMapping(value = "/mybatis/delete", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody // 브라우저로 바로 출력
	public int delete() {
		return testMapper.deleteSimple();
	}
}
