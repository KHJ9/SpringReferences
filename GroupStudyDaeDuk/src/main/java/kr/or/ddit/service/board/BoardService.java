package kr.or.ddit.service.board;

import java.util.List;

import kr.or.ddit.domain.BoardVO;
import kr.or.ddit.domain.PageDTO;

public interface BoardService {

	public int insertBoard(BoardVO board);
	public List<BoardVO> selectBoard(PageDTO page, BoardVO board);
	public int updateBoard(BoardVO board);
	public int deleteBoard(BoardVO board);
	
}
