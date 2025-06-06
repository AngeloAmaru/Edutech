package com.edutech.classroom.controller;

import java.util.List;

import com.edutech.classroom.dto.CourseQuizDTO;
import com.edutech.classroom.service.CourseQuizService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/courses/{courseId}/quizzes")
@RequiredArgsConstructor
public class CourseQuizController {
    private final CourseQuizService courseQuizService;

    @GetMapping
    public ResponseEntity<List<CourseQuizDTO>> getAllQuizzes(@PathVariable Integer courseId) {
        List<CourseQuizDTO> quizzes = courseQuizService.findAllByCourseId(courseId)
            .stream()
            .map(CourseQuizDTO::fromEntity) // Assumes a static fromEntity(CourseQuiz) method exists
            .toList();
        return ResponseEntity.ok(quizzes);
    }

    @GetMapping("/{quizId}")
    public ResponseEntity<CourseQuizDTO> getQuizById(@PathVariable Integer courseId, @PathVariable Integer quizId) {
        CourseQuizDTO quiz = CourseQuizDTO.fromEntity(courseQuizService.findById(quizId));
        return ResponseEntity.ok(quiz);
    }

    @PostMapping
    public ResponseEntity<CourseQuizDTO> createQuiz(@PathVariable Integer courseId, @RequestBody CourseQuizDTO quizDTO) {
        CourseQuizDTO createdQuiz = CourseQuizDTO.fromEntity(courseQuizService.create(courseId, quizDTO));
        return ResponseEntity.status(201).body(createdQuiz);
    }

    @PutMapping("/{quizId}")
    public ResponseEntity<CourseQuizDTO> updateQuiz(@PathVariable Integer courseId, @PathVariable Integer quizId, @RequestBody CourseQuizDTO quizDTO) {
        CourseQuizDTO updatedQuiz = CourseQuizDTO.fromEntity(courseQuizService.update(quizId, quizDTO));
        return ResponseEntity.ok(updatedQuiz);
    }
    
    @DeleteMapping("/{quizId}")
    public ResponseEntity<Void> deleteQuiz(@PathVariable Integer courseId, @PathVariable Integer quizId) {
        courseQuizService.delete(quizId);
        return ResponseEntity.noContent().build();
    }
}
