package com.xt.service;

import java.util.List;

import com.xt.pojo.Buygoods;
import com.xt.pojo.Buygoods_detail;
import com.xt.pojo.Invoice;
import com.xt.pojo.Invoice_detail;
import com.xt.util.PageDemo;

public interface InvoiceService {
	/**
	 * 查询采购表
	 * @param nowPage
	 * @param pageSize
	 * @param in
	 * @return
	 */
	PageDemo<Buygoods> listbuy(int nowPage, int pageSize);
	
	/**
	 *查询发票
	 *
	 * @return
	 */
	PageDemo<Invoice> getAllinvoice(int nowPage, int pageSize,Invoice in);
	
	/**
	 * 添加发票记录
	 * @param in
	 * @return
	 */
	int addInvoce(Invoice in);
	/**
	 * 修改发票记录
	 * @param in
	 * @return
	 */
	int updateInvoce(Invoice in);
	
	/**
	 *查询发票详情
	 *
	 * @return
	 */
	PageDemo<Invoice_detail> listInvo(int nowPage, int pageSize,Invoice_detail in);
	
	/**
	 * 添加发票详情
	 * @param in
	 * @return
	 */
	int addInDeatail(Invoice_detail in);
	
	/**
	 * 修改发票详情
	 * @param in
	 * @return
	 */
	int updateDeatail(Invoice_detail in);
	/**
	 * 删除商品详情
	 * @param id
	 * @return
	 */
	int delInDetail(String id);
	/**
	 * 查询采购详情
	 * @param buy_id
	 * @return
	 */
	List<Buygoods_detail> buydate(String buy_id);
	
	int updateBuy(Buygoods buy);
}
