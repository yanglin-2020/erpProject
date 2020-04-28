package com.xt.service;

import java.util.List;

import com.xt.pojo.DModuleDetails;
import com.xt.pojo.MDesignProcedureDetails;
import com.xt.util.PageDemo;

public interface MDesignProcedureDetailsService {
	/**
	 * 分页查询产品设计详情
	 * @return
	 */
	PageDemo<MDesignProcedureDetails> getAllMdesign(int nowPage, int pageSize,MDesignProcedureDetails mdesignProcedure);
	/**
	 * 分页查询产品设计详情
	 * @return
	 */
	PageDemo<DModuleDetails> getAllDModuleDetails(int nowPage, int pageSize,DModuleDetails mdesignProcedure);
	
	/**
	 * 产品设计详情
	 * @return
	 */
	List<MDesignProcedureDetails> findList(String parent_Id);
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
	/**
	 * 修改 	产品物料组成明细表
	 * @param dd
	 * @return
	 */
	int upd_moule(DModuleDetails dd);
}
