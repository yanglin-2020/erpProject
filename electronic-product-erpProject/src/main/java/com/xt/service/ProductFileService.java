package com.xt.service;

import com.xt.pojo.D_file;

public interface ProductFileService {
	//添加产品档案信息
	int addProductInfo(D_file df);
	//生成产品单号要用的
	String getDanHao();
}
