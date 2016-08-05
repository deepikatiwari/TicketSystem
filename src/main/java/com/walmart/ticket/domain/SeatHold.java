package com.walmart.ticket.domain;
import java.util.List;

public class SeatHold {

	private int id;
	//private boolean onHold;
	private List<Ticket> tickets;
	private String custEmail;
	private double totalCost;
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	private long holdStartTime = System.currentTimeMillis() ;
	
	
	
	public long getHoldStartTime() {
		return holdStartTime;
	}
	public void setHoldStartTime(long holdStartTime) {
		this.holdStartTime = holdStartTime;
	}
	public SeatHold() {
		super();
	}
	public SeatHold(int id, List<Ticket> tickets, String email) {
		super();
		this.id = id;
		this.tickets = tickets;
		custEmail = email;
		
		
	}
	public String getCustEmail() {
		return custEmail;
	}
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	/**
	 * @return the tickets
	 */
	public List<Ticket> getTickets() {
		return tickets;
	}
	/**
	 * @param tickets the tickets to set
	 */
	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * @return the onHold
	 *//*
	public boolean isOnHold() {
		return onHold;
	}
	*//**
	 * @param onHold the onHold to set
	 *//*
	public void setOnHold(boolean onHold) {
		this.onHold = onHold;
	}*/
}
