package fastwave.service.auth.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fastwave.service.auth.common.base.BaseService;
import fastwave.service.auth.user.dao.CustomerDao;
import fastwave.service.auth.user.entity.Customer;
import fastwave.service.auth.user.service.CustomerService;

import java.util.List;
import java.util.Map;


/**
 * 客户表
 * 
 * @author fastwave.developer
 * @date
 */
@Service
public class CustomerServiceImpl extends BaseService implements CustomerService {
	@Autowired
	private CustomerDao adminCustomerCustomerDao;
	
	@Override
	public Customer get(Map<String, Object> params){
		return adminCustomerCustomerDao.get(params);
	}
	
	@Override
	public List<Customer> list(Map<String, Object> map){
		return adminCustomerCustomerDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return adminCustomerCustomerDao.count(map);
	}
	
	@Override
	public int save(Customer adminCustomerCustomer){
		return adminCustomerCustomerDao.save(adminCustomerCustomer);
	}
	
	@Override
	public int update(Customer adminCustomerCustomer){
		return adminCustomerCustomerDao.update(adminCustomerCustomer);
	}
	
	@Override
	public int remove(List<Long> ids){
		return adminCustomerCustomerDao.remove(ids);
	}
	
}
