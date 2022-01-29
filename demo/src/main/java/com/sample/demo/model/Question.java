package com.sample.demo.model;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Question {
	

	long id;
	
	long userId;
	
	String  text;
	
	String description;
	
	boolean isResolved;
	
	Date date;
	
	long upvoteCount;
	
	List<Long> tagId;
}
