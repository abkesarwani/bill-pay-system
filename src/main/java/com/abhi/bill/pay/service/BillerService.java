package com.abhi.bill.pay.service;

import java.util.List;

import com.abhi.bill.pay.dto.Biller;
import com.abhi.bill.pay.model.AddMoney;
import com.abhi.bill.pay.model.PayBill;

public interface BillerService {

	List<Biller> getAllBiller();

	int fetchBill(int billerId, int custId);

	String payBill(PayBill payBill);

	String addMoney(AddMoney addMoney);

}
