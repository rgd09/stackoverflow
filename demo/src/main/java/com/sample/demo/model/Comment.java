package com.sample.demo.model;

import java.util.Date;

import com.sample.demo.constants.StackOverflowConstants.CommentParentType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

	long id;
	
	long parentId;
	
	CommentParentType parentType;
	
	long userId;
	
	long upvoteCount;
	
	Date Date;
	
	String text;
}
