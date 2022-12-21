package com.abhi.bill.pay.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abhi.bill.pay.dto.CustomerDto;



@Repository
public interface CustomerRepository  extends JpaRepository<CustomerDto, Integer> {
	
	CustomerDto findByEmail(String email);

}