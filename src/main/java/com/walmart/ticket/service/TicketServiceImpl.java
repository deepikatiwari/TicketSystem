package com.walmart.ticket.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
//import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.walmart.ticket.domain.Level1;
import com.walmart.ticket.domain.Row;
import com.walmart.ticket.domain.SeatHold;
import com.walmart.ticket.domain.Ticket;
import com.walmart.ticket.domain.Ticket.SeatStatus;

//import com.test.walmart.ticket.database.DatabaseClass;

public class TicketServiceImpl implements TicketService {

	Map<Integer, Level1> levelMap = new HashMap<Integer, Level1>();
	List<SeatHold> seatHold = new ArrayList<SeatHold>();
	List<Ticket> onHoldSeats = new ArrayList<Ticket>();
	int count = 0;

	// TicketServiceImpl t = new TicketServiceImpl();

	public TicketServiceImpl() {

		/* Adding seats to the auditorium. */

		Level1 level1 = new Level1(1250);
		Level1 level2 = new Level1(2000);
		Level1 level3 = new Level1(1500);
		Level1 level4 = new Level1(1500);

		for (int row1 = 1; row1 <= 25; row1++) {

			List<Ticket> ticketList1 = new ArrayList<Ticket>();

			for (int col1 = 1; col1 <= 50; col1++) {
				if (ticketList1.size() != 0) {
					Ticket ticket;

					ticket = new Ticket(ticketList1.size() + 1, row1, col1, 100.00, SeatStatus.AVAILABLE, 1);
					ticketList1.add(ticket);
				}
			}

			Row row = new Row(row1, ticketList1);
			level1.row.put(row1, row);

		}

		levelMap.put(1, level1);

		for (int row2 = 1; row2 <= 20; row2++) {
			List<Ticket> ticketList2 = new ArrayList<Ticket>();
			for (int col2 = 1; col2 <= 100; col2++) {
				if (ticketList2.size() != 0) {
					Ticket ticket;
					ticket = new Ticket(ticketList2.size() + 1, row2, col2, 75.00, SeatStatus.AVAILABLE, 2);
					ticketList2.add(ticket);
				}
			}

			Row row = new Row(row2, ticketList2);
			level2.row.put(row2, row);
		}
		levelMap.put(2, level2);

		for (int row3 = 1; row3 <= 15; row3++) {
			List<Ticket> ticketList3 = new ArrayList<Ticket>();
			for (int col3 = 1; col3 <= 100; col3++) {
				if (ticketList3.size() != 0) {
					Ticket ticket;
					ticket = new Ticket(ticketList3.size() + 1, row3, col3, 50.00, SeatStatus.AVAILABLE, 3);
					ticketList3.add(ticket);
				}
			}

			Row row = new Row(row3, ticketList3);
			level3.row.put(row3, row);
		}

		levelMap.put(3, level3);

		for (int row4 = 1; row4 <= 15; row4++) {
			List<Ticket> ticketList4 = new ArrayList<Ticket>();
			for (int col4 = 1; col4 <= 100; col4++) {
				if (ticketList4.size() != 0) {
					Ticket ticket;
					ticket = new Ticket(ticketList4.size() + 1, row4, col4, 40.00, SeatStatus.AVAILABLE, 4);
					ticketList4.add(ticket);
				}
			}

			Row row = new Row(row4, ticketList4);
			level4.row.put(row4, row);
		}

		levelMap.put(4, level4);
	}

	/* Find number of available seats on a level */

	public int numSeatsAvailable(int venueLevel) {

		int seats = levelMap.get(venueLevel).getNoOfAvailableSeats();
		return seats;
	}

	/* Find and hold seats for the customer */
	public SeatHold findAndHoldSeats(int numSeats, int minLevel, int maxLevel, String customerEmail) {
		int seats;
		SeatHold sh;
		int seatHoldId = 0;
		double totalPrice = 0;

		for (int i = minLevel; i <= maxLevel; i++) {
			Level1 l = levelMap.get(i);
			Map<Integer, Row> m = l.getRow();

			seats = numSeatsAvailable(i);
			if (seats <= numSeats) {
				continue;
			}

			else {

				int seatCountPerRow = 0;
				Iterator it = m.entrySet().iterator(); // map of rows
				while (it.hasNext()) { // loop through rowmap
					List<Ticket> tkt = m.get(i).getSeats(); // seats in each row

					{
						for (Ticket tick : tkt) {

							if (tick.getSeatStatus() == SeatStatus.AVAILABLE) {
								while (seatCountPerRow <= numSeats) {
									tick.setSeatStatus(SeatStatus.HELD);
									totalPrice=totalPrice+tick.getPrice();
									onHoldSeats.add(tick);

								}

								seatCountPerRow++;
							}
						}

					}

					it.next();

				}

				if (seatHold.size() == 0) {
					seatHoldId = 1;
				}

				else {
					seatHoldId = seatHold.get(seatHold.size() - 1).getId() + 1;
				}

			}

			l.setNoOfAvailableSeats(seats - numSeats);
		}

		sh = new SeatHold(seatHoldId, onHoldSeats, customerEmail);
		seatHold.add(sh);
		return sh;
	}

	/* Cancel seats on hold */
	public void cancelHold(int seatHoldId, String customerEmail) {
		Level1 l = new Level1();
		for (SeatHold s : seatHold) {
			if (s.getId() == seatHoldId && s.getCustEmail() == customerEmail) {
				for (Ticket t : s.getTickets()) {
					t.setSeatStatus(SeatStatus.AVAILABLE);
				}

			}

		}
		l.setNoOfAvailableSeats(l.getNoOfAvailableSeats() + seatHold.size());
	}

	/* Reserve the seats on hold */
	public String reserveSeats(int seatHoldId, String customerEmail) {
		// SeatHold sh = new SeatHold();
		for (SeatHold s : seatHold) {
			if (s.getId() == seatHoldId && s.getCustEmail() == customerEmail) {
				for (Ticket l : s.getTickets()) {
					l.setSeatStatus(SeatStatus.RESERVED);
				}
			}
		}

		count++;
		// tick.setSeatStatus(SeatStatus.HELD);

		return seatHoldId + "" + count;
	}

}
