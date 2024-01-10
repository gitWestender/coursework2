package com.javalearn.examquestions.controllers;

import com.javalearn.examquestions.model.Question;
import com.javalearn.examquestions.services.JavaQuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/java")
public class JavaQuestionController {
    private final JavaQuestionService jqServ;

    public JavaQuestionController(JavaQuestionService javaQuestionService) {
        this.jqServ = javaQuestionService;
    }

    @GetMapping("/add")
    public Question add(@RequestParam String question, @RequestParam String answer) {
        Question q = new Question(question, answer);
        return jqServ.add(q);
    }

    @GetMapping("/remove")
    public Question remove(@RequestParam String question, @RequestParam String answer) {
        Question q = new Question(question, answer);
        return jqServ.add(q);
    }

    @GetMapping("/find")
    public Question find(@RequestParam String question) {
        return jqServ.find(question);
    }

    @GetMapping("/getall")
    public Collection<Question> getQuestions() {
        return jqServ.getAll();
    }
}
