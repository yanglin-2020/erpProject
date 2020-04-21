package com.xt.mapper;

import com.xt.pojo.D_file;
/**
 * 产品档案
 * @author yl
 *
 */
public interface ProductFileMapper {
	//添加产品档案信息
	int addProductInfo(D_file df);
	//生成产品单号要用的
	String getDanHao();
}
