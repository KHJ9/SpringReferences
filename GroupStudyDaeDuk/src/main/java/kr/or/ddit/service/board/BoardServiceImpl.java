package kr.or.ddit.service.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.domain.BoardVO;
import kr.or.ddit.mapper.board.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapper boardMapper;
	
	@Override
	public int insertBoard(BoardVO board) {
		// TODO Auto-generated method stub
		return boardMapper.insert(board);
	}

	@Override
	public List<BoardVO> selectBoard(BoardVO board) {
		// TODO Auto-generated method stub
		return boardMapper.select(board);
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
