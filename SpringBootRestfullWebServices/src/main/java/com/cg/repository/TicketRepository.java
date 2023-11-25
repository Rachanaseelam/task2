package com.cg.repository;

import org.springframework.data.repository.CrudRepository;

import com.cg.model.Ticket;

public interface TicketRepository extends CrudRepository<Ticket, Integer>{

}
