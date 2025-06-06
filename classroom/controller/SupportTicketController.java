package com.edutech.classroom.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edutech.classroom.entity.SupportTicket;
import com.edutech.classroom.service.SupportTicketService;

@RestController
@RequestMapping("/api/support-ticket")
public class SupportTicketController {

    @Autowired
    private SupportTicketService service;

    @GetMapping
    public List<SupportTicket> getAll() {
        return service.findAll();
    }

    @GetMapping("{/id}")
    public Optional<SupportTicket> getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public SupportTicket create(@RequestBody SupportTicket supportTicket) {
        return service.save(supportTicket);
    }

    @PutMapping("/{id}")
    public SupportTicket update(@PathVariable Long id, @RequestBody SupportTicket supportTicket) {
        supportTicket.setId(id.intValue());
        return service.save(supportTicket);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }

}
