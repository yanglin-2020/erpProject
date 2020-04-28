package com.xt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.mapper.MDesignProcedureDetailsMapper;
import com.xt.pojo.DModuleDetails;
import com.xt.pojo.MDesignProcedure;
import com.xt.pojo.MDesignProcedureDetails;
import com.xt.service.MDesignProcedureDetailsService;
import com.xt.util.PageDemo;
import com.xt.util.PageUtil;

/**
 * 产品设计详情业务类
 * @author 罗文涛
 */
@Service
public class MDesignProcedureDetailsServiceImpl implements MDesignProcedureDetailsService {
	@Autowired
	MDesignProcedureDetailsMapper mapper;
	@Override
	public List<MDesignProcedureDetails> findList(String parent_Id) {
		// TODO Auto-generated method stub
		return mapper.findList(parent_Id);
	}

	@Override
	public int updatemdesignDetails(MDesignProcedureDetails md) {
		// TODO Auto-generated method stub
		return mapper.updatemdesignDetails(md);
	}

	@Override
	public int addmdesignDetails(MDesignProcedureDetails md) {
		// TODO Auto-generated method stub
		return mapper.addmdesignDetails(md);
	}

	@Override
	public PageDemo<MDesignProcedureDetails> getAllMdesign(int nowPage, int pageSize,
			MDesignProcedureDetails mdesignProcedure) {
		PageDemo<MDesignProcedureDetails> pd = new PageDemo<MDesignProcedureDetails>();
		int rowCount = mapper.MdesCount(mdesignProcedure);
		PageUtil page = new PageUtil(pageSize, nowPage, rowCount);
		List<MDesignProcedureDetails> list = mapper.listfind(page, mdesignProcedure);
		pd.setCode(0);
		pd.setCount(rowCount);
		pd.setMsg("");
		pd.setData(list);
		return pd;
	}

	@Override
	public PageDemo<DModuleDetails> getAllDModuleDetails(int nowPage, int pageSize, DModuleDetails mdesignProcedure) {
		PageDemo<DModuleDetails> pd = new PageDemo<DModuleDetails>();
		int rowCount = mapper.MaterialCount(mdesignProcedure);
		PageUtil page = new PageUtil(pageSize, nowPage, rowCount);
		List<DModuleDetails> list = mapper.queryMaterial(page, mdesignProcedure);
		pd.setCode(0);
		pd.setCount(rowCount);
		pd.setMsg("");
		pd.setData(list);
		return pd;
	}

	@Override
	public int upd_moule(DModuleDetails dd) {
		// TODO Auto-generated method stub
		return mapper.upd_moule(dd);
	}

}
