package com.xt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xt.pojo.MApply;
import com.xt.pojo.MDesignProcedureDetails;
import com.xt.pojo.MDesignProcedureModule;
import com.xt.pojo.MManufacture;
import com.xt.util.PageUtil;

public interface MManufactureMapper {
	// 获取生产派工单
	MManufacture selectMManufacture();
	// 拿到生产派工单的数量
	int getMManufactureCount(@Param("mm") MManufacture Mmanufacture);
	// 拿到生产派工单审核通过的数量
	int getMManufactureCountt(@Param("mm") MManufacture Mmanufacture);
	// 分页查询生产计划
	public List<MManufacture> getAllMManufactureInfo(@Param("page") PageUtil page, @Param("mm") MManufacture mm);
	// 分页查询生产派工单审核通过的信息
	public List<MManufacture> getAllMManufactureInfoo(@Param("page") PageUtil page, @Param("mm") MManufacture mm);
	// 审核生产派工单
	int updateMManufacture(MManufacture mm);
	// 获取产品生产计划
	MApply selectMapply();
	// 拿到生产计划的数量
	int getMapplyCount(@Param("m") MApply Mapply);
	// 分页查询生产计划
	public List<MApply> getAllMapplyInfo(@Param("page") PageUtil page, @Param("m") MApply m);
	
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
