package com.javafullstackdev.demo.model;

public class Greeting {

	private String message;
	private String from;

	public Greeting(String message, String from) {
		super();
		this.message = message;
		this.from = from;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

}
