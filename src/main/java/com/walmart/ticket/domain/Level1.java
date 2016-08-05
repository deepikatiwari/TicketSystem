package com.walmart.ticket.domain;

import java.util.HashMap;
import java.util.Map;

public class Level1{

	int noOfAvailableSeats;
	public Map<Integer, Row> row = new HashMap<Integer, Row>();
	
	
	
	public Level1() {
		super();
	}

	public Level1(int noOfAvailableSeats) {
		super();
		this.noOfAvailableSeats = noOfAvailableSeats;
		
	}

	public int getNoOfAvailableSeats() {
		return noOfAvailableSeats;
	}

	public void setNoOfAvailableSeats(int noOfAvailableSeats) {
		this.noOfAvailableSeats = noOfAvailableSeats;
	}

	public Map<Integer, Row> getRow() {
		return row;
	}

	public void setRow(Map<Integer, Row> row) {
		this.row = row;
	}

	
	
	
	
}
