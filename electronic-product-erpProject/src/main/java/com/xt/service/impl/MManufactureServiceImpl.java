package com.xt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.mapper.MManufactureMapper;
import com.xt.pojo.MApply;
import com.xt.pojo.MDesignProcedureDetails;
import com.xt.pojo.MDesignProcedureModule;
import com.xt.pojo.MManufacture;
import com.xt.service.MManufactureService;
import com.xt.util.PageDemo;
import com.xt.util.PageUtil;

@Service
public class MManufactureServiceImpl implements MManufactureService {
	@Autowired
	MManufactureMapper mapper;

	@Override
	public MManufacture selectMManufacture() {
		return mapper.selectMManufacture();
	}

	@Override
	public PageDemo<MManufacture> getAllMManufacture(int nowPage, int pageSize, MManufacture mm) {
		PageDemo<MManufacture> pd = new PageDemo<MManufacture>();
		// 获取派工单总记录数(调用mapper方法)
		int rowCount = mapper.getMManufactureCount(mm);
		PageUtil page = new PageUtil(pageSize, nowPage, rowCount);
		// 获取用户的分页查询(调用mapper的方法)
		List<MManufacture> list = mapper.getAllMManufactureInfo(page, mm);
		pd.setCode(0);
		pd.setCount(rowCount);
		pd.setMsg("");
		pd.setData(list);
		return pd;
	}

	@Override
	public int updateMManufacture(MManufacture mm) {
		return mapper.updateMManufacture(mm);
	}

	@Override
	public PageDemo<MManufacture> getAllMManufacturee(int nowPage, int pageSize, MManufacture mm) {
		PageDemo<MManufacture> pd = new PageDemo<MManufacture>();
		// 获取派工单总记录数(调用mapper方法)
		int rowCount = mapper.getMManufactureCountt(mm);
		PageUtil page = new PageUtil(pageSize, nowPage, rowCount);
		// 获取用户的分页查询(调用mapper的方法)
		List<MManufacture> list = mapper.getAllMManufactureInfoo(page, mm);
		pd.setCode(0);
		pd.setCount(rowCount);
		pd.setMsg("");
		pd.setData(list);
		return pd;
	}

	@Override
	public MApply selectMapply() {
		return mapper.selectMapply();
	}

	@Override
	public PageDemo<MApply> getAllMapplyInfo(int nowPage, int pageSize, MApply m) {
		PageDemo<MApply> pd = new PageDemo<MApply>();
		// 获取生产计划总记录数(调用mapper的方法)
		int rowCount = mapper.getMapplyCount(m);
		PageUtil page = new PageUtil(pageSize, nowPage, rowCount);
		// 获取用户的分页查询(调用mapper的方法)
		List<MApply> list = mapper.getAllMapplyInfo(page, m);
		pd.setCode(0);
		pd.setCount(rowCount);
		pd.setMsg("");
		pd.setData(list);
		return pd;
	}

	@Override
	public List<MDesignProcedureDetails> getProcedureByProduct_id(String product_id) {
		return mapper.getProcedureByProduct_id(product_id);
	}

	@Override
	public List<MDesignProcedureModule> getMaterialByID(String id) {
		return mapper.getMaterialByID(id);
	}

	@Override
	public String getProcedureSumMoney(String product_id) {
		return mapper.getProcedureSumMoney(product_id);
	}

	@Override
	public String getMarterialSumMoney(String id) {
		return mapper.getMarterialSumMoney(id);
	}

	@Override
	public int saveScpgd(MManufacture mm) {
		return mapper.saveScpgd(mm);
	}

	@Override
	public int updateMapply_manufacture_tag(String product_id) {
		return mapper.updateMapply_manufacture_tag(product_id);
	}

	@Override
	public MManufacture getMManufactureDetailInfo(String id) {
		return mapper.getMManufactureDetailInfo(id);
	}

}
