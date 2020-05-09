package com.xt.service;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xt.pojo.D_file;
import com.xt.pojo.MManufacture;
import com.xt.pojo.SGather;
import com.xt.pojo.SGatherDetails;
import com.xt.util.PageDemo;

public interface SgatherService {
	//查询入库信息条数
	int getSGatherCount(SGather sgather);
	//分页查询获取入库全部数据
	PageDemo<SGather> selectSgather(int nowPage, int pageSize,SGather sgather);
	//分页查询MManufacture已完成的数据
	public PageDemo<D_file> getMaterialInfo_ywg(int nowPage,int pageSize,D_file df);
	//添加详情入库
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
	int delRuCudetail(String gather_id, String product_id);
	//查询入库详细的所有数据 
	List<SGatherDetails> queryAllRuKuDetail();
	//修改入库详细的数量
	int updateRuKuDetailNum(@Param("gather_id") String gather_id, @Param("product_id") String product_id,
				@Param("subtotal") double subtotal, @Param("amount") int amount);
	//保存入库申请
	public int saveRuKu(SGather sg);
	//审核通过
	public int RuKufuheSuccess(@Param("gather_id") String gather_id,@Param("checker") String checker,@Param("checker") String check_time);
	//审核不通过
	public int RuKufuheNoSuccess(@Param("gather_id") String gather_id,@Param("checker") String checker,@Param("checker") String check_time);
	//分页查询入库申请单信息
	public PageDemo<SGather> getRuKuInfo(int nowPage,int pageSize,SGather sg);
}
