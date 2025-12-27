package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.Ticket;
import com.examly.springapp.repository.TicketRepo;

@RestController
@RequestMapping("/tick")
public class TicketController {

    @Autowired
    private TicketRepo ticketRepo;

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> tic(@PathVariable int id) {
        Ticket ticket = ticketRepo.findById((long) id).orElse(null);
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }
}
