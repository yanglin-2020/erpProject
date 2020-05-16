package com.xt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xt.pojo.Buygoods;
import com.xt.pojo.Buygoods_detail;
import com.xt.pojo.Invoice;
import com.xt.pojo.Invoice_detail;
import com.xt.util.PageUtil;

public interface InvoiceMapper {
	
	/**
	 * 查询采购表
	 * @param page
	 * @param md
	 * @return
	 */
	public List<Buygoods> listbuy(@Param("page") PageUtil page);
	int Countbuy();
	
	/**
	 *查询发票
	 *
	 * @return
	 */
	public List<Invoice> listfind(@Param("page") PageUtil page,@Param("md") Invoice md);
	int MdesCount(Invoice md);
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
	public List<Invoice_detail> listInvo(@Param("page") PageUtil page,@Param("md") Invoice_detail md);
	int InvoCount(Invoice_detail md);
	
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
	 * 采购详情查询
	 * @param buy_id
	 * @return
	 */
	public List<Buygoods_detail> buydate(String buy_id);
	
	public int updateBuy(Buygoods buy);
}
