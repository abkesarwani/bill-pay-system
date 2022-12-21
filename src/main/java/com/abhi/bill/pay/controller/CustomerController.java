package com.abhi.bill.pay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.bill.pay.model.Customer;
import com.abhi.bill.pay.service.CustomerService;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService  CustomerService;
	
	@PostMapping 
	public ResponseEntity<String> createCustomer(@RequestBody Customer customer )   
	{  
		
		String result = CustomerService.createCustomer(customer);
		
	
	return new ResponseEntity<>(result, HttpStatus.OK);
	
	
	}  

}
