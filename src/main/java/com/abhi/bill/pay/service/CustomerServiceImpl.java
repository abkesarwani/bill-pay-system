package com.abhi.bill.pay.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhi.bill.pay.dao.CustomerRepository;
import com.abhi.bill.pay.dao.CustomerWalletRepository;
import com.abhi.bill.pay.dto.CustomerDto;
import com.abhi.bill.pay.dto.CustomerWallet;
import com.abhi.bill.pay.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerWalletRepository customerWalletRepository;

	@Override
	public String createCustomer(Customer customer) {
		
		
		CustomerDto customerDto;
		if(null != customer.getEmail()) {
			
			String regex = "^[\\w!#$%&amp;'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&amp;'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(customer.getEmail());
			
			if(!matcher.matches()) {
				
				return "invaild email Id.";
			}
			
			
			customerDto = 	customerRepository.findByEmail(customer.getEmail());
			
			
		
		if(null == customerDto) {
			
			customerDto = new CustomerDto();
			customerDto.setEmail(customer.getEmail());
			customerDto = customerRepository.save(customerDto);
			
			
			
			CustomerWallet customerWallet =  new CustomerWallet();
			customerWallet.setCustId(customerDto.getId());
			customerWallet.setAmount( customer.getAmt());
			customerWalletRepository.save(customerWallet);
			
			
		}else {
			return "email Id is already exist.";
		}
			
		}
		
		return "customer created successfully.";
	}

}
