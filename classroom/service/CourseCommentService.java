package com.edutech.classroom.service;

import com.edutech.classroom.entity.CourseComment;
import com.edutech.classroom.dto.CourseCommentDTO;
import com.edutech.classroom.repository.CourseCommentRepository;
import com.edutech.classroom.entity.Course;
import com.edutech.classroom.entity.User;
import com.edutech.classroom.exception.ResourceNotFoundException;
import com.edutech.classroom.repository.CourseRepository;
import com.edutech.classroom.repository.UserRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseCommentService {
    private final CourseCommentRepository courseCommentRepository;
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    public List<CourseComment> getCommentsByCourseId(Integer courseId) {
        return courseCommentRepository.findByCourseId(courseId);
    }

    public CourseComment getCommentById(Integer commentId) {
        return courseCommentRepository.findById(commentId)
            .orElseThrow(() -> new ResourceNotFoundException("Comment not found"));
    }

    public CourseComment addComment(Integer courseId, Long userId, CourseCommentDTO commentDTO) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Curso no encontrado con la ID: " + courseId));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con la ID: " + userId));

        CourseComment comment = new CourseComment();
        comment.setCourse(course);
        comment.setUser(user);
        comment.setCommentText(commentDTO.getCommentText());
        return courseCommentRepository.save(comment);
    }

    public void deleteComment(Integer commentId) {
        CourseComment comment = courseCommentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comentario no encontrado por la ID: " + commentId));
        courseCommentRepository.delete(comment);
    }

    public CourseComment updateComment(Integer commentId, CourseCommentDTO commentDTO) {
        CourseComment existingComment = getCommentById(commentId);
        existingComment.setCommentText(commentDTO.getCommentText());
        return courseCommentRepository.save(existingComment);
    }

}
