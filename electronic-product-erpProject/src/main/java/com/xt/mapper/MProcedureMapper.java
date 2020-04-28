package com.xt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xt.pojo.MProcedure;
import com.xt.util.PageUtil;
/**
 * 产品生产计划
 * @author 罗文涛
 *
 */
public interface MProcedureMapper {
	/**
	 * 
	 * 分页查询所有产品生产工序
	 * @return
	 */
	public List<MProcedure> listfind(@Param("page") PageUtil page,@Param("ma") MProcedure ma);
	/**
	 * 查询单个
	 * @param id
	 * @return
	 */
	MProcedure findId(String id);
	/**
	 *有多少产品计划数量
	 *
	 * @return
	 */
	int MappCount(@Param("ma") MProcedure ma);
	/**'
	 * 添加产品计划
	 * @param addMdes
	 * @return
	 */
	int mappadd(MProcedure addMdes);
	/**
	 * 修改产品计划
	 * @param updateMdes
	 * @return
	 */
	int mappUpdate(MProcedure ma);
}
