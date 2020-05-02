package com.xt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xt.pojo.D_file;
import com.xt.pojo.SCell;
import com.xt.pojo.SPay;
import com.xt.pojo.SPayDetails;
import com.xt.util.PageUtil;

/**
 * 出库
 * @author 罗文涛
 *
 */
public interface SPayMapper {
	/**
	 * 分页查询出库
	 * @param page
	 * @param s
	 * @return
	 */
	List<SPay> spaylist(@Param("page") PageUtil page,@Param("s") SPay s); 
	int countSPay(@Param("s")SPay s);
	/**
	 * 添加出库单
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
	 * 出库明细
	 * @param page
	 * @param s
	 * @return
	 */
	List<SPayDetails> spayDeilslist(@Param("page") PageUtil page,@Param("s") SPayDetails s); 
	int countSPayDeils(@Param("s")SPayDetails s);
	/**
	 * 添加出库明细
	 * @param s
	 * @return
	 */
	int spayDeilsadd(SPayDetails s);
	/**
	 * 修改出库明细
	 * @param s
	 * @return
	 */
	int spayDeilsUpdate(SPayDetails s);
	
	/**
	 * 库存查询
	 * @param page
	 * @param s
	 * @return
	 */
	List<SCell> scelllist(@Param("page") PageUtil page,@Param("s") SCell s);
	int countscell(SCell s);
	/**
	 * 查询产品单个
	 * @return
	 */
	D_file DfileIdc(String product_id);
}
