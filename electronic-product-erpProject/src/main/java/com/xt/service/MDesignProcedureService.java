package com.xt.service;

import com.xt.pojo.MDesignProcedure;
import com.xt.util.PageDemo;

public interface MDesignProcedureService {
	/**
	 * 分页查询所有产品设计工序
	 * @return
	 */
	PageDemo<MDesignProcedure> getAllMdesign(int nowPage, int pageSize,MDesignProcedure mdesignProcedure);
	/**
	 * 查询单个
	 * @param id
	 * @return
	 */
	MDesignProcedure findId(String id);
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
	int mdesUpdate(MDesignProcedure updateMdes);
}
