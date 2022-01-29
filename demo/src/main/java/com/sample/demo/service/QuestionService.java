package com.sample.demo.service;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.demo.constants.StackOverflowConstants.CommentParentType;
import com.sample.demo.exceptions.StackOverflowBusinesssException;
import com.sample.demo.model.Answer;
import com.sample.demo.model.Comment;
import com.sample.demo.model.Question;
import com.sample.demo.repository.AnswerRepository;
import com.sample.demo.repository.CommentRepository;
import com.sample.demo.repository.QuestionsRepostiory;
import com.sample.demo.repository.Repository;
import com.sample.demo.request.CommentRequest;
import com.sample.demo.request.GenericRequest;
import com.sample.demo.request.QuestionRequest;
import com.sample.demo.response.QuestionResponse;

@Service
public class QuestionService {

	@Autowired
	QuestionsRepostiory questionRepo;
	
	@Autowired
	AnswerRepository answerRepo;
	
	@Autowired
	CommentRepository commentRepo;
	


	public Question addQuesiton(QuestionRequest request) {
		Question question = new Question();
		question.setDate(new Date());
		question.setDescription(request.getDescription());
		question.setResolved(false);
		question.setText(request.getText());
		question.setUserId(request.getUserId());
		questionRepo.add(question);
		
		return question;
	}

	public Answer addAnswerToQuestion(Long questionId, GenericRequest request) throws StackOverflowBusinesssException {
		
		Question ques = questionRepo.getById(questionId);
		if(ques == null) {
			throw new StackOverflowBusinesssException("Quesiton Id not found");
		}
		Answer answer = new Answer();
		answer.setQuestionId(questionId);
		answer.setDate(new Date());
		answer.setDescription(request.getDescription());
		answer.setUserId(request.getUserId());
		answer.setUpvoteCount(0);
		answer.setText(request.getText());
		answerRepo.add(answer);
		return answer;
		
	}

	public Comment addCommentToParentId(Long parentId, CommentRequest request) throws StackOverflowBusinesssException {
		// TODO Auto-generated method stub
		
		CommentParentType parentType = request.getType();
		Repository repo = getRepoFactory(parentType);
		Object  ques = repo.getById(parentId);
		if(ques == null) {
			throw new StackOverflowBusinesssException("Quesiton Id not found");
		}
		Comment comment = new Comment();
		comment.setParentId(parentId);
		comment.setParentType(parentType);
		comment.setDate(new Date());
		comment.setUserId(request.getUserId());
		comment.setUpvoteCount(0);
		comment.setText(request.getText());
		commentRepo.add(comment);
		return comment;
	}
	
	
	public  Repository getRepoFactory(CommentParentType type) {
		
		switch (type) {
		case comment:
			return commentRepo;
		case question:
			return questionRepo;
		case answer:
			return answerRepo;
		default:
			break;
		}
		return null;
	}
	
}
