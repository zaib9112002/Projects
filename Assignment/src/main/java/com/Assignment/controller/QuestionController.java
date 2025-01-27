package com.Assignment.controller;

import com.Assignment.entity.Question;
import com.Assignment.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/assignment")
public class QuestionController {
	@Autowired
	private QuestionService questionService;

	public QuestionController(QuestionService questionService) {
		this.questionService = questionService;
	}
	
	// Create a new Question
    @PostMapping("/createquestion")
    public ResponseEntity<Question> createQuestion(@RequestBody Question q1) 
    {
        Question q = questionService.createQuestion(q1);
        return ResponseEntity.ok(q);
    }

    // Get a Question by ID
    @GetMapping("/getquestion/{qid}")
    public ResponseEntity<Question> getQuestion(@PathVariable Long qid) {
        Optional<Question> question = questionService.getQuestion(qid);
        return question.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get all Questions
    @GetMapping("/getAllquestion")
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    // Delete a Question by ID
    @DeleteMapping("/deletequestion/{qid}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Long qid) {
        questionService.deleteQuestion(qid);
        return ResponseEntity.ok().build();
    }
}
