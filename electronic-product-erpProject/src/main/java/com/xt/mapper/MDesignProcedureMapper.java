package com.xt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xt.pojo.MDesignProcedure;
import com.xt.util.PageUtil;
/**
 * 产品设计类
 * @author asus
 *罗文涛
 */
public interface MDesignProcedureMapper {
	
	/**
	 * 审核标志   S001-0: 等待审核     S001-1: 审核通过    S001-2: 审核不通过 check_Tag
	 * 分页查询所有产品设计工序
	 * @return
	 */
	public List<MDesignProcedure> listfind(@Param("page") PageUtil page,@Param("md") MDesignProcedure md);
	/**
	 * 查询单个
	 * @param id
	 * @return
	 */
	MDesignProcedure findId(String design_Id);
	/**
	 *有多少产品 数量
	 *
	 * @return
	 */
	int MdesCount(@Param("md") MDesignProcedure md);
	/**'
	 * 添加产品设计
	 * @param addMdes
	 * @return
	 */
	int mdesadd(MDesignProcedure addMdes);
	/**
	 * 修改产品设计
	 * @param updateMdes
	 * @return
	 */
	int mdesUpdate(@Param("md")MDesignProcedure md);
	
	
	
}
