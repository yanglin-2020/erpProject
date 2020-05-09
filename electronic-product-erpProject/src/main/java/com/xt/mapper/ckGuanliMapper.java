package com.xt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xt.pojo.SPay;
import com.xt.pojo.SPayDetails;
import com.xt.util.PageUtil;
/**
 * 出库管理mapper层
 * @author long
 *
 */
public interface ckGuanliMapper {
	// 获取已调度出库单总记录数
	int getSPayCount();
	// 获取已调度出库单的分页查询
	List<SPay> SelectSPay(PageUtil page);
	//根据父级序号查询出库单详细信息
	List<SPayDetails> findD_fileById(String id);
	//根据出库单序号修改登记人，登记时间
	int updateSpay(SPay sg);
	//根据父级ID修改入库详细表的已登记
	int updateStoreByParent_id(int id);
	// 获取已登记出库单总记录数
	int getSPayDengjiCount();
	// 获取已登记出库单的分页查询
	List<SPay> SelectDengjiSPay(PageUtil page);
	//修改库存数量,商品出库
	int updateKucun(SPayDetails ss);
	// 获取出库单总记录数
	int getSPayAllCount(@Param("s")SPay s);
	// 获取出库单的分页查询
	List<SPay> SelectAllSPay(@Param("page")PageUtil page, @Param("s")SPay s);
	
	
}
