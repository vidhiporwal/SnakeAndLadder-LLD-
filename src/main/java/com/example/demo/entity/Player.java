package com.example.demo.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode
public class Player {
	
	private int id;
	private String playerName;
	public Player(String playerName, int id) {
		super();
		this.id = id;
		this.playerName = playerName;
	}
	

}
