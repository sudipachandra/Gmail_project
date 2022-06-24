package com.sudipa.qaautomation;

public class MailData {
	private String to;
	private String from;
	private String subject;
	private String body;

	public MailData(String to, String from, String subject, String body) {
		this.to = to;
		this.from = from;
		this.subject = subject;
		this.body = body;
	}

	public String getTo() {
		return to;
	}

	public String getFrom() {
		return from;
	}

	public String getSubject() {
		return subject;
	}

	public String getBody() {
		return body;
	}
}
