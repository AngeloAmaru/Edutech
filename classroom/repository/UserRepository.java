package com.edutech.classroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edutech.classroom.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
