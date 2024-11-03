package com.question.controller;

import com.question.entities.Question;
import com.question.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping
    public ResponseEntity<Question> create(@RequestBody Question question) {
        Question qs = questionService.create(question);
        return new ResponseEntity<>(qs, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> getOne(@PathVariable("id") Long id) {
        Question qs = questionService.getOne(id);
        return new ResponseEntity<>(qs, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Question>> getAll(){
        List<Question> allQs = questionService.getAll();
        return new ResponseEntity<>(allQs, HttpStatus.OK);
    }


    @GetMapping("/quiz/{quizId}")
    public ResponseEntity<?> getQuestionsOfQuiz(@PathVariable Long quizId ){
        List<Question> qstns = questionService.getQuestionsOfQuiz(quizId);
        return new ResponseEntity<>(qstns, HttpStatus.OK);
    }
}
