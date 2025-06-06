package com.edutech.classroom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.classroom.entity.Role;
import com.edutech.classroom.repository.RoleRepository;


@Service
public class RoleService {
    @Autowired
    private RoleRepository repository;

    public List<Role> findAll(){
        return repository.findAll();
    }

    public Optional<Role> findById(Long id){
        return repository.findById(id);
    }

    public Role save(Role role){
        return repository.save(role);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
        }
}
