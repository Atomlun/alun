package com.lun.crm.service;

import java.util.List;

import com.lun.crm.pojo.BaseDict;

public interface BaseDictService {

	
	public List<BaseDict> QueryByBaseDict(String code);
}
