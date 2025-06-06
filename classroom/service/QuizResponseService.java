package com.edutech.classroom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.classroom.entity.QuizResponse;
import com.edutech.classroom.repository.QuizResponseRepository;

@Service
public class QuizResponseService {
    @Autowired
    private QuizResponseRepository repository;

    public List<QuizResponse> findAll(){
        return repository.findAll();
    }

    public Optional<QuizResponse> findById(Long id){
        return repository.findById(id);
    }

    public QuizResponse save(QuizResponse quizresponse){
        return repository.save(quizresponse);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
        }
}