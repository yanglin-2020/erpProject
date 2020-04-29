package com.xt.service;

import com.xt.pojo.MDesignProcedure;
import com.xt.util.PageDemo;

public interface MDesignProcedureService {
	/**
	 * 审核标志   S001-0: 等待审核     S001-1: 审核通过    S001-2: 审核不通过 check_Tag
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
	int updatelwtdesign_procedure_tag(String product_Id);
}
