package com.tekul.jsparlour.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tekul.jsparlour.BO.CustomerData;
import com.tekul.jsparlour.service.JsParlourService;

@RestController
@RequestMapping("jsParlour")
public class JsParlourController {
	
	@Autowired
	JsParlourService jsParlourService;
	
	public JsParlourController(JsParlourService jsParlourService) {
		this.jsParlourService= jsParlourService;
	}
	
	@GetMapping("/getAllCustomers")
	public List<CustomerData> getAllCustomers(){
		List<CustomerData> customersList = jsParlourService.getListOfCustomers();
		return customersList;
	}
	
	@PostMapping("/addNewCustomer")
	public ResponseEntity<String> addCustomer(@RequestBody CustomerData customer) {
		try {
		CustomerData newCustomer = new CustomerData();
		newCustomer.setAddress(customer.getAddress());
		//newCustomer.setCustomerId(customer.getCustomerId());
		newCustomer.setFirstName(customer.getFirstName());
		newCustomer.setLastName(customer.getLastName());
		newCustomer.setPhoneNumber(customer.getPhoneNumber());
		
		jsParlourService.addCustomer(newCustomer);
		
		return new ResponseEntity<String>("Customer added successfully", HttpStatus.CREATED);
		}
		catch (Exception e) {
			return new ResponseEntity<String>("Customer not added", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	

}
