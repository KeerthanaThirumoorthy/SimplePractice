package com.tekul.jsparlour.DAO;

import java.util.List;

import com.tekul.jsparlour.BO.CustomerData;

public interface JsParlourDao {
	public List<CustomerData> getListOfCustomers();
	
	public void addCustomer(CustomerData customer);
	
	public Integer getNextSequenceValue();

}
