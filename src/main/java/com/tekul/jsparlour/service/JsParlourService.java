package com.tekul.jsparlour.service;

import java.util.List;

import com.tekul.jsparlour.BO.CustomerData;

public interface JsParlourService {
	public List<CustomerData> getListOfCustomers();
	
	public void addCustomer(CustomerData customer);

}
