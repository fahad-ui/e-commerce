package com.quiz.controller;

import com.quiz.entities.Quiz;
import com.quiz.services.QuestionClient;
import com.quiz.services.QuizService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService, QuestionClient questionClient) {
        this.quizService = quizService;
    }

    @PostMapping
    public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz){
        Quiz data = quizService.add(quiz);
        return new ResponseEntity<>(data, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quiz> getQuiz(@PathVariable("id") Long id){
        Quiz data = quizService.get(id);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Quiz>> getAllQuizes(){
        List<Quiz> lst =  quizService.getAll();
        return new ResponseEntity<>(lst, HttpStatus.OK);
    }


}
