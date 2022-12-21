package com.abhi.bill.pay.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhi.bill.pay.dao.BillerDataRepository;
import com.abhi.bill.pay.dao.BillerRepository;
import com.abhi.bill.pay.dao.BillerWalletRepository;
import com.abhi.bill.pay.dao.CustomerTransactionRepository;
import com.abhi.bill.pay.dao.CustomerWalletRepository;
import com.abhi.bill.pay.dto.Biller;
import com.abhi.bill.pay.dto.BillerData;
import com.abhi.bill.pay.dto.BillerWallet;
import com.abhi.bill.pay.dto.CustomerTransaction;
import com.abhi.bill.pay.dto.CustomerWallet;
import com.abhi.bill.pay.model.AddMoney;
import com.abhi.bill.pay.model.PayBill;

import jakarta.transaction.Transactional;

@Service
public class BillerServiceImpl implements BillerService {
	@Autowired
	private BillerRepository billerRepository;

	@Autowired
	private BillerDataRepository billerDataRepository;

	@Autowired
	private CustomerWalletRepository customerWalletRepository;

	@Autowired
	private BillerWalletRepository billerWalletRepository;
	
	@Autowired
	private CustomerTransactionRepository  customerTransactionRepository;

	@Override
	public List<Biller> getAllBiller() {
	
		return billerRepository.findAll();
	}

	@Override
	public int fetchBill(int billerId, int custId) {
		String monthAndYear = getMonthAandYear();
		
		BillerData billerData = billerDataRepository.findByBillerIdAndCustIdAndMonthYear(billerId, custId,monthAndYear);

		if (billerData == null) {
			return 0;
		}

		return billerData.getAmountToPaid();
	}

	@Transactional
	@Override
	public String payBill(PayBill payBill) {

		CustomerWallet customerWallet = customerWalletRepository.findByCustId(payBill.getCustId());

		if (customerWallet.getAmount() < payBill.getAmt()) {

			return "wallet does not have sufficient amount to pay the Bill. Please add funds in the Wallet";
		}

		else {

			customerWallet.setAmount(customerWallet.getAmount() - payBill.getAmt());
			customerWallet = customerWalletRepository.save(customerWallet);
			

			Optional<BillerWallet> billerWallet = billerWalletRepository.findById(payBill.getBillerId());
			billerWallet.get().setAmount(billerWallet.get().getAmount() + payBill.getAmt());
			billerWalletRepository.save(billerWallet.get());
			
			String monthAndYear = getMonthAandYear();
			
			BillerData billerData = billerDataRepository.findByBillerIdAndCustIdAndMonthYear(payBill.getBillerId(), payBill.getCustId(),monthAndYear);
			billerData.setAmountToPaid(billerData.getAmountToPaid() - payBill.getAmt());
			billerDataRepository.save(billerData);
			
			CustomerTransaction transaction = new CustomerTransaction();
			transaction.setAmount(payBill.getAmt());
			transaction.setBillerId(payBill.getBillerId());
			transaction.setCustId(payBill.getCustId());
			transaction.setPaymentMthd("Wallet");
			transaction.setType("debit");
			customerTransactionRepository.save(transaction);
			

		}

		return "bill pay successfully. You have " + customerWallet.getAmount() +" Rs in your Account.";
	}

	@Transactional
	@Override
	public String addMoney(AddMoney addMoney) {
		
		CustomerWallet customerWallet = customerWalletRepository.findByCustId(addMoney.getCustId());
		customerWallet.setAmount(customerWallet.getAmount() + addMoney.getAmount());
		customerWallet = customerWalletRepository.save(customerWallet);
		
		CustomerTransaction transaction = new CustomerTransaction();
		transaction.setAmount(addMoney.getAmount());
		transaction.setCustId(addMoney.getCustId());
		transaction.setPaymentMthd(addMoney.getPaymentMode());
		transaction.setType("credit");
		customerTransactionRepository.save(transaction);
		
		return "Fund added successfully. Your wallet amount is "+ customerWallet.getAmount() + "Rs.";
	}
	
	private String getMonthAandYear() {
		Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		String month = localDate.getMonth().toString();
		int year = localDate.getYear();
		String monthAndYear = month + "-" + year;
		return monthAndYear;
	}

	
}
