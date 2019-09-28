package com.micro.app.ws.response.mapper;

import java.util.Date;

public class CustomErrorResponse {
	private Date date;
	private String message;

	public CustomErrorResponse() {
		super();
	}

	public CustomErrorResponse(Date date, String message) {
		super();
		this.date = date;
		this.message = message;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
