package com.lun.crm.mapper;

import java.util.List;

import com.lun.crm.pojo.BaseDict;



public interface BaseDictDao {
	
	public List<BaseDict> QueryByBaseDict(String code);
	
}
