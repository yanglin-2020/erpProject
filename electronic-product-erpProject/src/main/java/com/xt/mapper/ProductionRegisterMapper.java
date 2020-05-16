package com.xt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xt.pojo.MManufacture;
import com.xt.pojo.MProcedure;
import com.xt.pojo.SGather;
import com.xt.pojo.SGatherDetails;
import com.xt.util.PageUtil;

/**
 * 
 * @CQK Administrator 生产登记mapper
 *
 */
public interface ProductionRegisterMapper {

	//获取生产总表已审核的数据数量
	int getManufactureCount(@Param("m") MManufacture manufacture);
	//获取生产总表已审核的数据
	List<MManufacture> getManufacture(@Param("page") PageUtil page, @Param("m")MManufacture manufacture);

	//根据派工单编号查询生产总表
	MManufacture getManufactureByid(@Param("m") MManufacture manufacture);

	//根据工单制定人查询生产工序表
	List<MProcedure> getMprocedure(@Param("mm") MManufacture mManufacture);
	
	//yl写的
	//修改工序状态
	int updateGongXuStatus(@Param("id") String id,@Param("procedurename") String procedurename);
	//修改生产总表的status状态
	int updatesczbStatus(String id);
	int updateGongXuStatus2(@Param("id") String id,@Param("procedurename") String procedurename);
	//修改生产总表的status状态
	int updatesczbStatus2(String id);
	
	int updateGongXuStatus3(@Param("id") String id,@Param("procedurename") String procedurename);
	//修改生产总表的status状态
	int updatesczbStatus3(String id);
	
	int updateGongXuStatus4(@Param("id") String id,@Param("procedurename") String procedurename);
	//修改生产总表的status状态
	int updatesczbStatus4(String id);
	//修改生产总表的字段，表示这个产品已经完工
	int updatesczbIswg(MManufacture mm);
	
	//分页查询需要复核的数据
	int getManufactureCountfuhe(@Param("m") MManufacture manufacture);
	List<MManufacture> getManufacturefuhe(@Param("page") PageUtil page, @Param("m")MManufacture manufacture);
	
	//查询生产总表的已经完工的产品
	MManufacture queryManufactureInfo(String id);
	//添加入库单
	int insertmmRukuDan(SGather s);
	//添加入库详细
	int insertmmDetailRuKuDan(SGatherDetails sg);
}
