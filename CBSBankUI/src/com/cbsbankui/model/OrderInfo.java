package com.cbsbankui.model;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;


@Controller
public class OrderInfo {
	private long id;
	private String details;
	private String expectedDateOfFulfillment;
	private double amount;
	private Vendor vendor;
	
	//constructors
	public OrderInfo() {
		super();
	}
	
	public OrderInfo(String details, String expectedDateOfFulfillment, double amount) {
		super();
		this.details = details;
		this.expectedDateOfFulfillment = expectedDateOfFulfillment;
		this.amount = amount;
	}
	
	//get & set
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getExpectedDateOfFulfillment() {
		return expectedDateOfFulfillment;
	}
	public void setExpectedDateOfFulfillment(String expectedDateOfFulfillment) {
		this.expectedDateOfFulfillment = expectedDateOfFulfillment;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Vendor getVendor() {
		return vendor;
	}
	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}
}
