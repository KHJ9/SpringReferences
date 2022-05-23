package kr.or.ddit.service.board;

import java.util.List;

import kr.or.ddit.domain.ReplyVO;

public interface ReplyService {

	public int insertReply(ReplyVO reply);
	public List<ReplyVO> selectReply(ReplyVO reply);
	public int updateReply(ReplyVO reply);
	public int deleteReply(ReplyVO reply);
	
}
