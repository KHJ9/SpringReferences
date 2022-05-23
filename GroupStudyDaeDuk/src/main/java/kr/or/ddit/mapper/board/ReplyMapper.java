package kr.or.ddit.mapper.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.domain.BoardVO;
import kr.or.ddit.domain.ReplyVO;

@Mapper
public interface ReplyMapper {

	public int insert(ReplyVO reply);
	public List<ReplyVO> select(ReplyVO reply);
	public int update(ReplyVO reply);
	public int delete(ReplyVO reply);
	
}
