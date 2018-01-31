package com.lun.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lun.commons.utils.Page;
import com.lun.crm.pojo.BaseDict;
import com.lun.crm.pojo.Customer;
import com.lun.crm.pojo.QueryVo;
import com.lun.crm.service.BaseDictService;
import com.lun.crm.service.CustomerService;

/**
 * �ͻ�����
 * @author LUN
 *
 */

@Controller
public class CustomerController {

	@Autowired
	private BaseDictService service;
	@Autowired
	private CustomerService service1;
	
	
	@RequestMapping("/customer/list")
	public String list(QueryVo vo,Model model){
		List<BaseDict> fromType = service.QueryByBaseDict("002");
		List<BaseDict> industryType = service.QueryByBaseDict("001");
		List<BaseDict> levelType = service.QueryByBaseDict("006");
		
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);
		
		
		//ͨ��4��������ѯ��ҳ����
		//��ȡpage���������������������ҳ����Ϣ����ǰ�ε��Զ����ҳjstl���
		Page<Customer> page = service1.selectPageByQueryVo(vo);
		model.addAttribute("page", page);
		
		
		model.addAttribute("custName", vo.getCustName());
		model.addAttribute("custSource", vo.getCustSource());
		model.addAttribute("custLevel", vo.getCustLevel());
		model.addAttribute("custIndustry", vo.getCustIndustry());
		
		
		return "customer";
	}
	
	@RequestMapping("/customer/edit.action")
	public @ResponseBody Customer edit(Integer id){
		Customer cu = service1.selectCustomerById(id);
		return cu;
		
		
	}
	
	@RequestMapping("/customer/update.action")
	public @ResponseBody String update(Customer cu){//���ӳ����ǰ�Σ���from�����л���һ��pojo��ӳ���
		service1.update(cu);
		return "ok";
		
		
	}
	
	@RequestMapping("customer/delete.action")
	public @ResponseBody String deleteById(Integer id){
		
		service1.deleteById(id);
		return "ok";
	}
	
	
	
	
}
