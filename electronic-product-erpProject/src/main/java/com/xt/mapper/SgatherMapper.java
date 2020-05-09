package com.xt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xt.pojo.D_file;
import com.xt.pojo.MManufacture;
import com.xt.pojo.SGather;
import com.xt.pojo.SGatherDetails;
import com.xt.util.PageUtil;
/**
 * 入库申请操作
 * @author yx
 *
 */
public interface SgatherMapper {
	//分页查询入库
	List<SGather> getAllSgatherInfo(@Param("page") PageUtil page,@Param("sgather")SGather sgather);
	//查询入库信息条数
	int getSGatherCount(@Param("sgather")SGather sgather);
	//查询
	int getMManufactureCount(@Param("df")D_file df);
	//查询d_file的所有物料以及生产总表已完工的产品
	List<D_file> getAllMManufactureInfo(@Param("page") PageUtil page,@Param("df")D_file df);
	//添加入库详细
	int addSgatherDetail(SGatherDetails sd);
	//根据入库单号查询详情
	List<SGatherDetails> queryRukuDetail(String gather_id);
	//根据入库单号查询总数量
	String queryRuKuCount(String gather_id);
	//根据入库单号查询总金额
	String queryRuKuMoney(String gather_id);
	//生产入库申请单号用的
	String getId();
	//删除入库详细的数据
	int delRuCudetail(@Param("gather_id") String gather_id, @Param("product_id") String product_id);
	//查询入库详细的所有数据 
	List<SGatherDetails> queryAllRuKuDetail();
	//修改入库详细的数量
	int updateRuKuDetailNum(@Param("gather_id") String gather_id, @Param("product_id") String product_id,
			@Param("subtotal") double subtotal, @Param("amount") int amount);
	//保存入库申请
	public int saveRuKu(SGather sg);
	//审核通过
	public int RuKufuheSuccess(@Param("gather_id") String gather_id,@Param("checker") String checker,@Param("check_time") String check_time);
	//审核不通过
	public int RuKufuheNoSuccess(@Param("gather_id") String gather_id,@Param("checker") String checker,@Param("check_time") String check_time);
	//分页查询入库申请单信息
	public int getRuKuCount(@Param("sg") SGather sg);
	List<SGather> getRuKuInfo(@Param("page") PageUtil page,@Param("sg") SGather sg);
}
