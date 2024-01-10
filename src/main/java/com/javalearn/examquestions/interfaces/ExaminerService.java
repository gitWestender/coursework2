package com.javalearn.examquestions.interfaces;

import com.javalearn.examquestions.model.Question;

import java.util.*;

public interface ExaminerService {
    Set<Question> getQuestions(int amount);
}
