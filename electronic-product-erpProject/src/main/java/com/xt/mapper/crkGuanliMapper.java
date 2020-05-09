package com.xt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xt.pojo.SGather;
import com.xt.pojo.SGatherDetails;
import com.xt.util.PageUtil;

public interface crkGuanliMapper {
	//获取已调度入库单总记录数
	int getSGatherCount();
	// 获取已调度入库单的分页查询
	List<SGather> SelectSGather(PageUtil page);
	//根据父级序号查询入库单详细信息
	List<SGatherDetails> findD_fileById(String id);
	//修改入库表
	int updateSGather(SGather sg);
	//根据父级ID修改入库详细表的已登记
	int updateStoreByParent_id(String id);
	// 获取已登记入库单总记录数
	int getSGatherDengjiCount();
	// 获取已登记入库单的分页查询
	List<SGather> SelectDengjiSGather(PageUtil page);
	//商品入库
	int addKucun(SGatherDetails ss);
	//获取入库单总记录数
	int getSGatherAllCount();
	// 获取入库单的分页查询
	List<SGather> SelectAllSGather(@Param("page")PageUtil page, @Param("s")SGather s);

}
