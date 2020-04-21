package com.xt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xt.pojo.MDesignProcedureDetails;
import com.xt.util.PageUtil;

/**
 *  产品设计详情
 * @author 罗文涛
 *
 */
public interface MDesignProcedureDetailsMapper {
	/**
	 * 产品设计详情
	 * @return
	 */
	List<MDesignProcedureDetails> findList(@Param("parent_Id") String parent_Id,@Param("page") PageUtil page);
	/**
	 * 查询详情数量
	 * @param id
	 * @return
	 */
	int count(String parent_Id);
	/**
	 * 修改产品设计详情
	 * @param md
	 * @return
	 */
	int updatemdesignDetails(MDesignProcedureDetails md);
	/**
	 * 添加产品设计详情
	 * @param md
	 * @return
	 */
	int addmdesignDetails(MDesignProcedureDetails md);
}
