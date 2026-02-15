package jaeryang.practice.emailsendproducer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tools.jackson.databind.ObjectMapper;

@Service
@RequiredArgsConstructor
public class EmailService {

	// Spring Kafka에서 제공하는 Producer 전용 클래스. Spring에서 Kafka Producer를 쉽게 사용하게 해주는 고수준 API
	private final KafkaTemplate<String, String> kafkaTemplate;

	public void sendEmail(SendEmailRequestDto request) {
		EmailSendMessage emailSendMessage = EmailSendMessage.from(request);

		kafkaTemplate.send("email.send", toJsonString(emailSendMessage));
	}

	private String toJsonString(Object object) {
		return new ObjectMapper().writeValueAsString(object);
	}
}
