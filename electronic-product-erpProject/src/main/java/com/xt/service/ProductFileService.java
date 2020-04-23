package com.xt.service;

import com.xt.pojo.D_file;
import com.xt.util.PageDemo;

public interface ProductFileService {
	//添加产品档案信息
	int addProductInfo(D_file df);
	//生成产品单号要用的
	String getDanHao();
	//查询需要复核的产品档案
	public PageDemo<D_file> getD_fileFuHei(int nowPage, int pageSize,D_file df);
	//复核产品档案
	int updateD_fileFuHe(D_file df);
	//复核前根据产品id查询信息
	D_file getD_fileById(String product_id);
	//分页查询产品档案的信息
	public PageDemo<D_file> getD_fileInfo(int nowPage, int pageSize,D_file df);
	//删除一个产品档案信息(并没有真正删除，只是修改状态)
	int updateDelProduct(String product_id);
	//更新产品档案信息
	int updateProductInfo(D_file df);
	//分页查询变更后的档案信息
	public PageDemo<D_file> getUpdateD_fileInfo(int nowPage, int pageSize,D_file df);
	//分页查询删除后的档案信息
	public PageDemo<D_file> getDelD_fileInfo(int nowPage, int pageSize,D_file df);
	//永久删除产品档案信息
	int  delProductInfo(String product_id);
	//恢复已经删除的档案信息
	int RecoverDelProduct(String product_id);
	
	//商品的分页查询
	public PageDemo<D_file> getProductInfo(int nowPage, int pageSize,D_file df);
}
