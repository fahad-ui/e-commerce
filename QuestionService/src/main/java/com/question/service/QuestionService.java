package com.question.service;

import com.question.entities.Question;

import java.util.List;

public interface QuestionService {
    Question create(Question question);

    Question getOne(Long id);

    List<Question> getAll();

    List<Question> getQuestionsOfQuiz(Long quizId);
}
