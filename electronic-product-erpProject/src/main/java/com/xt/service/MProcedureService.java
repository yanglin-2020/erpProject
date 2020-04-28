package com.xt.service;

import com.xt.pojo.MProcedure;
import com.xt.util.PageDemo;
/**
 * 生产计划
 * @author asus
 *
 */
public interface MProcedureService {
	
	/**
	 * 分页查询
	 * @param nowPage
	 * @param pageSize
	 * @param ma
	 * @return
	 */
	PageDemo<MProcedure> getAllMapp(int nowPage, int pageSize,MProcedure ma);
	/**
	 * 查询单个
	 * @param id
	 * @return
	 */
	MProcedure findId(String id);
	/**'
	 * 添加产品设计
	 * @param addMdes
	 * @return
	 */
	int mappadd(MProcedure ma);
	/**
	 * 修改产品设计
	 * @param updateMdes
	 * @return
	 */
	int mappUpdate(MProcedure ma);
}
