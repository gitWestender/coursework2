package com.javalearn.examquestions.services;

import com.javalearn.examquestions.exceptions.FullSet;
import com.javalearn.examquestions.interfaces.ExaminerService;
import com.javalearn.examquestions.interfaces.QuestionService;
import com.javalearn.examquestions.model.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Set<Question> getQuestions(int amount) {
        if (amount > questionService.size()) {
            throw new FullSet("Максимальное количество вопросов - " + questionService.size());
        }
        Set<Question> questionSet = new HashSet<>();
        while (questionSet.size() < amount) {
            questionService.add(questionService.getRandomQuestion());
        }
        return questionSet;
    }
}
