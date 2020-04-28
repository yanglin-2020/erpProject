package com.xt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xt.pojo.MDesignProcedure;
import com.xt.pojo.MDesignProcedureModule;
import com.xt.util.PageUtil;

/**
 * 设计物料明细
 * @author 罗文涛
 *
 */
public interface MDesignProcedureModuleMapper {
	/**
	 * 分页条件查询物料
	 * @return
	 */
	public List<MDesignProcedureModule> mdesignAll(@Param("page") PageUtil page,@Param("md") MDesignProcedureModule md);
	/**
	 * 查询数量
	 * @param md
	 * @return
	 */
	public int mdesignCount(@Param("md")  MDesignProcedureModule md);
	/**
	 * 添加物料
	 * @param md
	 * @return
	 */
	public int mdesignadd(MDesignProcedureModule md);
	/**
	 * 修改物料
	 * @param md
	 * @return
	 */
	public int mdesignUpdate(MDesignProcedureModule md);
}
