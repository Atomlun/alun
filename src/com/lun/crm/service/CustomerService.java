package com.lun.crm.service;

import com.lun.commons.utils.Page;
import com.lun.crm.pojo.Customer;
import com.lun.crm.pojo.QueryVo;

public interface CustomerService {
	public Page<Customer> selectPageByQueryVo(QueryVo vo);
	
	public Customer selectCustomerById(Integer id);
	
	public void update(Customer cu);
	
	public void deleteById(Integer id);
}
