package com.abhi.bill.pay.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "Biller_Data")
public class BillerData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	@Column
	int billerId;
	@Column
	int custId;
	@Column
	int amountToPaid;
	@Column
	String monthYear;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBillerId() {
		return billerId;
	}
	public void setBillerId(int billerId) {
		this.billerId = billerId;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public int getAmountToPaid() {
		return amountToPaid;
	}
	public void setAmountToPaid(int amountToPaid) {
		this.amountToPaid = amountToPaid;
	}
	public String getMonthYear() {
		return monthYear;
	}
	public void setMonthYear(String monthYear) {
		this.monthYear = monthYear;
	}
	
	
}
