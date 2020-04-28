package com.xt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.mapper.MProcedureMapper;
import com.xt.pojo.MApply;
import com.xt.pojo.MProcedure;
import com.xt.service.MProcedureService;
import com.xt.util.PageDemo;
import com.xt.util.PageUtil;
@Service
public class MProcedureServiceImpl implements MProcedureService {
	@Autowired
	MProcedureMapper mapper;
	@Override
	public PageDemo<MProcedure> getAllMapp(int nowPage, int pageSize, MProcedure ma) {
		PageDemo<MProcedure> pd = new PageDemo<MProcedure>();
		int rowCount = mapper.MappCount(ma);
		PageUtil page = new PageUtil(pageSize, nowPage, rowCount);
		List<MProcedure> list = mapper.listfind(page, ma);
		pd.setCode(0);
		pd.setCount(rowCount);
		pd.setMsg("");
		pd.setData(list);
		return pd;
	}
	@Override
	public MProcedure findId(String id) {
		// TODO Auto-generated method stub
		return mapper.findId(id);
	}
	@Override
	public int mappadd(MProcedure ma) {
		// TODO Auto-generated method stub
		return mapper.mappadd(ma);
	}
	@Override
	public int mappUpdate(MProcedure ma) {
		// TODO Auto-generated method stub
		return mapper.mappUpdate(ma);
	}
}
