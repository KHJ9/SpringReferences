package kr.or.ddit.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(SpringExtension.class) // junit5 사용설정
@ContextConfiguration(locations = 
	{"classpath:config/spring/root-context.xml"})
public class SimpleTest {
	
	@Autowired
	DataSource dataSource;
	
	@Test
	public void myTest() throws Exception {
		// assert : ~이어야 한다.
		// assertNotNull : null이 아니어야 한다.
		// 이렇게 사용하는 것이 단위 테스트의 기본 틀이다.
		// 테스트를 할 때는 assert 메소드를 사용한다.
		assertNotNull(dataSource.getConnection());
	}
}
