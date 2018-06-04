package com.revature.beans;

public class Coffee {

	public Coffee(int coffeeId, String coffeeType, int amount, double price) {
		super();
		this.coffeeId = coffeeId;
		this.coffeeType = coffeeType;
		this.amount = amount;
		this.price = price;
	}

	public Coffee(String coffeeType, int amount, double price) {
		super();
		this.coffeeType = coffeeType;
		this.amount = amount;
		this.price = price;
	}

	public Coffee() {
		super();
	}

	int coffeeId;

	String coffeeType;

	int amount;

	double price;

	public int getCoffeeId() {
		return coffeeId;
	}

	public void setCoffeeId(int coffeeId) {
		this.coffeeId = coffeeId;
	}

	public String getCoffeeType() {
		return coffeeType;
	}

	public void setCoffeeType(String coffeeType) {
		this.coffeeType = coffeeType;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Coffee [coffeeId=" + coffeeId + ", coffeeType=" + coffeeType + ", amount=" + amount + ", price=" + price
				+ "]";

	}
}
