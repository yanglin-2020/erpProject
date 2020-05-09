package com.xt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.mapper.CrkMapper;
import com.xt.pojo.SGather;
import com.xt.pojo.SGatherDetails;
import com.xt.pojo.SPay;
import com.xt.pojo.SPayDetails;
import com.xt.service.CrkService;
import com.xt.util.PageDemo;
import com.xt.util.PageUtil;

/**
 * 出入库实现类
 * 
 * @author long
 *
 */
@Service
public class CrkServiceImpl implements CrkService {

	@Autowired
	CrkMapper mapper;

	/**
	 * 查询已申请的出库信息
	 */
	@Override
	public PageDemo<SPay> SelectAllSPay(int nowPage, int pageSize) {
		PageDemo<SPay> pd = new PageDemo<SPay>();
		// 获取出库单总记录数(调用mapper的方法)
		int rowCount = mapper.getSPayCount();
		PageUtil page = new PageUtil(pageSize, nowPage, rowCount);
		// 获取出库单的分页查询(调用mapper的方法)
		List<SPay> list = mapper.SelectAllSPay(page);
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
	 * 插入出库详细表数据，添加已出库件数
	 */
	@Override
	public int chukuDiaodu(String paid_amount, String id) {
		// 插入出库详细表数据，添加已出库件数
		int result = mapper.chukuDiaodu(paid_amount, id);
		return result;
	}

	/**
	 * 根据出库单序号修改已调度
	 */
	@Override
	public int updateStore_tag(String id,String attemper,String attemper_time) {
		return mapper.updateStore_tag(id,attemper,attemper_time);
	}

	/**
	 * 查询已登记的入库信息
	 */
	@Override
	public PageDemo<SGather> SelectAllSGather(int nowPage, int pageSize) {
		PageDemo<SGather> pd = new PageDemo<SGather>();
		// 获取入库单总记录数(调用mapper的方法)
		int rowCount = mapper.getSGatherCount();
		PageUtil page = new PageUtil(pageSize, nowPage, rowCount);
		// 获取入库单的分页查询(调用mapper的方法)
		List<SGather> list = mapper.SelectAllSGather(page);
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
	public List<SGatherDetails> findD_fileBySGatherId(String id) {
		return mapper.findD_fileBySGatherId(id);
	}
	/**
	 * 根据入库单序号修改已调度
	 */
	@Override
	public int updateSGatherStore_tag(String id, String attemper, String attemper_time) {
		return mapper.updateSGatherStore_tag(id,attemper,attemper_time);
	}
	/**
	 * 根据商品ID修改出库详细表
	 */
	@Override
	public int rukuDiaodu(String gathered_amount, String id) {
		// 插入入库详细表数据，添加已出库件数
		int result = mapper.rukuDiaodu(gathered_amount, id);
		// 向库存表修改商品入库数量
		return result;
	}

}
