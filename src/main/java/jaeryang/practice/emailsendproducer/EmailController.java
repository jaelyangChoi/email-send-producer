package jaeryang.practice.emailsendproducer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/emails")
public class EmailController {

	private final EmailService emailService;

	// 명시적 생성자 추가: Lombok이 없을 경우에도 final 필드를 초기화하도록 함
	public EmailController(EmailService emailService) {
		this.emailService = emailService;
	}

	@PostMapping
	public ResponseEntity<String> sendEmail(@RequestBody SendEmailRequestDto sendEmailRequestDto) {
		emailService.sendEmail(sendEmailRequestDto);
		return ResponseEntity.ok("이메일 발송 요청 완료");
	}
}
