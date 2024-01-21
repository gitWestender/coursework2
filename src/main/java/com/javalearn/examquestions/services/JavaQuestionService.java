package com.javalearn.examquestions.services;

import com.javalearn.examquestions.exceptions.QuestionNotFound;
import com.javalearn.examquestions.interfaces.QuestionService;
import com.javalearn.examquestions.model.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private final ArrayList<Question> listQuestion = new ArrayList<>(List.of(
            new Question(
                    "Какие условные операторы вы знаете ? Дайте краткое определение каждому из них",
                    "верный ответ"
            ),
            new Question(
                    "По каким параметрам переменные различаются?",
                    "верный ответ")
    ));

    @Override
    public Question add(String question, String answer) {
        Question q = new Question(question, answer);
        if (listQuestion.contains(q)) {
            throw new IllegalArgumentException("Вопрос уже есть в списке");
        }
        listQuestion.add(q);
        return q;
    }

    @Override
    public Question add(Question question) {
        listQuestion.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (listQuestion.remove(question)) {
            return question;
        }
        throw new QuestionNotFound("Вопрос не найден");
    }

    @Override
    public Collection<Question> getAll() {
        return listQuestion;
    }

    @Override
    public Question getRandomQuestion() {
        Random rnd = new Random();
        return listQuestion.get(rnd.nextInt(listQuestion.size()));
    }

    @Override
    public Question find(String question) {
        return listQuestion.stream()
                .filter(e -> e.getQuestion().equals(question))
                .findFirst()
                .orElseThrow(QuestionNotFound::new);
    }

    @Override
    public int size() {
        return listQuestion.size();
    }

}
