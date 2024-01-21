package com.javalearn.examquestions;

import com.javalearn.examquestions.exceptions.*;
import com.javalearn.examquestions.interfaces.QuestionService;
import com.javalearn.examquestions.model.Question;
import com.javalearn.examquestions.services.ExaminerServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceTests {
    @Mock
    private QuestionService questionService;
    @InjectMocks
    private ExaminerServiceImpl out;

    public static final Question Q_1 = new Question("Вопрос1", "Ответ1");
    private static final Question Q_2 = new Question("Вопрос2", "Ответ2");
    public static final Question Q_3 = new Question("Вопрос3", "Ответ3");

    @Test
    public void getQuestionOrThrow() {
        when(questionService.size()).thenReturn(3);
        assertThrows(FullSet.class, () -> out.getQuestions(7));
    }

    @Test
    public void getQuestionTest() {
        when(questionService.getRandomQuestion())
                .thenReturn(Q_1, Q_2, Q_3);
        when(questionService.size())
                .thenReturn(5);
        assertEquals(out.getQuestions(3).size(), 3);
    }

    @Test
    public void getQuestionIfContains() {
        when(questionService.getRandomQuestion())
                .thenReturn(Q_1, Q_2, Q_3);
        when(questionService.size())
                .thenReturn(5);
        assertTrue(out.getQuestions(3).contains(Q_2));
    }
}
