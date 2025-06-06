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

    public CourseQuiz create(Integer courseId, CourseQuizDTO quizDTO) {
        Course course = courseService.findById(courseId)
            .orElseThrow(() -> new ResourceNotFoundException("Course not found with id: " + courseId));
        
        CourseQuiz quiz = CourseQuizDTO.toEntity(quizDTO);
        quiz.setCourse(course);
        return courseQuizRepository.save(quiz);
    }
    public CourseQuiz update(Integer quizId, CourseQuizDTO quizDTO) {
        CourseQuiz existingQuiz = findById(quizId);
        CourseQuiz updatedQuiz = CourseQuizDTO.toEntity(quizDTO);
        updatedQuiz.setId(existingQuiz.getId());
        updatedQuiz.setCourse(existingQuiz.getCourse());
        return courseQuizRepository.save(updatedQuiz);
    }
    public void delete(Integer quizId) {
        CourseQuiz quiz = findById(quizId);
        courseQuizRepository.delete(quiz);
    }
    
            
}
