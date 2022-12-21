package com.abhi.bill.pay.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abhi.bill.pay.dto.CustomerWallet;

@Repository
public interface CustomerWalletRepository extends JpaRepository<CustomerWallet, Integer>{

	CustomerWallet findByCustId(int custId);
	
	

}
