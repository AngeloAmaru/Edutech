package com.edutech.classroom.repository;

import org.springframework.stereotype.Repository;
import com.edutech.classroom.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CourseRepository extends JpaRepository <Course, Integer>{
    }