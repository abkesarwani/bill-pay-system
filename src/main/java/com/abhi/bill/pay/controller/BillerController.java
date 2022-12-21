package com.abhi.bill.pay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.bill.pay.dto.Biller;
import com.abhi.bill.pay.model.AddMoney;
import com.abhi.bill.pay.model.PayBill;
import com.abhi.bill.pay.service.BillerService;

@RestController
@RequestMapping("api/v1/biller")
public class BillerController {
	
	@Autowired
	private BillerService billerService; 
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Biller>> getAllBiller(){
		
		List<Biller> billers = billerService.getAllBiller();
		
			
		return new ResponseEntity<>(billers, HttpStatus.OK);
		
	}
	
	@GetMapping("/fetchBill/{billerId}/{custId}")
	public ResponseEntity<Integer>fetchBill( @PathVariable int billerId , @PathVariable int custId ){
		
		int bill = billerService.fetchBill(billerId,custId);
		
		return new ResponseEntity<>(bill, HttpStatus.OK);
	}
	
	@PostMapping("/payBill")
	public ResponseEntity<String>payBill( @RequestBody PayBill payBill ){
		
		String result = billerService.payBill(payBill);
		
		
		return new ResponseEntity<>(result, HttpStatus.OK);
		
	}
	
	
	@PostMapping("/addMoney")
	public ResponseEntity<String>addMoney( @RequestBody AddMoney addMoney  ){
		
		String result = billerService.addMoney(addMoney);
		
		
		return new ResponseEntity<>(result, HttpStatus.OK);
		
	}
	
	
	
	
	

}
