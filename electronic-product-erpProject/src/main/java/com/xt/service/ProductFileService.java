package com.xt.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xt.pojo.DModule;
import com.xt.pojo.DModuleDetails;
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
	//物料的分页查询
	public PageDemo<D_file> getMaterialInfo(int nowPage, int pageSize,D_file df);
	//为某个产品添加所需的物料
	int addMaterial(DModuleDetails dd);
	//添加成功后数量减少
	int minusMaterialNum(@Param("num") int num,@Param("id") String id);
	//查询需要的物料
	List<DModuleDetails> queryMaterial(String id);
	//删除一个商品需要的物料
	int delMaterial(String id,String parent_id);
	//删除后物料数量增加
	int addMaterialNum(@Param("num") int num,@Param("id") String id);
	//生成设计单号要用的
	String getDesignDanHao();
	//物料组成设计单完成进行保存
	int saveMaterail(DModule dm);
	//修改商品的设计状态(已设计)
	int updateGoodsDesign(String product_id);
	//分页查询需要复核物料组成的信息
	public PageDemo<DModule> getMaterialFuHeInfo(int nowPage, int pageSize,DModule dm);
	//拿到需要物料的总成本
	double getMaterialSumMoney(String product_id);
	//物料组成设计单审核不通过
	int updateMaterialFuHeInfo(DModule dm);
	//复核物料前根据id拿到产品所需物料的详细信息
	List<DModuleDetails> getMaterialDetail(String product_id);
	//根据设计单号拿信息
	DModule getMaterialInfo(String design_id);
	//分页查询物料的信息(通过)
	public PageDemo<DModule> getAllModuleInfo(int nowPage, int pageSize,DModule dm);
	//查询物料详细表里的所有物料
	public List<DModuleDetails> getAllDModuleDetails();
	//修改产品需要的物料信息
	public int updateMaterialNum(@Param("product_id") String product_id,@Param("parent_id") String parent_id,
			@Param("num") int num,@Param("sumMoney") double sumMoney );
	//修改产品需要的物料信息
	public int updateMaterialSuccess(DModule dm);
	//分页查询物料的信息(通过)
	public PageDemo<DModule> getMaterialupdateInfo(int nowPage, int pageSize,DModule dm);
	
	//后面加的方法(完善)
	//物料删除后，物料总成本减少
	double getMaterialMoney(@Param("id") String id,@Param("parent_id") String parent_id);
	int updateMaterialSumMoney(@Param("design_id") String design_id,@Param("money") double money);
	int updateMaterialSumMoneyadd(@Param("design_id") String design_id,@Param("money") double money);
	int delMaterialById(String product_id);
	
	//罗文涛的制定产品生产工序设计单分页查询
	public PageDemo<D_file> getProductlwtInfo(int nowPage, int pageSize,D_file df);
}
