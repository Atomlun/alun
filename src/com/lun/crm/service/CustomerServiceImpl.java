package com.lun.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lun.commons.utils.Page;
import com.lun.crm.mapper.CustomerDao;
import com.lun.crm.pojo.Customer;
import com.lun.crm.pojo.QueryVo;

/**
 * 
 * 客户管理
 * @author LUN
 *
 */

@Service
public class CustomerServiceImpl implements CustomerService{
	
	
	@Autowired
	private CustomerDao dao;
	
	public Page<Customer> selectPageByQueryVo(QueryVo vo){
		Page<Customer> page = new Page<>();
		page.setSize(5);//在前段计算的时候需要
		vo.setSize(5);
		
		//判断当前页
		if(vo !=null){
		if(vo.getPage() !=null){
			page.setPage(vo.getPage());
			vo.setStarRow((vo.getPage()-1)*vo.getSize());
		}
		if(vo.getCustName() !=null && !"".equals(vo.getCustName().trim())){
			vo.setCustName(vo.getCustName().trim());
		}
		if(vo.getCustSource() !=null && !"".equals(vo.getCustSource().trim())){
			vo.setCustSource(vo.getCustSource().trim());
		}
		if(vo.getCustLevel() !=null && !"".equals(vo.getCustLevel().trim())){
			vo.setCustLevel(vo.getCustLevel().trim());
		}
		if(vo.getCustIndustry() !=null && !"".equals(vo.getCustIndustry().trim())){
			vo.setCustIndustry(vo.getCustIndustry().trim());
		}
		//把查询的条件vo过滤空格一下，然后最终放到page里面进行查询
		
		//当前页
		page.setPage(vo.getPage());
		//总条数要到数据库查
		page.setTotal(dao.customerCont(vo));
		//数据
		page.setRows(dao.selectCustomer(vo));
		
		
		}
		
		return page;
	}

	@Override
	public Customer selectCustomerById(Integer id) {
		// TODO Auto-generated method stub
		return dao.selectCustomerById(id);
	}

	@Override
	public void update(Customer cu) {
		
		 dao.update(cu);
	}

	@Override
	public void deleteById(Integer id) {
		dao.deleteById(id);
	}

}
