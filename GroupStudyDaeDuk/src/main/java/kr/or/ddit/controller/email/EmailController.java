package kr.or.ddit.controller.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.domain.EmailDTO;
import kr.or.ddit.service.EmailService;

@Controller // 컨트롤러 어노테이션 선언
@RequestMapping("/email") // 공통적인 매핑 주소
public class EmailController {
 
    @Autowired
    EmailService emailService; // 서비스를 호출하기위한 의존성 주입
 
    @GetMapping("/write") // 이메일 쓰기를 누르면 이 메소드로 맵핑되어서
    public String write() {
        return "/email/write"; // 다시 write jsp 페이지로 이동하고 jsp페이지에서 내용을 다 채운 뒤에 확인 버튼을 누르면 send.do로 넘어감
    }
 
    @PostMapping("/send") // 확인 (메일발송) 버튼을 누르면 맵핑되는 메소드
    // @ModelAttribute를 붙여주면 자동으로 model에 담김
    public String send(@ModelAttribute EmailDTO dto, Model model) {
        try {
 
            emailService.sendMail(dto); // dto (메일관련 정보)를 sendMail에 저장함
            model.addAttribute("message", "이메일이 발송되었습니다."); // 이메일이 발송되었다는 메시지를 출력시킨다.
 
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "이메일 발송 실패..."); // 이메일 발송이 실패되었다는 메시지를 출력
        }
        return "/email/write"; // 실패했으므로 다시 write jsp 페이지로 이동함
    }
}