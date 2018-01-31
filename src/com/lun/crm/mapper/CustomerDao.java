package com.lun.crm.mapper;

import java.util.List;

import org.springframework.web.bind.annotation.ResponseBody;

import com.lun.crm.pojo.Customer;
import com.lun.crm.pojo.QueryVo;

public interface CustomerDao {
	
	//总条数
	public Integer customerCont(QueryVo vo);
	
	//结果集
	public List<Customer> selectCustomer(QueryVo vo);
	
	
	//通过Id查询客户
	public Customer selectCustomerById(Integer id);
	
	
	//修改客户
	public void update(Customer cu);
	
	//删除用户
	public void deleteById(Integer id);

}
