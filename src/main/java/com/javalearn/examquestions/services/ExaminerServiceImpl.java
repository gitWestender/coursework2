package com.javalearn.examquestions.services;

import com.javalearn.examquestions.interfaces.ExaminerService;
import com.javalearn.examquestions.model.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    @Override
    public Collection<Question> getQuestions(int amount) {
        return null;
    }
}
