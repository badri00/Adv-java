package com.app.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ApiResponse {
	private String msg;
	private LocalDateTime datetime;
	
	public ApiResponse(String msg) {
		super();
		this.msg=msg;
		this.datetime=datetime.now();
	}
}
