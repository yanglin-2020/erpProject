package com.xt.service;

import com.xt.pojo.MDesignProcedure;
import com.xt.pojo.MDesignProcedureModule;
import com.xt.util.PageDemo;

public interface MDesignProcedureModuleService {
	/**
	 * 分页查询物料
	 * @return
	 */
	PageDemo<MDesignProcedureModule> getAllMdesign(int nowPage, int pageSize,MDesignProcedureModule mdesignProcedure);
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
