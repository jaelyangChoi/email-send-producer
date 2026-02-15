package jaeryang.practice.emailsendproducer;

public record EmailSendMessage(
	String from,
	String to,
	String subject,
	String body
) {
	public static EmailSendMessage from(SendEmailRequestDto request) {
		return new EmailSendMessage(
			request.from(),
			request.to(),
			request.subject(),
			request.body()
		);
	}
}
