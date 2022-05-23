package kr.or.ddit.service.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.domain.BoardVO;
import kr.or.ddit.domain.PageDTO;
import kr.or.ddit.mapper.board.BoardMapper;
import kr.or.ddit.mapper.board.PageMapper;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	PageMapper pageMapper;
	
	@Autowired
	BoardMapper boardMapper;
	
	@Override
	public int insertBoard(BoardVO board) {
		// TODO Auto-generated method stub
		return boardMapper.insert(board);
	}

	@Override
	public List<BoardVO> selectBoard(PageDTO page, BoardVO board) {
		// TODO Auto-generated method stub
		if(page == null) { page = new PageDTO(); }
		List<PageDTO> param = pageMapper.select(page);
		boardMapper.select(board);
		return null;
	}

	@Override
	public int updateBoard(BoardVO board) { 
		// TODO Auto-generated method stub
		return boardMapper.update(board);
	}

	@Override
	public int deleteBoard(BoardVO board) {
		// TODO Auto-generated method stub
		return boardMapper.delete(board);
	}
	
}
