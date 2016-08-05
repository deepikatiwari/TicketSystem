package com.walmart.ticket.service;
import java.util.ArrayList;
import java.util.List;

import com.walmart.ticket.domain.SeatHold;


public interface TicketService {

	//seat neither held  nor reserved
	int numSeatsAvailable(int venueLevel);



	//hold best available seats/
	SeatHold findAndHoldSeats(int numSeats, int minLevel, int maxLevel, String customerEmail);



	//commit held seats. return confirmation code/
	String reserveSeats(int seatHoldId, String customerEmail);
	}

