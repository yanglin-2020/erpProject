package com.xt.service;

import java.util.List;

import com.xt.pojo.MApply;
import com.xt.pojo.MDesignProcedureDetails;
import com.xt.pojo.MDesignProcedureModule;
import com.xt.pojo.MManufacture;
import com.xt.util.PageDemo;

public interface MManufactureService {
	// 获取派工单
	MManufacture selectMManufacture();
	// 分页查询所有派工单信息
	public PageDemo<MManufacture> getAllMManufacture(int nowPage, int pageSize, MManufacture mm);
	// 分页查询所有派工单审核通过的信息
	public PageDemo<MManufacture> getAllMManufacturee(int nowPage, int pageSize, MManufacture mm);
	// 审核生产派工单
	int updateMManufacture(MManufacture mm);
	// 获取产品生产计划
	MApply selectMapply();
	// 分页查询所有生产计划信息
	public PageDemo<MApply> getAllMapplyInfo(int nowPage, int pageSize, MApply m);
	
	//以下yl写的
	//根据产品的单号拿到产品所需的工序
	public List<MDesignProcedureDetails> getProcedureByProduct_id(String product_id);
	//根据id拿到每道工序需要的物料
	List<MDesignProcedureModule> getMaterialByID(String id);
	//拿到产品所需工序的总成本
	String getProcedureSumMoney(String product_id);
	//拿到产品所需物料的总成本
	String getMarterialSumMoney(String id);
	//保存生产派工单单
	int saveScpgd(MManufacture mm);
	//保存完后，修改mapply的字段
	int updateMapply_manufacture_tag(String product_id);
	//根据生产派工单编号拿到详细信息做复核
	MManufacture getMManufactureDetailInfo(String id);
}
