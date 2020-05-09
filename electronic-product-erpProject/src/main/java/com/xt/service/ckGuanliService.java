package com.xt.service;

import java.util.List;

import com.xt.pojo.SPay;
import com.xt.pojo.SPayDetails;
import com.xt.util.PageDemo;
/**
 * 出库管理接口
 * @author long
 *
 */
public interface ckGuanliService {
	//获取所有已调度的出库单
	PageDemo<SPay> SelectSPay(int nowPage, int pageSize);
	//根据父级序号查询出库单详细信息
	List<SPayDetails> findD_fileById(String id);
	//根据出库单序号修改登记人，登记时间
	int dengji(SPay sg);
	//根据父级ID修改入库详细表的已登记
	int updateStoreByParent_id(int id);
	//获取所有已登记的出库单
	PageDemo<SPay> selectDengji(int nowPage, int pageSize);
	//根据出库单序号修改审核人，审核时间和审核标志
	int shenhe(SPay s);
	//修改库存数量
	int updateKucun(SPayDetails ss);
	//获取所有出库单
	PageDemo<SPay> SelectAllSPay(int nowPage, int pageSize, SPay s);
	
}
