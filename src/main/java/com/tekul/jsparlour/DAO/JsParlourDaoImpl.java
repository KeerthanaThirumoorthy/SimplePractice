package com.tekul.jsparlour.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tekul.jsparlour.BO.CustomerData;
import com.tekul.jsparlour.BO.QueryConstants;

@Repository
public class JsParlourDaoImpl implements JsParlourDao {
	
	@Autowired
	public NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<CustomerData> getListOfCustomers() {
		List<CustomerData> customersList = jdbcTemplate.query(QueryConstants.getAllQuery, 
				new BeanPropertyRowMapper<CustomerData>(CustomerData.class));
		return customersList;
	}

	@Override
	public void addCustomer(CustomerData customer) {
		/*
		CustomerData newCustomer = new CustomerData();
		newCustomer.setAddress(customer.getAddress());
		newCustomer.setCustomerId(customer.getCustomerId());
		newCustomer.setFirstName(customer.getFirstName());
		newCustomer.setLastName(customer.getLastName());
		newCustomer.setPhoneNumber(customer.getPhoneNumber());
		*/
		Map<String,String> paramMap= new HashMap<String,String>();
		//customerId, :firstName, :lastName, :phoneNumber, :address
		paramMap.put("customerId", customer.getCustomerId());
		paramMap.put("firstName", customer.getFirstName());
		paramMap.put("lastName", customer.getLastName());
		paramMap.put("phoneNumber", customer.getPhoneNumber());
		paramMap.put("address", customer.getAddress());
		jdbcTemplate.update(QueryConstants.addQuery, paramMap);
		
	}

	@Override
	public Integer getNextSequenceValue() {
		String sql = QueryConstants.getNextSeq;
		Long seq = jdbcTemplate.queryForObject(sql, new MapSqlParameterSource(), Long.class);
		return seq.intValue();
	}

}
