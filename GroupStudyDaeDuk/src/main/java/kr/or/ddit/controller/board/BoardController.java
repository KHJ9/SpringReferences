package kr.or.ddit.controller.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.domain.BoardVO;
import kr.or.ddit.service.board.BoardService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	BoardVO boardVo;
	
	@Autowired
	BoardService boardService;
	
	@GetMapping("/getBoard")
	public String getBoard(Model model, BoardVO boardVo) {
		log.info("게시판을 출력합니다.");
		List<BoardVO> boardList = boardService.selectBoard(boardVo);
		System.out.println(boardList.size());
		model.addAttribute("board", boardList);
		return "board/board";
	}
	
	@GetMapping("/writeBoard")
	public String writeBoard() {
		log.info("작성란으로 이동합니다.");
		return "board/writeBoard";
	}
	
	@PostMapping("/writeBoard")
	public String writeBoard(Model model, BoardVO boardVo) {
		log.info("게시물을 작성합니다.");
		boardService.insertBoard(boardVo);
		return "redirect:getBoard";
	}
	
	@GetMapping("/viewBoard")
	public String viewBoard(Model model, String boardNum) {
		log.info("특정 게시물을 조회합니다.");
		boardVo.setBoardNum(boardNum);
		BoardVO board = boardService.selectBoard(boardVo).get(0);
		model.addAttribute("board", board);
		return "board/viewBoard";
	}
	
	@GetMapping("/updateBoard")
	public String updateBoard(Model model, String boardNum) {
		log.info("게시물을 수정란으로 이동합니다.");
		boardVo.setBoardNum(boardNum);
		BoardVO board = boardService.selectBoard(boardVo).get(0);
		model.addAttribute("board", board);
		return "board/writeBoard";
	}
	
	@PostMapping("/updateBoard")
	public String updateBoard(HttpServletRequest request, Model model, BoardVO boardVo) {
		log.info("특정 게시물을 수정합니다.");
		boardService.updateBoard(boardVo);
		return "redirect:getBoard";
	}
	
	@ResponseBody
	@PostMapping(value = "/deleteBoard", produces = MediaType.APPLICATION_JSON_VALUE)
	public String deleteBoard(Model model, String boardNum) {
		log.info("특정 게시물을 삭제합니다.");
		boardVo.setBoardNum(boardNum);
		boardService.deleteBoard(boardVo);
		List<BoardVO> boardList = boardService.selectBoard(null);
		model.addAttribute("board", boardList);
		return "게시글 삭제 완료!";
	}
	
}
