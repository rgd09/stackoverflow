package com.sample.demo.request;

import com.sample.demo.constants.StackOverflowConstants.CommentParentType;

import lombok.Data;

@Data
public class CommentRequest extends GenericRequest{

	CommentParentType type;
}
