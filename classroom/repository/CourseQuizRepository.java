package com.edutech.classroom.repository;

import com.edutech.classroom.entity.Course;
import com.edutech.classroom.entity.CourseQuiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseQuizRepository extends JpaRepository<CourseQuiz, Integer> {
    List<CourseQuiz> findAllByCourse(Course course);
}
