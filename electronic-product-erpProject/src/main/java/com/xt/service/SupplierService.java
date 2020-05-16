package com.xt.service;

import com.xt.pojo.Supplier;
import com.xt.util.PageDemo;

/**
 * 
 * @崔庆康 供货商管理
 *
 */
public interface SupplierService {

	int addsupplier(Supplier supplier);

	//查询未复核的供应商数据
	PageDemo<Supplier> querysupplier(int nowpage, int pageSize, Supplier supplier);

	//审核通过
	int auditsupplier(Supplier supplier);

	int noauditsupplier(Supplier supplier);

	int updatedelsupplier(Supplier supplier);

	int updatesupplier(Supplier supplier);

	//彻底删除数据
	int delSupplier(Supplier supplier);

}
