package com.xt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.mapper.InvoiceMapper;
import com.xt.pojo.Buygoods;
import com.xt.pojo.Buygoods_detail;
import com.xt.pojo.Invoice;
import com.xt.pojo.Invoice_detail;
import com.xt.service.InvoiceService;
import com.xt.util.PageDemo;
import com.xt.util.PageUtil;
@Service
public class InvoiceServiceImpl implements InvoiceService {
	@Autowired
	InvoiceMapper mapper;
	@Override
	public PageDemo<Invoice> getAllinvoice(int nowPage, int pageSize, Invoice in) {
		PageDemo<Invoice> pd = new PageDemo<Invoice>();
		int rowCount = mapper.MdesCount(in);
		PageUtil page = new PageUtil(pageSize, nowPage, rowCount);
		List<Invoice> list = mapper.listfind(page, in);
		pd.setCode(0);
		pd.setCount(rowCount);
		pd.setMsg("");
		pd.setData(list);
		return pd;
	}

	@Override
	public int addInvoce(Invoice in) {
		// TODO Auto-generated method stub
		return mapper.addInvoce(in);
	}

	@Override
	public int updateInvoce(Invoice in) {
		// TODO Auto-generated method stub
		return mapper.updateInvoce(in);
	}

	@Override
	public PageDemo<Invoice_detail> listInvo(int nowPage, int pageSize, Invoice_detail in) {
		PageDemo<Invoice_detail> pd = new PageDemo<Invoice_detail>();
		int rowCount = mapper.InvoCount(in);
		PageUtil page = new PageUtil(pageSize, nowPage, rowCount);
		List<Invoice_detail> list = mapper.listInvo(page, in);
		pd.setCode(0);
		pd.setCount(rowCount);
		pd.setMsg("");
		pd.setData(list);
		return pd;
	}

	@Override
	public int addInDeatail(Invoice_detail in) {
		// TODO Auto-generated method stub
		return mapper.addInDeatail(in);
	}

	@Override
	public int updateDeatail(Invoice_detail in) {
		// TODO Auto-generated method stub
		return mapper.updateDeatail(in);
	}

	@Override
	public int delInDetail(String id) {
		// TODO Auto-generated method stub
		return mapper.delInDetail(id);
	}

	@Override
	public PageDemo<Buygoods> listbuy(int nowPage, int pageSize) {
		PageDemo<Buygoods> pd = new PageDemo<Buygoods>();
		int rowCount = mapper.Countbuy();
		PageUtil page = new PageUtil(pageSize, nowPage, rowCount);
		List<Buygoods> list = mapper.listbuy(page);
		pd.setCode(0);
		pd.setCount(rowCount);
		pd.setMsg("");
		pd.setData(list);
		return pd;
	}

	@Override
	public List<Buygoods_detail> buydate(String buy_id) {
		// TODO Auto-generated method stub
		return mapper.buydate(buy_id);
	}

	@Override
	public int updateBuy(Buygoods buy) {
		// TODO Auto-generated method stub
		return mapper.updateBuy(buy);
	}

}
