package com.abhi.bill.pay.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abhi.bill.pay.dto.BillerData;

@Repository
public interface BillerDataRepository extends JpaRepository<BillerData, Integer> {


	BillerData findByBillerIdAndCustId(int custId, int billerId);

	BillerData findByBillerIdAndCustIdAndMonthYear(int billerId, int custId, String monthAndYear);

}
