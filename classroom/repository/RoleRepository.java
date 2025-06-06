package com.edutech.classroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edutech.classroom.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

}
