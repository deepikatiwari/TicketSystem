package com.test.walmart.ticket.database;


import java.util.HashMap;

import java.util.Map;

import com.walmart.ticket.domain.LevelMap;
//import com.walmart.ticket.domain.Ticket;

public class DatabaseClass {
	
	private static Map<Integer, LevelMap> ticketOnLevels = new HashMap<Integer, LevelMap>();
		
	public static Map<Integer, LevelMap> getTickets(){
		return ticketOnLevels;
	}
	}
	


