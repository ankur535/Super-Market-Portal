package com.accenture.lkm.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.lkm.entity.CustomerEntity;

@RepositoryDefinition(idClass = Integer.class, domainClass = CustomerEntity.class)
@Transactional(value = "txManager")
public interface CustomerDAO {	


	@Query(name = "getDetailQuery")
	List<CustomerEntity> getCustomerDetails(Date startDate, Date endDate);
	
}
