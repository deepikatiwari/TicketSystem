package com.walmart.ticket.domain;

public class Ticket {

	public enum Level{
		
		ORCHESTRA(1),
		MAIN(2),
		BALCONY1(3),
		BALCONY2(4);
		
		//private int level_id;
		Level(int level){
			level_id=level;
		}
		}
			
	public enum SeatStatus{
		AVAILABLE,
		HELD,
		RESERVED;
		
		}
			
	private int id;
	private int row;
	private int seatNumberinRow;
	private double price;
	private SeatStatus status;
	private static int level_id;
	
	
	
	public Ticket(int id, int row, int seatNumberinRow, double price, SeatStatus status, int level) {
		super();
		this.id = id;
		this.row = row;
		this.seatNumberinRow = seatNumberinRow;
		this.price = price;
		this.status = status;
		//this.level = level;
	}

	public SeatStatus getSeatStatus(){
		return status;
	}
	
	public void setSeatStatus(SeatStatus status){
		this.status=status;
	}
	
	public int getLevel(){
		return level_id ;
	}
	
	public void setLevel(int level){
		level_id=level;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getSeatNumberinRow() {
		return seatNumberinRow;
	}
	public void setSeatNumberinRow(int seatNumberinRow) {
		this.seatNumberinRow = seatNumberinRow;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
}
