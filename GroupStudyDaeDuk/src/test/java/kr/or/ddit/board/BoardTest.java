package kr.or.ddit.board;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import kr.or.ddit.domain.BoardVO;
import kr.or.ddit.mapper.board.BoardMapper;
import kr.or.ddit.service.board.BoardService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(SpringExtension.class) // junit5
@ContextConfiguration(locations = {"classpath:config/spring/root-context.xml"})
public class BoardTest {

	@Autowired
	BoardService boardService;
	
	@Test
	@Disabled
	public void insertTest() {
		
		for(int i=1; i<200; i++) {
			// 여기 Test할 때는 VO를 autowired하면 자동으로 객체가 생성되지 않는 것 같다.
			BoardVO boardVo = new BoardVO();
			
			boardVo.setBoardWriter("작성자"+i);
			boardVo.setBoardTitle("제목"+i);
			boardVo.setBoardContent("내용"+i);
			
			log.info("insert : " + boardService.insertBoard(boardVo));
		}
	}
	
	@Test
	//@Disabled
	public void selectTest() {
		
		// 여기 Test할 때는 VO를 autowired하면 자동으로 객체가 생성되지 않는 것 같다.
		BoardVO boardVo = new BoardVO();
		
		//boardVo.setCurrentPageNum(3);
		boardVo.setSearchText("2");
		log.info("select : " + boardService.selectBoard(boardVo));
		//log.info("select : " + boardService.selectBoard(null));
	}
	
	@Test
	@Disabled
	public void updateTest() {
		
		// 여기 Test할 때는 VO를 autowired하면 자동으로 객체가 생성되지 않는 것 같다.
		BoardVO boardVo = new BoardVO();
		
		boardVo.setBoardNum("b00007");
		boardVo.setBoardWriter("작성자update");
		boardVo.setBoardTitle("제목update");
		boardVo.setBoardContent("내용update");
		
		log.info("update : " + boardService.updateBoard(boardVo));
	}
	
	@Test
	@Disabled
	public void deleteTest() {
		
		// 여기 Test할 때는 VO를 autowired하면 자동으로 객체가 생성되지 않는 것 같다.
		BoardVO boardVo = new BoardVO();
		
		boardVo.setBoardNum("123");
		
		log.info("delete : " + boardService.deleteBoard(boardVo));
	}
	
}





