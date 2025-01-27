package com.Assignment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Assignment.entity.Question;
import com.Assignment.repository.QuestionRepository;

@Service
public class QuestionService {
	@Autowired
	private QuestionRepository questionRepository;
	
	//create or insert a question
	public Question createQuestion(Question question) {
		return questionRepository.save(question);
		}
	
	//read or get a question by its id
	public Optional<Question> getQuestion(Long qid) {
        return questionRepository.findById(qid);
    }
	
	 // Read all Questions
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }
    
    // Delete a Question by ID
    public void deleteQuestion(Long qid) {
        questionRepository.deleteById(qid);
    }
	
}
