package kr.or.ddit.mapper.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.domain.BoardVO;

@Mapper
public interface BoardMapper {

	public int insert(BoardVO board);
	public List<BoardVO> select(BoardVO board);
	public int update(BoardVO board);
	public int delete(BoardVO board);
	
}
