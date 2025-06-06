package com.edutech.classroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edutech.classroom.entity.StudentMark;


@Repository
public interface StudentMarkRepository extends JpaRepository<StudentMark, Long>{

}
