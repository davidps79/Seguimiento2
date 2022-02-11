package model;

import exception.NegativeNumberException;

public class Ingredient {
	private String name;
	private double weight;
	
	public Ingredient(String n, double w) {
		try {
			if (weight < 0)
				throw new NegativeNumberException("This value cannot be negative");
			name = n;
			weight = w;
		} catch (Exception e) {
			System.out.println("Exception HANDLED");
		}
	}
	
	public String getName() {
		return name;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void addWeight(double additionalW) throws NegativeNumberException{
		if (additionalW < 0)
			throw new NegativeNumberException("Cannot add a negative value");
		
		weight = weight + additionalW;		
	}
	
	public void removeWeight(double minusW) {
		try {
			if (weight < minusW)
				throw new NegativeNumberException("The weight value cannot be negative");
			
			weight = weight - minusW;
		} catch (NegativeNumberException e) {
			e.printStackTrace();
			System.out.println("Exception HANDLED");
		}
		
	}
	
}
