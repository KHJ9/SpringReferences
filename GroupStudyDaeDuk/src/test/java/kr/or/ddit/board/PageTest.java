package kr.or.ddit.board;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import kr.or.ddit.domain.BoardVO;
import kr.or.ddit.domain.PageDTO;
import kr.or.ddit.mapper.board.BoardMapper;
import kr.or.ddit.mapper.board.PageMapper;
import kr.or.ddit.service.board.BoardService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(SpringExtension.class) // junit5
@ContextConfiguration(locations = {"classpath:config/spring/root-context.xml"})
public class PageTest {

	@Autowired
	PageMapper pageMapper;
	
	@Test
	//@Disabled
	public void selectTest() {
		
		// 여기 Test할 때는 VO를 autowired하면 자동으로 객체가 생성되지 않는 것 같다.
		PageDTO page = new PageDTO();
		page.setCurPageNum(1);
		page.setTableName("P_BOARD");
		page.setPkName("BOARD_NUM");
		log.info("select : " + pageMapper.select(page));
	}
	
}





