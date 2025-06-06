package com.edutech.classroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edutech.classroom.entity.SupportTicket;


@Repository
public interface SupportTicketRepository extends JpaRepository<SupportTicket, Long>{

}
