package com.cbs.banking.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class OrderInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(length=1000)
	private String details;
	private LocalDate expectedDateOfFulfillment;
	private double amount;
	private String status;
	@OneToOne
	private Vendor vendor;
	
	//constructors
	public OrderInfo() {
		super();
	}
	
	public OrderInfo(String details, LocalDate expectedDateOfFulfillment, double amount, Vendor vendor) {
		super();
		this.details = details;
		this.expectedDateOfFulfillment = expectedDateOfFulfillment;
		this.amount = amount;
		this.vendor = vendor;
	}
	
	//get & set
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

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
	public LocalDate getExpectedDateOfFulfillment() {
		return expectedDateOfFulfillment;
	}
	public void setExpectedDateOfFulfillment(LocalDate expectedDateOfFulfillment) {
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
