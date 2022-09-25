package com.tekul.jsparlour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekul.jsparlour.BO.CustomerData;
import com.tekul.jsparlour.DAO.JsParlourDao;

@Service
public class JsParlourSeviceImpl implements JsParlourService{

	@Autowired
	public JsParlourDao jsParlourDao;
	
	public JsParlourSeviceImpl(JsParlourDao jsParlourDao) {
		this.jsParlourDao=jsParlourDao;
	}
	
	@Override
	public List<CustomerData> getListOfCustomers() {
		List<CustomerData> customerList = jsParlourDao.getListOfCustomers();
		return customerList;
	}

	@Override
	public void addCustomer(CustomerData customer) {
		Integer customerID = jsParlourDao.getNextSequenceValue()+1;
		customer.setCustomerId(customerID.toString());
		jsParlourDao.addCustomer(customer);
	}

}
