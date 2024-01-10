package com.javalearn.examquestions.interfaces;

import com.javalearn.examquestions.model.Question;

import java.util.Collection;

public interface QuestionService {
    Question add (String question, String answer);
    Question add (Question question);
    Question remove (Question question);
    Collection<Question> getAll();
    Question getRandomQuestion();
    Question find(String question);
    int size();
}
