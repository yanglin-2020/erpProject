package com.xt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xt.pojo.Supplier;
import com.xt.util.PageUtil;

/**
 * 
 * @崔庆康 供货商管理
 *
 */
public interface SupplierMapper {

	//添加供货商
	int addsuplier(@Param("supplier") Supplier supplier);

	//查询未复核的供应商数据
	List<Supplier> querysupplier(@Param("page") PageUtil page,@Param("supplier") Supplier supplier);

	//查询未复核的供应商数据数量
	int querysupplierCount(@Param("supplier") Supplier supplier);

	//审核通过
	int auditsupplier(@Param("supplier") Supplier supplier);

	//审核不通过
	int noauditsupplier(@Param("supplier") Supplier supplier);

	//修改删除状态
	int updatedelsupplier(@Param("supplier") Supplier supplier);

	//修改供货商
	int updatesupplier(@Param("supplier") Supplier supplier);

	//彻底删除数据
	int delSupplier(@Param("supplier") Supplier supplier);

}
