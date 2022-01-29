package com.sample.demo.request;

import java.util.List;

import lombok.Data;

@Data
public class QuestionRequest {
	
	long userId;
	
	String text;
	
	String description;
	
	List<Long> tagids;

}
