package com.walmart.ticket.domain;

import java.util.HashMap;
import java.util.Map;

public class LevelMap {

	
	public LevelMap() {
		super();
	}

	public Map<Integer, Level1> level = new HashMap<Integer, Level1>();

	public LevelMap(Map<Integer, Level1> level) {
		super();
		this.level = level;
	}

	public Map<Integer, Level1> getLevel1() {
		return level;
	}

	public void setLevel1(Map<Integer, Level1> level) {
		this.level = level;
	}
}
