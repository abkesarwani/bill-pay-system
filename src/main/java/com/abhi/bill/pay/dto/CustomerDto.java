package com.abhi.bill.pay.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity(name = "Customer")
@SequenceGenerator(name="employee_id_seq", initialValue=3, allocationSize=1000)
public class CustomerDto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="employee_id_seq")
	int id;
	
	@Column
	String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
