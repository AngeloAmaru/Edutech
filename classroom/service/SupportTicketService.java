package com.edutech.classroom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.classroom.entity.SupportTicket;
import com.edutech.classroom.repository.SupportTicketRepository;


@Service
public class SupportTicketService {
    @Autowired
    private SupportTicketRepository repository;

    public List<SupportTicket> findAll(){
        return repository.findAll();
    }

    public Optional<SupportTicket> findById(Long id){
        return repository.findById(id);
    }

    public SupportTicket save(SupportTicket supportticket){
        return repository.save(supportticket);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
        }

}
