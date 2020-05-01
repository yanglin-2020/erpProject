package com.xt.service;

import java.util.List;

import com.xt.pojo.D_file;
import com.xt.util.PageDemo;
import com.xt.pojo.MApply;

/**
 *  生产计划 		Service
 * @author CQK
 * 
 *
 */
public interface M_apply_Service {
	public PageDemo<D_file> getAllM_applyInfo(int nowPage, int pageSize);
	public int addMApply(MApply mapply);
	//添加到dfilelist
	public int addD_fileList(D_file dfile);
	public List<D_file> getD_filesList();
	public int alterNum(int shuliang, String productid);
	public int delD_fileList(String id);
	//审核生产计划中没有审核的数据
	public PageDemo<MApply> getAllMapplyAudit(int nowPage, int pageSize, MApply mapply);
	//根据产品生产计划编号查询生产计划中的数据
	public MApply getMapplyAuditByid(String apply_id);
	//产品生产计划审核(通过)
	public int approveMapply(MApply mapply);
	//产品生产计划审核（不通过）
	public int noApproveMapply(MApply mapply);
	//查询生产计划信息(条件)
	public PageDemo<MApply> allMapply(int nowPage, int pageSize, MApply ma);
	//根据生产计划编号修改审核标志
	public int examination(MApply mapply);
	//修改生产计划单
	public int updateMapply(MApply mapply);

}
