package com.accenture.lkm.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.lkm.business.bean.CustomerBean;
import com.accenture.lkm.entity.CustomerEntity;

@Repository
@Transactional(value = "txManager")
public class CustomerDAOWrapper {

	@Autowired
	private CustomerDAO customerDAO;
	
	@Autowired
	private CustomerTypeDAO customerTypeDAO;
	
	@PersistenceContext
	EntityManager entityManager;

	public Integer addCustomer(CustomerBean customerBean) throws Exception {

		Integer id;
		CustomerEntity customerEntity = convertBeanToEntity(customerBean);

		try {
			
			entityManager.persist(customerEntity);
			id = customerEntity.getCustomerId();
		} catch (Exception e) {
			throw e;
		}

		return id;
	}
	
	public List<CustomerBean> getCustomerDetails(Date startDate, Date endDate) throws Exception{
		
		List<CustomerBean> customerBeans = null;
		List<CustomerEntity>  customerEntities;
		
		try {
			customerEntities = customerDAO.getCustomerDetails(startDate, endDate);
			if (customerEntities != null) {
				customerBeans = new ArrayList<CustomerBean>();
				for(CustomerEntity customerEntity: customerEntities)
				{
					CustomerBean customerBean = convertEntityToBean(customerEntity);
					customerBeans.add(customerBean);
				}
			}
			
			
		} catch (Exception e) {
			throw e;
		}
		
		
		return customerBeans;
		
	}
	
	
	
	
	

	/*
	 * @Override public Map<String, String> setCustomerType() throws Exception {
	 * LinkedHashMap<String, String> customerTypev = new LinkedHashMap<String,
	 * String>(); customerTypev.put("G", "Gold"); customerTypev.put("P",
	 * "Platinum"); customerTypev.put("S", "Silver"); return customerTypev; }
	 */

	
	// Utility Methods.......
		public static CustomerBean convertEntityToBean(CustomerEntity entity) {
			CustomerBean customerBean = new CustomerBean();
			BeanUtils.copyProperties(entity, customerBean);
			return customerBean;
		}
		public static CustomerEntity convertBeanToEntity(CustomerBean bean) {
			CustomerEntity entity = new CustomerEntity();
			BeanUtils.copyProperties(bean, entity);
			return entity;
		}
}