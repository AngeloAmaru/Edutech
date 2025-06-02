package com.edutech.classroom.service;

import org.springframework.stereotype.Service;

import com.edutech.classroom.entity.CourseQuiz;
import com.edutech.classroom.repository.CourseQuizRepository;
import com.edutech.classroom.repository.CourseRepository;
import com.edutech.classroom.entity.Course;
import com.edutech.classroom.dto.CourseQuizDTO;
import com.edutech.classroom.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseQuizService {
    private final CourseQuizRepository courseQuizRepository;
    private final CourseRepository courseService;
    
    public List<CourseQuiz> findAllByCourseId(Integer courseId) {
        Course course = courseService.findById(courseId)
            .orElseThrow(() -> new ResourceNotFoundException("Course not found with id: " + courseId));
        return courseQuizRepository.findAllByCourse(course);
    }

    public CourseQuiz findById(Integer quizId) {
        return courseQuizRepository
            .findById(quizId)
            .orElseThrow(() -> new ResourceNotFoundException("Quiz not found with id: " + quizId));
    
    
            
}
