package kr.or.ddit.service;

import kr.or.ddit.domain.EmailDTO;

public interface EmailService {
	public void sendMail(EmailDTO dto);
}
