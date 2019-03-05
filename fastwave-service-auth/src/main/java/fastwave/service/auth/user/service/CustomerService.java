package fastwave.service.auth.user.service;


import java.util.List;
import java.util.Map;

import fastwave.service.auth.user.entity.Customer;



/**
 * 客户表
 * 
 * @author fastwave.developer
 * @date 
 */
public interface CustomerService {
	
	Customer get(Map<String, Object> params);
	
	List<Customer> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(Customer adminCustomerCustomer);
	
	int update(Customer adminCustomerCustomer);
	
	int remove(List<Long> ids);
	
}
