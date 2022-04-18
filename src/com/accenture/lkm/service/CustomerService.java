package com.accenture.lkm.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.accenture.lkm.business.bean.CustomerBean;

public interface CustomerService {	
	
	public Integer addCustomer(CustomerBean customerBean) throws Exception;
	
	public List<CustomerBean> getCustomerDetails(Date startDate, Date endDate) throws Exception;
	/*
	 * public Map<String, String> setCustomerType() throws Exception;
	 */
}