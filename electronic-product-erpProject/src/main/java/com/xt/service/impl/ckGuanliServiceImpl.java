package com.xt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.mapper.ckGuanliMapper;
import com.xt.pojo.SPay;
import com.xt.pojo.SPayDetails;
import com.xt.service.ckGuanliService;
import com.xt.util.PageDemo;
import com.xt.util.PageUtil;
/**
 * 出库管理实现类
 * @author long
 *
 */
@Service
public class ckGuanliServiceImpl implements ckGuanliService {
	
	@Autowired
	ckGuanliMapper mapper;
	/**
	 * 获取所有已调度的出库单
	 */
	@Override
	public PageDemo<SPay> SelectSPay(int nowPage, int pageSize) {
		PageDemo<SPay> pd = new PageDemo<SPay>();
		// 获取已调度出库单总记录数(调用mapper的方法)
		int rowCount = mapper.getSPayCount();
		PageUtil page = new PageUtil(pageSize, nowPage, rowCount);
		// 获取已调度出库单的分页查询(调用mapper的方法)
		List<SPay> list = mapper.SelectSPay(page);
		pd.setCode(0);
		pd.setCount(rowCount);
		pd.setMsg("");
		pd.setData(list);
		return pd;
	}
	/**
	 * 根据父级序号查询出库单详细信息
	 */
	@Override
	public List<SPayDetails> findD_fileById(String id) {
		return mapper.findD_fileById(id);
	}
	/**
	 * 根据出库单序号修改登记人，登记时间
	 */
	@Override
	public int dengji(SPay sg) {
		return mapper.updateSpay(sg);
	}
	/**
	 * 根据父级ID修改入库详细表的已登记
	 */
	@Override
	public int updateStoreByParent_id(int id) {
		return mapper.updateStoreByParent_id(id);
	}
	/**
	 * 获取所有已登记的出库单
	 */
	@Override
	public PageDemo<SPay> selectDengji(int nowPage, int pageSize) {
		PageDemo<SPay> pd = new PageDemo<SPay>();
		// 获取已登记出库单总记录数(调用mapper的方法)
		int rowCount = mapper.getSPayDengjiCount();
		PageUtil page = new PageUtil(pageSize, nowPage, rowCount);
		// 获取已登记出库单的分页查询(调用mapper的方法)
		List<SPay> list = mapper.SelectDengjiSPay(page);
		pd.setCode(0);
		pd.setCount(rowCount);
		pd.setMsg("");
		pd.setData(list);
		return pd;
	}
	/**
	 * 根据出库单序号修改审核人，审核时间和审核标志
	 */
	@Override
	public int shenhe(SPay s) {
		return mapper.updateSpay(s);
	}
	/**
	 * 修改库存数量
	 */
	@Override
	public int updateKucun(SPayDetails ss) {
		return mapper.updateKucun(ss);
	}
	/**
	 * 获取所有出库单
	 */
	@Override
	public PageDemo<SPay> SelectAllSPay(int nowPage, int pageSize, SPay s) {
		PageDemo<SPay> pd = new PageDemo<SPay>();
		// 获取出库单总记录数(调用mapper的方法)
		int rowCount = mapper.getSPayAllCount(s);
		PageUtil page = new PageUtil(pageSize, nowPage, rowCount);
		// 获取出库单的分页查询(调用mapper的方法)
		List<SPay> list = mapper.SelectAllSPay(page,s);
		pd.setCode(0);
		pd.setCount(rowCount);
		pd.setMsg("");
		pd.setData(list);
		return pd;
	}

}
