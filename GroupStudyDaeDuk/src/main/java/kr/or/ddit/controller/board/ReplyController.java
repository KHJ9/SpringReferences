package kr.or.ddit.controller.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.domain.MemberVO;
import kr.or.ddit.domain.ReplyVO;
import kr.or.ddit.security.CustomUser;
import kr.or.ddit.service.board.ReplyService;
import kr.or.ddit.util.CustomUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/reply")
public class ReplyController {

	@Autowired
	ReplyVO replyVo;
	
	@Autowired
	ReplyService replyService;
	
	@ResponseBody
	@GetMapping(value = "/selectReply", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ReplyVO> getReply(ReplyVO replyVo) {
		log.info("댓글을 반환합니다.");
		return replyService.selectReply(replyVo);
	}
	
	@ResponseBody
	@PostMapping(value = "/insertReply", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ReplyVO> insertReply(ReplyVO replyVo) {
		log.info("댓글을 작성합니다.");
		MemberVO member = CustomUtil.getSessionVO();
		replyVo.setReplyWriter(member.getUserid());
		int result = replyService.insertReply(replyVo);
		return replyService.selectReply(replyVo);
	}
	
	@ResponseBody
	@PostMapping(value = "/updateReply", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ReplyVO> updateReply(ReplyVO replyVo) {
		System.out.println("수정 : " + replyVo);
		log.info("댓글을 수정합니다.");
		MemberVO member = CustomUtil.getSessionVO();
		replyVo.setReplyWriter(member.getUserid());
		int result = replyService.updateReply(replyVo);
		return replyService.selectReply(replyVo);
	}
	
	@ResponseBody
	@PostMapping(value = "/deleteReply", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ReplyVO> deleteReply(ReplyVO replyVo) {
		log.info("댓글을 삭제합니다.");
		MemberVO member = CustomUtil.getSessionVO();
		replyVo.setReplyWriter(member.getUserid());
		int result = replyService.deleteReply(replyVo);
		return replyService.selectReply(replyVo);
	}
}
