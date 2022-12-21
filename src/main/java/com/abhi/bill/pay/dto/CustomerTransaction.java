package com.abhi.bill.pay.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity(name = "Customer_Transaction")
public class CustomerTransaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	@Column
	int custId;
	@Column
	int billerId;
	@Column
	int  amount ;
	@Column
	 String type ;
	@Column
	 String paymentMthd;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public int getBillerId() {
		return billerId;
	}
	public void setBillerId(int billerId) {
		this.billerId = billerId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPaymentMthd() {
		return paymentMthd;
	}
	public void setPaymentMthd(String paymentMthd) {
		this.paymentMthd = paymentMthd;
	}
	
	
	

}
