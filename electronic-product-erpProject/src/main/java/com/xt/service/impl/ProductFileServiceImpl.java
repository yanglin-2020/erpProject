package com.xt.service.impl;
/**
 * 产品档案
 * @author yl
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.mapper.ProductFileMapper;
import com.xt.pojo.D_file;
import com.xt.service.ProductFileService;
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
}
