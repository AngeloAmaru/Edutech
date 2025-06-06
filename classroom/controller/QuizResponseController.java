package com.edutech.classroom.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edutech.classroom.service.QuizResponseService;
import com.edutech.classroom.entity.QuizResponse;


@RestController
@RequestMapping("/api/quiz-response")
public class QuizResponseController {
    @Autowired
    private QuizResponseService service;

    @GetMapping
    public List<QuizResponse> getAll() {
        return service.findAll();
    }

    @GetMapping("{/id}")
    public Optional<QuizResponse> getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public QuizResponse create(@RequestBody QuizResponse quizResponse) {
        return service.save(quizResponse);
    }

    @PutMapping("/{id}")
    public QuizResponse update(@PathVariable Long id, @RequestBody QuizResponse quizResponse) {
        quizResponse.setId(id.intValue());
        return service.save(quizResponse);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }

}
