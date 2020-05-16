package com.xt.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.mapper.ProductionRegisterMapper;
import com.xt.pojo.D_file;
import com.xt.pojo.MManufacture;
import com.xt.pojo.MProcedure;
import com.xt.pojo.SGather;
import com.xt.pojo.SGatherDetails;
import com.xt.service.ProductionRegisterService;
import com.xt.util.PageDemo;
import com.xt.util.PageUtil;

/**
 * 
 * @CQK Administrator 生产登记Serviceimpl
 *
 */
@Service
public class ProductionRegisterServiceimpl implements ProductionRegisterService{

	@Autowired
	ProductionRegisterMapper mapper;
	
	//获取生产总表已审核的数据
	@Override
	public PageDemo<MManufacture> getManufacture(int nowPage, int pageSize,MManufacture manufacture) {
		PageDemo<MManufacture> pd=new PageDemo<MManufacture>();
		int rowCount = mapper.getManufactureCount(manufacture);
		PageUtil page=new PageUtil(pageSize, nowPage, rowCount);
		List<MManufacture> list =mapper.getManufacture(page,manufacture);
		pd.setCode(0);
		pd.setCount(rowCount);
		pd.setMsg("");
		pd.setData(list);
		return pd;
	}

	//根据派工单编号查询生产总表
	@Override
	public MManufacture getManufactureByid(MManufacture manufacture) {
		MManufacture mManufacture=mapper.getManufactureByid(manufacture);
		return mManufacture;
	}

	//根据工单制定人查询生产工序表
	@Override
	public List<MProcedure> getMprocedure(MManufacture mManufacture) {
		List<MProcedure> mplist=mapper.getMprocedure(mManufacture);
		return mplist;
	}

	@Override
	public int updateGongXuStatus(String id, String procedurename) {
		return mapper.updateGongXuStatus(id, procedurename);
	}

	@Override
	public int updatesczbStatus(String id) {
		return mapper.updatesczbStatus(id);
	}

	@Override
	public int updateGongXuStatus2(String id, String procedurename) {
		return mapper.updateGongXuStatus2(id, procedurename);
	}

	@Override
	public int updatesczbStatus2(String id) {
		return mapper.updatesczbStatus2(id);
	}

	@Override
	public int updateGongXuStatus3(String id, String procedurename) {
		return mapper.updateGongXuStatus3(id, procedurename);
	}

	@Override
	public int updatesczbStatus3(String id) {
		return mapper.updatesczbStatus3(id);
	}

	@Override
	public int updateGongXuStatus4(String id, String procedurename) {
		return mapper.updateGongXuStatus4(id, procedurename);
	}

	@Override
	public int updatesczbStatus4(String id) {
		return mapper.updatesczbStatus4(id);
	}

	@Override
	public int updatesczbIswg(MManufacture mm) {
		return mapper.updatesczbIswg(mm);
	}

	@Override
	public PageDemo<MManufacture> getManufacturefuhe(int nowpage, int pageSize, MManufacture manufacture) {
		PageDemo<MManufacture> pd=new PageDemo<MManufacture>();
		int rowCount = mapper.getManufactureCountfuhe(manufacture);
		PageUtil page=new PageUtil(pageSize, nowpage, rowCount);
		List<MManufacture> list =mapper.getManufacturefuhe(page,manufacture);
		pd.setCode(0);
		pd.setCount(rowCount);
		pd.setMsg("");
		pd.setData(list);
		return pd;
	}

	@Override
	public MManufacture queryManufactureInfo(String id) {
		return mapper.queryManufactureInfo(id);
	}

	@Override
	public int insertmmRukuDan(SGather s) {
		return mapper.insertmmRukuDan(s);
	}

	@Override
	public int insertmmDetailRuKuDan(SGatherDetails sg) {
		return mapper.insertmmDetailRuKuDan(sg);
	}
}
