package jaeryang.practice.emailsendproducer;

public record SendEmailRequestDto(String from, String to, String subject, String body) { }
