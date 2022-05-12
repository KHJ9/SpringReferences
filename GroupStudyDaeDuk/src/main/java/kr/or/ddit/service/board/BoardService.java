package kr.or.ddit.service.board;

import java.util.List;

import kr.or.ddit.domain.BoardVO;

public interface BoardService {

	public int insertBoard(BoardVO board);
	public List<BoardVO> selectBoard(BoardVO board);
	public int updateBoard(BoardVO board);
	public int deleteBoard(BoardVO board);
	
}
