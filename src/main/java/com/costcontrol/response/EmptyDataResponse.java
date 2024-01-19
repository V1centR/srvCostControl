package com.costcontrol.response;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class EmptyDataResponse {
	
	private String msg;
	private HttpStatus status;


}
