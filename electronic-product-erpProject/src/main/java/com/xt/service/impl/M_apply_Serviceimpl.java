package com.xt.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.mapper.M_apply_Mapper;
import com.xt.pojo.D_file;
import com.xt.pojo.MApply;
import com.xt.pojo.Users;
import com.xt.service.M_apply_Service;
import com.xt.util.DanhaoUtil;
import com.xt.util.PageDemo;
import com.xt.util.PageUtil;
import com.xt.util.ShengchanUtil;

/**
 *  生产计划 		Serviceimpl
 * @author CQK
 * 
 *
 */
@Service
public class M_apply_Serviceimpl implements M_apply_Service {
	
	@Autowired
	M_apply_Mapper mapper;
	
	List<D_file> dfileList=new ArrayList<D_file>();
	List<D_file> list ;

	@Override
	public PageDemo<D_file> getAllM_applyInfo(int nowPage, int pageSize) {
		PageDemo<D_file> pd=new PageDemo<D_file>();
		int rowCount = mapper.getDfileCount();
		PageUtil page = new PageUtil(pageSize, nowPage, rowCount);
		//获取用户的分页查询(调用mapper的方法)
		list= mapper.getAllDfileInfo(page);
		pd.setCode(0);
		pd.setCount(rowCount);
		pd.setMsg("");
		pd.setData(list);
		return pd;
	}

	@Override
	public int addMApply(MApply mapply) {
		int num=0;
		int listNum=dfileList.size();
		for (D_file d_file : dfileList) {
			System.out.println(d_file.getProduct_name());
			mapply.setApply_id(ShengchanUtil.getProductDanHao());
			mapply.setProduct_id(d_file.getProduct_id());
			mapply.setProduct_name(d_file.getProduct_name());
			mapply.setProduct_describe(d_file.getProduct_describe());
			mapply.setType(d_file.getType());
			mapply.setAmount(d_file.getPersonal_value());
			int row=mapper.addMApply(mapply);
			num+=row;
		}
		if(listNum==num) {
			dfileList.clear();
		}
		return num;
	}

	@Override
	public int addD_fileList(D_file dfile) {
		if(dfileList!=null) {
			for (D_file d_file : dfileList) {
				if(d_file.getProduct_id().equals(dfile.getProduct_id())) {
					return 0;
				}
			}
		}
		for (D_file dlist : list) {
			if(dlist.getProduct_id().equals(dfile.getProduct_id())) {
				dfileList.add(dlist);
				break;
			}
		}
		return 1;
		
	}

	@Override
	public List<D_file> getD_filesList() {
		
		return dfileList;
	}

	@Override
	public int alterNum(int shuliang, String productid) {
		for (D_file d_file : dfileList) {
			if(d_file.getProduct_id().equals(productid)) {
				d_file.setPersonal_value(Integer.toString(shuliang));
				break;
			}
		}
		return 1;
	}

	@Override
	public int delD_fileList(String id) {
		int i=0;
		for (D_file d_file : dfileList) {
			if(d_file.getProduct_id().equals(id)) {
				dfileList.remove(d_file);
				i++;
				break;
			}
		}
		return i;
	}

	@Override
	public PageDemo<MApply> getAllMapplyAudit(int nowPage, int pageSize, MApply mapply) {
		PageDemo<MApply> pd = new PageDemo<MApply>();
		//(调用mapper的方法)
		int rowCount = mapper.getAllMapplyAuditCount(mapply);
		PageUtil page = new PageUtil(pageSize, nowPage, rowCount);
		List<MApply> list = mapper.getAllMapplyAudit(page, mapply);
		pd.setCode(0);
		pd.setCount(rowCount);
		pd.setMsg("");
		pd.setData(list);
		return pd;
	}

	//根据产品生产计划编号查询生产计划中的数据
	@Override
	public MApply getMapplyAuditByid(String apply_id) {
		MApply mapply=mapper.getMapplyAuditByid(apply_id);
		return mapply;
	}

	//产品生产计划审核(通过)
	@Override
	public int approveMapply(MApply mapply) {
		int row=mapper.approveMapply(mapply);
		return row;
	}

	//产品生产计划审核（不通过）
	@Override
	public int noApproveMapply(MApply mapply) {
		int row=mapper.approveMapply(mapply);
		return row;
	}

	//查询生产计划信息(条件)
	@Override
	public PageDemo<MApply> allMapply(int nowPage, int pageSize, MApply mapply) {
		PageDemo<MApply> pd = new PageDemo<MApply>();
		//(调用mapper的方法)
		int rowCount = mapper.getAllMapplyCount(mapply);
		PageUtil page = new PageUtil(pageSize, nowPage, rowCount);
		List<MApply> list = mapper.getAllMapply(page, mapply);
		pd.setCode(0);
		pd.setCount(rowCount);
		pd.setMsg("");
		pd.setData(list);
		return pd;
	}

	//根据生产计划编号修改审核标志
	@Override
	public int examination(MApply mapply) {
		int row=mapper.examination(mapply);
		return row;
	}

	//修改生产计划单
	@Override
	public int updateMapply(MApply mapply) {
		int row=mapper.updateMapply(mapply);
		return row;
	}


}
