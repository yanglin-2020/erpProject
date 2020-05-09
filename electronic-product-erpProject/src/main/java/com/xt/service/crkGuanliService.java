package com.xt.service;

import java.util.List;

import com.xt.pojo.SGather;
import com.xt.pojo.SGatherDetails;
import com.xt.util.PageDemo;
/**
 * 入库管理接口
 * @author long
 *
 */
public interface crkGuanliService {
	//获取所有已调度的入库单
	PageDemo<SGather> SelectSGather(int nowPage, int pageSize);
	//根据父级序号查询入库单详细信息
	List<SGatherDetails> findD_fileById(String id);
	//根据入库单序号修改登记人，登记时间
	int dengji(SGather sg);
	//根据父级ID修改入库详细表的已登记
	int updateStoreByParent_id(String id);
	//查询已登记的入库单
	PageDemo<SGather> selectDengji(int nowPage, int pageSize);
	//根据入库单序号修改审核人，审核时间和审核标志
	int shenhe(SGather s);
	//商品入库
	int addKucun(SGatherDetails ss);
	//查询所有入库单
	PageDemo<SGather> SelectAllSGather(int nowPage, int pageSize, SGather s);

}
