package com.walmart.ticket.dao;

import java.util.List;

import com.walmart.ticket.domain.Ticket;

public interface TicketDAO {

	public void saveTicket(Ticket ticket);
	public List<Ticket> listTickets();
	
}
