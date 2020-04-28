package com.xt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xt.pojo.DModuleDetails;
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
	public List<MDesignProcedureDetails> listfind(PageUtil page,@Param("md") MDesignProcedureDetails mdesignProcedure);
	/**
	 * 无分页查询
	 * @param parent_Id
	 * @return
	 */
	public List<MDesignProcedureDetails> findList(@Param("parent_Id") String parent_Id);
	
	
	/**
	 * 查询需要的物料
	 * @return
	 */
	public List<DModuleDetails> queryMaterial(PageUtil page,@Param("md") DModuleDetails md);
	
	/**
	 * 查询查询需要的物料有多少条
	 * @param mdesignProcedure
	 * @return
	 */
	public int MaterialCount(DModuleDetails Dm);
	
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
	 * 查询有多少条数据
	 * @param mdesignProcedure
	 * @return
	 */
	public int MdesCount(MDesignProcedureDetails mdesignProcedure);
	/**
	 * 修改 产品物料组成明细表
	 * @param dd
	 * @return
	 */
	public int upd_moule(DModuleDetails dd);
}
