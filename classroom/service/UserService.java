package com.edutech.classroom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.classroom.entity.User;
import com.edutech.classroom.repository.UserRepository;


@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public Optional<User> findById(Long id){
        return repository.findById(id);
    }

    public User save(User user){
        return repository.save(user);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
        }

}
