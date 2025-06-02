package com.edutech.classroom.repository;

import com.edutech.classroom.entity.CourseComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseCommentRepository extends JpaRepository<CourseComment, Integer> {
    List<CourseComment> findByCourseId(Integer courseId);

}