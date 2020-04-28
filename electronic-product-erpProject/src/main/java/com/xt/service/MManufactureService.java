package com.xt.service;

import com.xt.pojo.MApply;
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
}
