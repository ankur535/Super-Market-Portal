package com.accenture.lkm.service;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.lkm.business.bean.CustomerBean;
import com.accenture.lkm.dao.CustomerDAOWrapper;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerDAOWrapper customerDAOWrapper;

	@Override
	public Integer addCustomer(CustomerBean customerBean) throws Exception{
		
		return customerDAOWrapper.addCustomer(customerBean);
	}

	@Override
	public List<CustomerBean> getCustomerDetails(Date startDate, Date endDate) throws Exception {
		List<CustomerBean> customerBeans = customerDAOWrapper.getCustomerDetails(startDate, endDate);
		
		if (customerBeans == null) {
			throw new Exception("No Customer Details Found");
		}
		
		return customerBeans;
		
	}

	/*
	 * @Override public Map<String, String> setCustomerType() throws Exception {
	 * return customerDAOWrapper.setCustomerType(); }
	 */

	
}

