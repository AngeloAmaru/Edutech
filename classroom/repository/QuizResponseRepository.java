
package com.edutech.classroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edutech.classroom.entity.QuizResponse;

@Repository
public interface QuizResponseRepository extends JpaRepository<QuizResponse, Long>{

}
