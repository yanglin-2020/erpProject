package com.xt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.mapper.SPayMapper;
import com.xt.pojo.D_file;
import com.xt.pojo.SCell;
import com.xt.pojo.SPay;
import com.xt.pojo.SPayDetails;
import com.xt.service.SPayService;
import com.xt.util.PageDemo;
import com.xt.util.PageUtil;
/**
 * 出库实现类
 * @author 罗文涛
 *
 */
@Service
public class SPayServiceImpl implements SPayService {
	@Autowired
	SPayMapper mapper;
	@Override
	public PageDemo<SPay> getAllUserInfo(int nowPage, int pageSize, SPay s) {
		PageDemo<SPay> pd = new PageDemo<SPay>();
		int rowCount = mapper.countSPay(s);
		PageUtil page = new PageUtil(pageSize, nowPage, rowCount);
		List<SPay> list = mapper.spaylist(page, s);
		pd.setCode(0);
		pd.setCount(rowCount);
		pd.setMsg("");
		pd.setData(list);
		return pd;
	}

	@Override
	public int addSPay(SPay s) {
		// TODO Auto-generated method stub
		return mapper.addSPay(s);
	}

	@Override
	public int updateSPay(SPay s) {
		// TODO Auto-generated method stub
		return mapper.updateSPay(s);
	}

	@Override
	public int spayDeilsadd(SPayDetails s) {
		// TODO Auto-generated method stub
		return mapper.spayDeilsadd(s);
	}

	@Override
	public PageDemo<SPayDetails> spayDeilslist(int nowPage, int pageSize, SPayDetails s) {
		PageDemo<SPayDetails> pd = new PageDemo<SPayDetails>();
		int rowCount = mapper.countSPayDeils(s);
		PageUtil page = new PageUtil(pageSize, nowPage, rowCount);
		List<SPayDetails> list = mapper.spayDeilslist(page, s);
		pd.setCode(0);
		pd.setCount(rowCount);
		pd.setMsg("");
		pd.setData(list);
		return pd;
	}

	@Override
	public int spayDeilsUpdate(SPayDetails s) {
		// TODO Auto-generated method stub
		return mapper.spayDeilsUpdate(s);
	}

	@Override
	public PageDemo<SCell> scelllist(int nowPage, int pageSize, SCell s) {
		PageDemo<SCell> pd = new PageDemo<SCell>();
		int rowCount = mapper.countscell(s);
		PageUtil page = new PageUtil(pageSize, nowPage, rowCount);
		List<SCell> list = mapper.scelllist(page, s);
		pd.setCode(0);
		pd.setCount(rowCount);
		pd.setMsg("");
		pd.setData(list);
		return pd;
	}

	@Override
	public D_file DfileIdc(String product_id) {
		// TODO Auto-generated method stub
		return mapper.DfileIdc(product_id);
	}

}
