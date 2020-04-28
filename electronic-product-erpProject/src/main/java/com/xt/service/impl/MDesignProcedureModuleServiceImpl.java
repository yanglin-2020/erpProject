package com.xt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.mapper.MDesignProcedureModuleMapper;
import com.xt.pojo.DModuleDetails;
import com.xt.pojo.MDesignProcedure;
import com.xt.pojo.MDesignProcedureModule;
import com.xt.service.MDesignProcedureModuleService;
import com.xt.util.PageDemo;
import com.xt.util.PageUtil;
@Service
public class MDesignProcedureModuleServiceImpl implements MDesignProcedureModuleService {
	@Autowired
	MDesignProcedureModuleMapper mapper;
	@Override 
	public PageDemo<MDesignProcedureModule> getAllMdesign(int nowPage, int pageSize, MDesignProcedureModule mdesignProcedure) {
		PageDemo<MDesignProcedureModule> pd = new PageDemo<MDesignProcedureModule>();
		int rowCount = mapper.mdesignCount(mdesignProcedure);
		PageUtil page = new PageUtil(pageSize, nowPage, rowCount);
		List<MDesignProcedureModule> list = mapper.mdesignAll(page, mdesignProcedure);
		pd.setCode(0);
		pd.setCount(rowCount);
		pd.setMsg("");
		pd.setData(list);
		return pd;
	}

	@Override
	public int mdesignadd(MDesignProcedureModule md) {
		// TODO Auto-generated method stub
		return mapper.mdesignadd(md);
	}

	@Override
	public int mdesignUpdate(MDesignProcedureModule md) {
		// TODO Auto-generated method stub
		return mapper.mdesignUpdate(md);
	}

}
