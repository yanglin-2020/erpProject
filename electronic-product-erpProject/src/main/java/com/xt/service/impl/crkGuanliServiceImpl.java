package com.xt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.mapper.crkGuanliMapper;
import com.xt.pojo.SGather;
import com.xt.pojo.SGatherDetails;
import com.xt.service.crkGuanliService;
import com.xt.util.PageDemo;
import com.xt.util.PageUtil;
/**
 * 出入库管理的实现类
 * @author long
 *
 */
@Service
public class crkGuanliServiceImpl implements crkGuanliService {
	
	@Autowired
	crkGuanliMapper mapper;
	/**
	 * 获取所有已调度的入库单
	 */
	@Override
	public PageDemo<SGather> SelectSGather(int nowPage, int pageSize) {
		PageDemo<SGather> pd = new PageDemo<SGather>();
		// 获取已调度入库单总记录数(调用mapper的方法)
		int rowCount = mapper.getSGatherCount();
		PageUtil page = new PageUtil(pageSize, nowPage, rowCount);
		// 获取已调度入库单的分页查询(调用mapper的方法)
		List<SGather> list = mapper.SelectSGather(page);
		pd.setCode(0);
		pd.setCount(rowCount);
		pd.setMsg("");
		pd.setData(list);
		return pd;
	}
	/**
	 * 根据父级序号查询入库单详细信息
	 */
	@Override
	public List<SGatherDetails> findD_fileById(String id) {
		
		return mapper.findD_fileById(id);
	}
	/**
	 * 根据入库单序号修改登记人，登记时间
	 */
	@Override
	public int dengji(SGather sg) {
		return mapper.updateSGather(sg);
	}
	/**
	 * 根据父级ID修改入库详细表的已登记
	 */
	@Override
	public int updateStoreByParent_id(String id) {
		return mapper.updateStoreByParent_id(id);
	}
	/**
	 * //查询已登记的入库单
	 */
	@Override
	public PageDemo<SGather> selectDengji(int nowPage, int pageSize) {
		PageDemo<SGather> pd = new PageDemo<SGather>();
		// 获取已登记入库单总记录数(调用mapper的方法)
		int rowCount = mapper.getSGatherDengjiCount();
		PageUtil page = new PageUtil(pageSize, nowPage, rowCount);
		// 获取已登记入库单的分页查询(调用mapper的方法)
		List<SGather> list = mapper.SelectDengjiSGather(page);
		pd.setCode(0);
		pd.setCount(rowCount);
		pd.setMsg("");
		pd.setData(list);
		return pd;
	}
	/**
	 * 根据入库单序号修改审核人，审核时间和审核标志
	 */
	@Override
	public int shenhe(SGather s) {
		return mapper.updateSGather(s);
	}
	/**
	 * 商品入库
	 */
	@Override
	public int addKucun(SGatherDetails ss) {
		return mapper.addKucun(ss);
	}
	/**
	 * //查询所有入库单
	 */
	@Override
	public PageDemo<SGather> SelectAllSGather(int nowPage, int pageSize, SGather s) {
		PageDemo<SGather> pd = new PageDemo<SGather>();
		// 获取入库单总记录数(调用mapper的方法)
		int rowCount = mapper.getSGatherAllCount();
		PageUtil page = new PageUtil(pageSize, nowPage, rowCount);
		// 获取入库单的分页查询(调用mapper的方法)
		List<SGather> list = mapper.SelectAllSGather(page,s);
		pd.setCode(0);
		pd.setCount(rowCount);
		pd.setMsg("");
		pd.setData(list);
		return pd;
	}

}
