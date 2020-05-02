package com.xt.service;

import com.xt.pojo.D_file;
import com.xt.pojo.SCell;
import com.xt.pojo.SPay;
import com.xt.pojo.SPayDetails;
import com.xt.util.PageDemo;
public interface SPayService {
	/**
	 * 分页查询出库
	 * @param nowPage
	 * @param pageSize
	 * @param s
	 * @return
	 */
	PageDemo<SPay> getAllUserInfo(int nowPage, int pageSize, SPay s	);
	/**
	 * 添加出库记录
	 * @param s
	 * @return
	 */
	int addSPay(SPay s);
	/**
	 * 修改出库
	 * @param s
	 * @return
	 */
	int updateSPay(SPay s);
	/**
	 * 添加出库明细
	 * @param s
	 * @return
	 */
	int spayDeilsadd(SPayDetails s);
	/**
	 * 分页查询出库详情
	 * @param nowPage
	 * @param pageSize
	 * @param s
	 * @return
	 */
	PageDemo<SPayDetails> spayDeilslist(int nowPage, int pageSize, SPayDetails s	);
	
	/**
	 * 修改出库明细
	 * @param s
	 * @return
	 */
	int spayDeilsUpdate(SPayDetails s);
	
	/**
	 * 分页查询库存
	 * @param nowPage
	 * @param pageSize
	 * @param s
	 * @return
	 */
	PageDemo<SCell> scelllist(int nowPage, int pageSize, SCell s	);
	
	/**
	 * 查询产品单个
	 * @return
	 */
	D_file DfileIdc(String product_id);
}
