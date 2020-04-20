package com.xt.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.mapper.MDesignProcedureMapper;
import com.xt.pojo.MDesignProcedure;
import com.xt.service.MDesignProcedureService;
import com.xt.util.PageDemo;
import com.xt.util.PageUtil;

/**
 * 产品设计业务类
 * @author asus
 *罗文涛
 */
@Service
public class MDesignProcedureServiceImpl implements MDesignProcedureService {
	@Autowired
	MDesignProcedureMapper mapper;
	
	@Override
	public PageDemo<MDesignProcedure> getAllMdesign(int nowPage, int pageSize, MDesignProcedure mdesignProcedure) {
		PageDemo<MDesignProcedure> pd = new PageDemo<MDesignProcedure>();
		int rowCount = mapper.MdesCount(mdesignProcedure);
		PageUtil page = new PageUtil(pageSize, nowPage, rowCount);
		List<MDesignProcedure> list = mapper.listfind(page, mdesignProcedure);
		pd.setCode(0);
		pd.setCount(rowCount);
		pd.setMsg("");
		pd.setData(list);
		return pd;
	}

	@Override
	public MDesignProcedure findId(String id) {
		// TODO Auto-generated method stub
		return mapper.findId(id);
	}

	@Override
	public int mdesadd(MDesignProcedure addMdes) {
		// TODO Auto-generated method stub
		return mapper.mdesadd(addMdes);
	}

	@Override
	public int mdesUpdate(MDesignProcedure updateMdes) {
		// TODO Auto-generated method stub
		return mapper.mdesUpdate(updateMdes);
	}

}
