package com.edutech.classroom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.classroom.entity.StudentMark;
import com.edutech.classroom.repository.StudentMarkRepository;

@Service
public class StudentMarkService {
    @Autowired
    private StudentMarkRepository repository;

    public List<StudentMark> findAll(){
        return repository.findAll();
    }

    public Optional<StudentMark> findById(Long id){
        return repository.findById(id);
    }

    public StudentMark save(StudentMark studentmark){
        return repository.save(studentmark);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
        }
}