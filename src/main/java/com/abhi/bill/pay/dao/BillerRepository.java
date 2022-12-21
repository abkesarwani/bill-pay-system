package com.abhi.bill.pay.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abhi.bill.pay.dto.Biller;

@Repository
public interface BillerRepository extends JpaRepository<Biller, Integer> {
	
	

}
