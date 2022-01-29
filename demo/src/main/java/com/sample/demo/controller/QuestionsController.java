package com.sample.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sample.demo.exceptions.StackOverflowBusinesssException;
import com.sample.demo.model.Answer;
import com.sample.demo.model.Comment;
import com.sample.demo.model.Question;
import com.sample.demo.request.CommentRequest;
import com.sample.demo.request.GenericRequest;
import com.sample.demo.request.QuestionRequest;
import com.sample.demo.service.QuestionService;

@RestController
public class QuestionsController {

	@Autowired
	QuestionService questionService;

	@RequestMapping(path = "/questions/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Question addQuestion(QuestionRequest request) throws StackOverflowBusinesssException {

		Question response = questionService.addQuesiton(request);
		return response;

	}

	@RequestMapping(path = "/question/{questionId}/answer/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Answer addAnswer(@PathVariable Long questionId, GenericRequest request)
			throws StackOverflowBusinesssException {

		Answer response = questionService.addAnswerToQuestion(questionId, request);
		return response;

	}

	@RequestMapping(path = "/question/{parentId}/comment/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Comment addCommentToParentId(@PathVariable Long parentId, CommentRequest request)
			throws StackOverflowBusinesssException {

		Comment response = questionService.addCommentToParentId(parentId, request);
		return response;

	}

}
