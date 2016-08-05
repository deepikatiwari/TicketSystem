package com.walmart.ticket.domain;

import java.util.ArrayList;
//import java.util.HashMap;
import java.util.List;
//import java.util.Map;

public class Row {

	public Row(int rowId, List<Ticket> seats) {
		super();
		this.rowId = rowId;
		this.seats = seats;
	}
	
	int rowId;
	List<Ticket> seats = new ArrayList<Ticket>();
	
	
	public int getRowId() {
		return rowId;
	}
	public void setRowId(int rowId) {
		this.rowId = rowId;
	}
	public List<Ticket> getSeats() {
		return seats;
	}
	public void setSeats(List<Ticket> seats) {
		this.seats = seats;
	}
	
	
}
