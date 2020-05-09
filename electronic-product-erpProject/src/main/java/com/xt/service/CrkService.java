package com.xt.service;

import java.util.List;

import com.xt.pojo.SGather;
import com.xt.pojo.SGatherDetails;
import com.xt.pojo.SPay;
import com.xt.pojo.SPayDetails;
import com.xt.util.PageDemo;
/**
 * 出库接口
 * @author long
 *
 */
public interface CrkService {
	/**
	 * 查询已申请的出库信息
	 * @param pageSize 
	 * @param nowPage 
	 * @return
	 */
	PageDemo<SPay> SelectAllSPay(int nowPage, int pageSize);
	/**
	 * 根据父级序号查询出库单详细信息
	 * @return
	 */
	List<SPayDetails> findD_fileById(String id);
	/**
	 * 插入出库详细表数据，添加已出库件数
	 * @param paid_amount
	 * @return
	 */
	int chukuDiaodu(String paid_amount, String id);
	/**
	 * 根据出库单序号修改已调度
	 * @param id
	 * @return
	 */
	int updateStore_tag(String id,String attemper,String attemper_time);
	/**
	 * 查询已登记的入库信息
	 * @param pageSize 
	 * @param nowPage 
	 * @return
	 */
	PageDemo<SGather> SelectAllSGather(int nowPage, int pageSize);
	/**
	 * 根据父级序号查询入库单详细信息
	 * @param id
	 * @return
	 */
	List<SGatherDetails> findD_fileBySGatherId(String id);
	/**
	 * 根据入库单序号修改已调度
	 * @param id
	 * @param attemper_time 
	 * @param attemper 
	 * @return
	 */
	int updateSGatherStore_tag(String id, String attemper, String attemper_time);
	/**
	 * 根据商品ID修改出库详细表
	 * @param gathered_amount
	 * @param spid
	 * @return
	 */
	int rukuDiaodu(String gathered_amount, String spid);

}
