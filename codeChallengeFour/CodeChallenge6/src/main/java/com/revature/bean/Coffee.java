package com.revature.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "COFFEE")
public class Coffee implements Serializable {

	private static final long serialVersionUID = 902824051055546189L;

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

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "coffeeSequence")
	@SequenceGenerator(allocationSize = 1, name = "coffeeSequence", sequenceName = "SQ_COFFEE_PK")
	@Column(name = "COFFEE_ID")
	int coffeeId;

	@Column(name = "COFFEE_TYPE")
	String coffeeType;

	@Column(name = "COFFEE_AMOUNT")
	int amount;

	@Column(name = "COFFEE_AMOUNT")
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
