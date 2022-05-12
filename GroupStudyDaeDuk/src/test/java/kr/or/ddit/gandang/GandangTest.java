package kr.or.ddit.gandang;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import kr.or.ddit.service.GandangService;
import kr.or.ddit.service.GandangServiceImpl;

@ExtendWith(SpringExtension.class) // junit5
@ContextConfiguration(locations = {"classpath:config/spring/root-context.xml"})
public class GandangTest {

	@Autowired
	private GandangService gandangService;
	
	@Test
	public void connTest() {
		gandangService.ins2tb();
	}
	
}




