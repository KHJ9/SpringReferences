package kr.or.ddit.controller.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {

	@GetMapping("/getBoard")
	public String getBoard() {
		log.info("게시판을 출력합니다.");
		return "board/board";
	}
	
	@GetMapping("/getEditor")
	public String getEditor() {
		log.info("작성란으로 이동합니다.");
		return "board/writeBoard";
	}
	
	@GetMapping("/doWrite")
	public String doWrite() {
		log.info("게시물을 작성합니다.");
		return "board/writeBoard";
	}
	
	@PostMapping("/insertBoard")
	public String insertBoard() {
		log.info("게시글을 입력합니다.");
		return "";
	}
	
}
