package kr.or.ddit.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import kr.or.ddit.controller.mybatis.MapperController;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebAppConfiguration
@ExtendWith(SpringExtension.class) // junit5 사용설정
@ContextConfiguration(locations = 
		{"classpath:config/spring/servlet-context.xml",
		 "classpath:config/spring/root-context.xml"})
public class MapperTest {
	
	@Autowired
	MapperController mapperController;
	
	@Test
	public void mappingTest() throws Exception {
		assertNotNull(mapperController.select());
		
		assertNotNull(mapperController.update());

		int result = mapperController.insert();
		assertEquals(result, 1);
		
		assertNotNull(mapperController.delete());
	}
}
