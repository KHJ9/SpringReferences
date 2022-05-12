package kr.or.ddit.security;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import kr.or.ddit.domain.MemberVO;
import kr.or.ddit.mapper.MemberMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
// SpringExtension : Junit과 Spring을 연결시켜준다.
// junit4 사용시 @RunWith(???.class)
@ExtendWith(SpringExtension.class) // junit5
@ContextConfiguration(locations = {"classpath:config/spring/root-context.xml"})
public class MapperTest {

	@Autowired
	MemberMapper memberMapper;
	
	@Test
	public void connTest() {
		MemberVO member = memberMapper.read("test1");
		log.debug("member : " + member.toString());
	}
	
}
