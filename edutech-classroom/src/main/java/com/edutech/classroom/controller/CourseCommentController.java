package com.edutech.classroom.controller;

import com.edutech.classroom.service.CourseCommentService;
import com.edutech.classroom.dto.CourseCommentDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.edutech.classroom.entity.CourseComment;

import lombok.RequiredArgsConstructor;

import java.util.List;



@RestController
@RequestMapping("/api/courses/{courseId}/comments")
@RequiredArgsConstructor
public class CourseCommentController {
    private final CourseCommentService courseCommentService;

    @GetMapping
    public ResponseEntity<List<CourseComment>> getCommentsByCourseId(@PathVariable Integer courseId) {
        List<CourseComment> comments = courseCommentService.getCommentsByCourseId(courseId);
        return ResponseEntity.ok(comments);
    }

    @PostMapping
    public ResponseEntity<CourseComment> addComment(
            @PathVariable Integer courseId,
            @RequestParam Integer userId,
            @RequestBody CourseCommentDTO commentDTO) {
        CourseComment comment = courseCommentService.addComment(courseId, userId, commentDTO);
        return ResponseEntity.status(201).body(comment);
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Integer commentId) {
        courseCommentService.deleteComment(commentId);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{commentId}")
    public ResponseEntity<CourseComment> updateComment(
            @PathVariable Integer commentId,
            @RequestBody CourseCommentDTO commentDTO) {
        CourseComment updatedComment = courseCommentService.updateComment(commentId, commentDTO);
        return ResponseEntity.ok(updatedComment);
    }
}
