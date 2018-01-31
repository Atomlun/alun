package com.lun.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lun.crm.mapper.BaseDictDao;
import com.lun.crm.pojo.BaseDict;

@Service
public class BaseDictServiceImpl implements BaseDictService {

	
	@Autowired
	private BaseDictDao dao;

	@Override
	public List<BaseDict> QueryByBaseDict(String code) {
        	
		
		return dao.QueryByBaseDict(code);
	}
	
	
	
	
}
