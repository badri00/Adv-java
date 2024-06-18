package com.app.dto;

import java.time.LocalDateTime;

public class ApiResponse {

	private String msg;
	private LocalDateTime datetime;

	public ApiResponse(String msg) {
		super();
		this.msg = msg;
		this.datetime = datetime.now();
	}

}
