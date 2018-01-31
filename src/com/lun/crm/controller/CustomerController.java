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
 * 客户管理
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
		
		
		//通过4个条件查询分页对象
		//获取page对象，这个对象包含数据与分页的信息，与前段的自定义分页jstl结合
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
	public @ResponseBody String update(Customer cu){//这个映射是前段，用from的序列化成一个pojo来映射的
		service1.update(cu);
		return "ok";
		
		
	}
	
	@RequestMapping("customer/delete.action")
	public @ResponseBody String deleteById(Integer id){
		
		service1.deleteById(id);
		return "ok";
	}
	
	
	
	
}
