package com.test.walmart;

import com.walmart.ticket.domain.SeatHold;
import com.walmart.ticket.service.TicketServiceImpl;

public class TicketSystemDemo {

	public static void main(String[] args){
		
	long timeNow = System.currentTimeMillis();
	int noOfSeats=3 ;
	int min = 1;
	int max =2;
	String reservationId;
	String email = "imessedup@gmail.com";
	
	TicketServiceImpl ticketDemo = new TicketServiceImpl();
	SeatHold s = ticketDemo.findAndHoldSeats(noOfSeats, min, max, email);
	
	if(timeNow - s.getHoldStartTime()>30000){
		ticketDemo.cancelHold(s.getId(), email);
	}
	
	else{
		reservationId = ticketDemo.reserveSeats(s.getId(), email);
		System.out.println("Reservation ID is" + reservationId);
	}
	}

}
