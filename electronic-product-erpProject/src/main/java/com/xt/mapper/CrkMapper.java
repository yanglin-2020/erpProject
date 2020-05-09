package com.xt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xt.pojo.SGather;
import com.xt.pojo.SGatherDetails;
import com.xt.pojo.SPay;
import com.xt.pojo.SPayDetails;
import com.xt.util.PageUtil;
/**
 * 出入库mapper层
 * @author long
 *
 */
public interface CrkMapper {
	/**
	 * 查询已申请的出库单信息
	 * @return
	 */
	List<SPay> SelectAllSPay(PageUtil page);
	/**
	 * 根据父级序号查询出库单详细信息
	 * @param id
	 * @return
	 */
	List<SPayDetails> findD_fileById(String id);
	/**
	 * 获取出库单总记录数
	 * @return
	 */
	int getSPayCount();
	/**
	 * 插入出库详细表数据，添加已出库件数
	 * @param paid_amount
	 * @return
	 */
	int chukuDiaodu(@Param("paid_amount")String paid_amount, @Param("id")String id);
	/**
	 * 根据出库单序号修改已调度
	 * @param id
	 * @return
	 */
	int updateStore_tag(@Param("id")String id, @Param("attemper")String attemper, @Param("attemper_time")String attemper_time);
	/**
	 * 获取入库单总记录数
	 * @return
	 */
	int getSGatherCount();
	/**
	 * 获取入库单的分页查询
	 * @param page
	 * @return
	 */
	List<SGather> SelectAllSGather(PageUtil page);
	/**
	 * 根据父级序号查询入库单详细信息
	 * @param id
	 * @return
	 */
	List<SGatherDetails> findD_fileBySGatherId(String id);
	/**
	 * 根据入库单序号修改已调度
	 * @param id
	 * @return
	 */
	int updateSGatherStore_tag(@Param("id")String id, @Param("attemper")String attemper, @Param("attemper_time")String attemper_time);
	/**
	 * 插入入库详细表数据，添加已出库件数
	 * @param gathered_amount
	 * @param id
	 * @return
	 */
	int rukuDiaodu(@Param("gathered_amount")String gathered_amount, @Param("id")String id);
	
}
