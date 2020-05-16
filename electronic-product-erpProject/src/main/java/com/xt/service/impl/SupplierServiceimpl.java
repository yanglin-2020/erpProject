package com.xt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.mapper.SupplierMapper;
import com.xt.pojo.Supplier;
import com.xt.service.SupplierService;
import com.xt.util.PageDemo;
import com.xt.util.PageUtil;

/**
 * 
 * @崔庆康 供货商管理
 *
 */
@Service
public class SupplierServiceimpl implements SupplierService{

	@Autowired
	SupplierMapper mapper;
	
	//添加供货商
	@Override
	public int addsupplier(Supplier supplier) {
		int row=mapper.addsuplier(supplier);
		return row;
	}

	//查询未复核的供应商数据
	@Override
	public PageDemo<Supplier> querysupplier(int nowpage, int pageSize, Supplier supplier) {
		PageDemo<Supplier> pd=new PageDemo<Supplier>();
		int row=mapper.querysupplierCount(supplier);
		PageUtil page=new PageUtil(pageSize,nowpage,row);
		List<Supplier> list=mapper.querysupplier(page,supplier);
		pd.setCode(0);
		pd.setMsg("");
		pd.setCount(row);
		pd.setData(list);
		return pd;
	}

	//审核通过
	@Override
	public int auditsupplier(Supplier supplier) {
		
		return mapper.auditsupplier(supplier);
	}

	//审核不通过
	@Override
	public int noauditsupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		return mapper.noauditsupplier(supplier);
	}

	//修改删除状态
	@Override
	public int updatedelsupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		return mapper.updatedelsupplier(supplier);
	}

	//修改供货商
	@Override
	public int updatesupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		return mapper.updatesupplier(supplier);
	}

	//彻底删除数据
	@Override
	public int delSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		return mapper.delSupplier(supplier);
	}

}
