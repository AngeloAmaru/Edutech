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

import com.edutech.classroom.service.RoleService;
import com.edutech.classroom.entity.Role;


@RestController
@RequestMapping("/api/role")
public class RoleController {
    @Autowired
    private RoleService service;

    @GetMapping
    public List<Role> getAll() {
        return service.findAll();
    }

    @GetMapping("{/id}")
    public Optional<Role> getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Role create(@RequestBody Role role) {
        return service.save(role);
    }

    @PutMapping("/{id}")
    public Role update(@PathVariable Long id, @RequestBody Role role) {
        role.setId(id.intValue());
        return service.save(role);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }

}
