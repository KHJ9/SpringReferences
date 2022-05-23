package kr.or.ddit.service.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.domain.BoardVO;
import kr.or.ddit.domain.ReplyVO;
import kr.or.ddit.mapper.board.BoardMapper;
import kr.or.ddit.mapper.board.ReplyMapper;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	ReplyMapper replyMapper;
	
	@Override
	public int insertReply(ReplyVO reply) {
		// TODO Auto-generated method stub
		return replyMapper.insert(reply);
	}

	@Override
	public List<ReplyVO> selectReply(ReplyVO reply) {
		// TODO Auto-generated method stub
		return replyMapper.select(reply);
	}

	@Override
	public int updateReply(ReplyVO reply) { 
		// TODO Auto-generated method stub
		return replyMapper.update(reply);
	}

	@Override
	public int deleteReply(ReplyVO reply) {
		// TODO Auto-generated method stub
		return replyMapper.delete(reply);
	}
	
}
