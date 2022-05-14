package kr.or.ddit.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import kr.or.ddit.service.SimpleAopService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:config/spring/root-context.xml")
public class SimpleAopTest {
	
	@Autowired
	SimpleAopService simpleAopService;
	
	@Test
	public void myTest() {
		log.error("sum : " + simpleAopService.add("272", "337"));
		log.error("cha : " + simpleAopService.minus("337", "272"));
	}
	
}
