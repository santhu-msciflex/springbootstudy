package com.example.demo.userservice;

import java.util.Date;

public class ResponseExceptionStructure {

	private Date date;
	private String message;
	private String description;

	public ResponseExceptionStructure(Date date, String message, String description) {
		super();
		this.date = date;
		this.message = message;
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public String getMessage() {
		return message;
	}

	public String getDescription() {
		return description;
	}

}
