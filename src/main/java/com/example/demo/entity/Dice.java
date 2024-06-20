package com.example.demo.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode

public class Dice {
	
	private int numberOfDice;

	public Dice(int numberOfDice) {
		super();
		this.numberOfDice = numberOfDice;
	}
	int rollDice() {
	    int sum = 0;
	    for (int i = 0; i < numberOfDice; i++) {
	        sum += (int)(Math.random() * 6) + 1;
	    }
	    return sum;
	}


}
