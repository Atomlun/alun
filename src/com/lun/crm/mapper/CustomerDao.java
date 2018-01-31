package com.lun.crm.mapper;

import java.util.List;

import org.springframework.web.bind.annotation.ResponseBody;

import com.lun.crm.pojo.Customer;
import com.lun.crm.pojo.QueryVo;

public interface CustomerDao {
	
	//������
	public Integer customerCont(QueryVo vo);
	
	//�����
	public List<Customer> selectCustomer(QueryVo vo);
	
	
	//ͨ��Id��ѯ�ͻ�
	public Customer selectCustomerById(Integer id);
	
	
	//�޸Ŀͻ�
	public void update(Customer cu);
	
	//ɾ���û�
	public void deleteById(Integer id);

}
