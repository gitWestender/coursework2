package com.javalearn.examquestions.interfaces;

import com.javalearn.examquestions.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
