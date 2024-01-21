package com.javalearn.examquestions.controllers;

import com.javalearn.examquestions.interfaces.ExaminerService;
import com.javalearn.examquestions.model.Question;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RestController
@RequestMapping("/get")
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("{amount}")
    public Set<Question> getQuestions(@PathVariable int amount) {
        return examinerService.getQuestions(amount);
    }
}
