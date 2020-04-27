package com.xt.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.mapper.SafeMapper;
import com.xt.pojo.D_file;
import com.xt.pojo.SCell;
import com.xt.service.SafeService;
import com.xt.util.PageDemo;
import com.xt.util.PageUtil;
/**
 * 安全配置实现类
 * @author long
 *
 */
@Service
public class SafeServiceImpl implements SafeService {
	
	@Autowired
	SafeMapper mapper;
	/**
	 * 产品的分页查询
	 */
	@Override
	public PageDemo<D_file> getAllUserInfo(int nowPage, int pageSize, D_file d) {
		PageDemo<D_file> pd = new PageDemo<D_file>();
		//获取产品总记录数(调用mapper的方法)
		int rowCount = mapper.getDFileCount(d);
		PageUtil page = new PageUtil(pageSize, nowPage, rowCount);
		//获取产品的分页查询(调用mapper的方法)
		List<D_file> list = mapper.getAllDFileInfo(page, d);
		pd.setCode(0);
		pd.setCount(rowCount);
		pd.setMsg("");
		pd.setData(list);
		return pd;
	}
	/**
	 * 添加安全配置单
	 */
	@Override
	public int addSaveSCell(SCell cell) {
		return mapper.addSaveSCell(cell);
	}
	/**
	 * 查询未复核的安全配置单
	 */
	@Override
	public PageDemo<SCell> getNoFuheInfo(int nowPage, int pageSize, SCell s) {
		PageDemo<SCell> pd = new PageDemo<SCell>();
		//获取未复核的产品总记录数(调用mapper的方法)
		int rowCount = mapper.getNofuheDFileCount(s);
		PageUtil page = new PageUtil(pageSize, nowPage, rowCount);
		//获取未复核的产品的分页查询(调用mapper的方法)
		List<SCell> list = mapper.getNofuheDFileInfo(page, s);
		pd.setCode(0);
		pd.setCount(rowCount);
		pd.setMsg("");
		pd.setData(list);
		return pd;
	}
	@Override
	public SCell getScellByid(String id) {
		return mapper.getScellByid(id);
	}
	@Override
	public int fuheSCell(SCell s, String check_tag) {
		return mapper.fuheSCell(s,check_tag);
	}
	@Override
	public PageDemo<SCell> getS_cellInfo(int nowPage, int pageSize, SCell s) {
		PageDemo<SCell> pd = new PageDemo<SCell>();
		//获取库存总记录数(调用mapper的方法)
		int rowCount = mapper.getS_cellCount();
		PageUtil page = new PageUtil(pageSize, nowPage, rowCount);
		//获取库存信息的分页查询(调用mapper的方法)
		List<SCell> list = mapper.getS_cellInfo(page, s);
		pd.setCode(0);
		pd.setCount(rowCount);
		pd.setMsg("");
		pd.setData(list);
		return pd;
	}
	@Override
	public int updateSCell(SCell sc) {
		return mapper.updateSCell(sc);
	}
	@Override
	public int updateD_filedesign_cell_tag(String product_id) {
		return mapper.updateD_filedesign_cell_tag(product_id);
	}

}
