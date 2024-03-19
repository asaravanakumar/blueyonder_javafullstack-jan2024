package com.examples.cassandra.model;

public class Stock {
	private String ticker;
	private int year;
	private double value;	
	
	// default constructor
	public Stock() {
		
	}
	
	public Stock(String ticker, int year, double value) {
		super();
		this.ticker = ticker;
		this.year = year;
		this.value = value;
	}
	
	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	
}
