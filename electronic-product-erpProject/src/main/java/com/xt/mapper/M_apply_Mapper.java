package com.xt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.xt.pojo.D_file;
import com.xt.pojo.MApply;
import com.xt.util.PageUtil;
/**
 * 
 * @author cqk
 *
 */
public interface M_apply_Mapper {
	@Select("select count(1) from d_file where type='商品' and check_tag='审核通过'  ")
	int getDfileCount();

	@Select("select * from d_file where type='商品' and check_tag='审核通过' limit #{page.startRow},#{page.pageSize}")
	List<D_file> getAllDfileInfo(@Param("page") PageUtil page);
	
	@Insert("insert into m_apply values(null,#{mapply.apply_id},#{mapply.product_id},#{mapply.product_name},#{mapply.product_describe},#{mapply.type},#{mapply.amount},#{mapply.designer},#{mapply.remark},#{mapply.register},#{mapply.register_time},null,null,null,'S001-0','P001-0')")
	int addMApply(@Param("mapply") MApply mapply);
	
	//查询没有审核的生产计划数量
	int getAllMapplyAuditCount(@Param("m") MApply m);

	//查询没有审核生产计划信息
	List<MApply> getAllMapplyAudit(@Param("page") PageUtil page,@Param("m") MApply m);

	//根据产品生产计划编号查询生产计划中的数据
	MApply getMapplyAuditByid(@Param("apply_id") String apply_id);

	//产品生产计划审核(通过)
	int approveMapply(@Param("mapply") MApply mapply);

	//查询生产计划信息(条件)数量
	int getAllMapplyCount(@Param("m") MApply mapply);
	
	//查询生产计划信息(条件)数据
	List<MApply> getAllMapply(@Param("page") PageUtil page,@Param("m") MApply mapply);


	
	

}
