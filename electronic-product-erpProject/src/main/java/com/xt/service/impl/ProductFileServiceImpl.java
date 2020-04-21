package com.xt.service.impl;
import java.util.List;

/**
 * 产品档案
 * @author yl
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.mapper.ProductFileMapper;
import com.xt.pojo.D_file;
import com.xt.pojo.Users;
import com.xt.service.ProductFileService;
import com.xt.util.PageDemo;
import com.xt.util.PageUtil;
@Service
public class ProductFileServiceImpl implements ProductFileService{
	
	@Autowired
	ProductFileMapper mapper;
	
	@Override
	public int addProductInfo(D_file df) {
		return mapper.addProductInfo(df);
	}

	@Override
	public String getDanHao() {
		return mapper.getDanHao();
	}

	@Override
	public PageDemo<D_file> getD_fileFuHei(int nowPage, int pageSize, D_file df) {
		PageDemo<D_file> pd = new PageDemo<D_file>();
		//(调用mapper的方法)
		int rowCount = mapper.getD_FileCount(df);
		PageUtil page = new PageUtil(pageSize, nowPage, rowCount);
		List<D_file> list = mapper.getD_fileFuHei(page, df);
		pd.setCode(0);
		pd.setCount(rowCount);
		pd.setMsg("");
		pd.setData(list);
		return pd;
	}

	@Override
	public int updateD_fileFuHe(D_file df) {
		return mapper.updateD_fileFuHe(df);
	}

	@Override
	public D_file getD_fileById(String product_id) {
		return mapper.getD_fileById(product_id);
	}

	@Override
	public PageDemo<D_file> getD_fileInfo(int nowPage, int pageSize, D_file df) {
		PageDemo<D_file> pd = new PageDemo<D_file>();
		//(调用mapper的方法)
		int rowCount = mapper.getD_FileCount(df);
		PageUtil page = new PageUtil(pageSize, nowPage, rowCount);
		List<D_file> list = mapper.getD_fileInfo(page, df);
		pd.setCode(0);
		pd.setCount(rowCount);
		pd.setMsg("");
		pd.setData(list);
		return pd;
	}

	@Override
	public int updateDelProduct(String product_id) {
		return mapper.updateDelProduct(product_id);
	}

	@Override
	public int updateProductInfo(D_file df) {
		return mapper.updateProductInfo(df);
	}
}
