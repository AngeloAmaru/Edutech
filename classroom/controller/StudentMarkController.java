package com.edutech.classroom.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import com.edutech.classroom.entity.StudentMark;
import com.edutech.classroom.service.StudentMarkService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/student-mark")
public class StudentMarkController {
    private final StudentMarkService service;

    @GetMapping
    public List<StudentMark> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<StudentMark> getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public StudentMark create(@RequestBody StudentMark studentMark) {
        return service.save(studentMark);
    }

    @PutMapping("/{id}")
    public StudentMark update(@PathVariable Long id, @RequestBody StudentMark studentMark) {
        studentMark.setId(id != null ? id.intValue() : null);
        return service.save(studentMark);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}
