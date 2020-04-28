package com.xt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xt.pojo.MApply;
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

}
