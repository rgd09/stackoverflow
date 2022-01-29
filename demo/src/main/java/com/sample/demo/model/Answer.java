package com.sample.demo.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Answer {

	
	long id;
	
	long questionId;
	
	long userId;
	
	boolean isAcceptedAnswer;
	
	long upvoteCount;
	
	String text;
	
	String description;
	
	Date date;
}
