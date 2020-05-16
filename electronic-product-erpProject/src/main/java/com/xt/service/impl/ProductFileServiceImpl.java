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
import com.xt.pojo.DModule;
import com.xt.pojo.DModuleDetails;
import com.xt.pojo.D_file;
import com.xt.pojo.Goods;
import com.xt.pojo.KuCun;
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
		int rowCount = mapper.getD_FileCount1(df);
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

	@Override
	public PageDemo<D_file> getUpdateD_fileInfo(int nowPage, int pageSize, D_file df) {
		PageDemo<D_file> pd = new PageDemo<D_file>();
		//(调用mapper的方法)
		int rowCount = mapper.getD_FileCount2(df);
		PageUtil page = new PageUtil(pageSize, nowPage, rowCount);
		List<D_file> list = mapper.getUpdateD_fileInfo(page, df);
		pd.setCode(0);
		pd.setCount(rowCount);
		pd.setMsg("");
		pd.setData(list);
		return pd;
	}

	@Override
	public PageDemo<D_file> getDelD_fileInfo(int nowPage, int pageSize, D_file df) {
		PageDemo<D_file> pd = new PageDemo<D_file>();
		//(调用mapper的方法)
		int rowCount = mapper.getD_FileCount3(df);
		PageUtil page = new PageUtil(pageSize, nowPage, rowCount);
		List<D_file> list = mapper.getDelD_fileInfo(page, df);
		pd.setCode(0);
		pd.setCount(rowCount);
		pd.setMsg("");
		pd.setData(list);
		return pd;
	}

	@Override
	public int delProductInfo(String product_id) {
		return mapper.delProductInfo(product_id);
	}

	@Override
	public int RecoverDelProduct(String product_id) {
		return mapper.RecoverDelProduct(product_id);
	}

	@Override
	public PageDemo<D_file> getProductInfo(int nowPage, int pageSize, D_file df) {
		PageDemo<D_file> pd = new PageDemo<D_file>();
		//(调用mapper的方法)
		int rowCount = mapper.getProductCount(df);
		PageUtil page = new PageUtil(pageSize, nowPage, rowCount);
		List<D_file> list = mapper.getProductInfo(page, df);
		pd.setCode(0);
		pd.setCount(rowCount);
		pd.setMsg("");
		pd.setData(list);
		return pd;
	}

	@Override
	public PageDemo<D_file> getMaterialInfo(int nowPage, int pageSize, D_file df) {
		PageDemo<D_file> pd = new PageDemo<D_file>();
		//(调用mapper的方法)
		int rowCount = mapper.getMaterialCount(df);
		PageUtil page = new PageUtil(pageSize, nowPage, rowCount);
		List<D_file> list = mapper.getMaterialInfo(page, df);
		pd.setCode(0);
		pd.setCount(rowCount);
		pd.setMsg("");
		pd.setData(list);
		return pd;
	}

	@Override
	public int addMaterial(DModuleDetails dd) {
		return mapper.addMaterial(dd);
	}

	@Override
	public int minusMaterialNum(int num, String id) {
		return mapper.minusMaterialNum(num, id);
	}

	@Override
	public List<DModuleDetails> queryMaterial(String id) {
		return mapper.queryMaterial(id);
	}

	@Override
	public int delMaterial(String id,String parent_id) {
		return mapper.delMaterial(id,parent_id);
	}

	@Override
	public int addMaterialNum(int num, String id) {
		return mapper.addMaterialNum(num, id);
	}

	@Override
	public String getDesignDanHao() {
		return mapper.getDesignDanHao();
	}

	@Override
	public int saveMaterail(DModule dm) {
		return mapper.saveMaterail(dm);
	}

	@Override
	public int updateGoodsDesign(String product_id) {
		return mapper.updateGoodsDesign(product_id);
	}

	@Override
	public PageDemo<DModule> getMaterialFuHeInfo(int nowPage, int pageSize, DModule dm) {
		PageDemo<DModule> pd = new PageDemo<DModule>();
		//(调用mapper的方法)
		int rowCount = mapper.getMaterialFuHeCount(dm);
		PageUtil page = new PageUtil(pageSize, nowPage, rowCount);
		List<DModule> list = mapper.getMaterialFuHeInfo(page, dm);
		pd.setCode(0);
		pd.setCount(rowCount);
		pd.setMsg("");
		pd.setData(list);
		return pd;
	}

	@Override
	public double getMaterialSumMoney(String product_id) {
		return mapper.getMaterialSumMoney(product_id);
	}

	@Override
	public int updateMaterialFuHeInfo(DModule dm) {
		return mapper.updateMaterialFuHeInfo(dm);
	}

	@Override
	public List<DModuleDetails> getMaterialDetail(String product_id) {
		return mapper.getMaterialDetail(product_id);
	}

	@Override
	public DModule getMaterialInfo(String design_id) {
		return mapper.getMaterialsInfo(design_id);
	}

	@Override
	public PageDemo<DModule> getAllModuleInfo(int nowPage, int pageSize, DModule dm) {
		PageDemo<DModule> pd = new PageDemo<DModule>();
		//(调用mapper的方法)
		int rowCount = mapper.getModuleCount(dm);
		PageUtil page = new PageUtil(pageSize, nowPage, rowCount);
		List<DModule> list = mapper.getAllModuleInfo(page, dm);
		pd.setCode(0);
		pd.setCount(rowCount);
		pd.setMsg("");
		pd.setData(list);
		return pd;
	}

	@Override
	public List<DModuleDetails> getAllDModuleDetails() {
		return mapper.getAllDModuleDetails();
	}

	@Override
	public int updateMaterialNum(String product_id, String parent_id, int num,double sumMoney) {
		return mapper.updateMaterialNum(product_id, parent_id, num,sumMoney);
	}

	@Override
	public int updateMaterialSuccess(DModule dm) {
		return mapper.updateMaterialSuccess(dm);
	}

	@Override
	public PageDemo<DModule> getMaterialupdateInfo(int nowPage, int pageSize, DModule dm) {
		PageDemo<DModule> pd = new PageDemo<DModule>();
		//(调用mapper的方法)
		int rowCount = mapper.getMaterialupdateCount(dm);
		PageUtil page = new PageUtil(pageSize, nowPage, rowCount);
		List<DModule> list = mapper.getMaterialupdateInfo(page, dm);
		pd.setCode(0);
		pd.setCount(rowCount);
		pd.setMsg("");
		pd.setData(list);
		return pd;
	}

	@Override
	public double getMaterialMoney(String id, String parent_id) {
		return mapper.getMaterialMoney(id, parent_id);
	}

	@Override
	public int updateMaterialSumMoney(String design_id, double money) {
		return mapper.updateMaterialSumMoney(design_id, money);
	}

	@Override
	public int updateMaterialSumMoneyadd(String design_id, double money) {
		return mapper.updateMaterialSumMoneyadd(design_id, money);
	}

	@Override
	public int delMaterialById(String product_id) {
		return mapper.delMaterialById(product_id);
	}

	@Override
	public PageDemo<D_file> getProductlwtInfo(int nowPage, int pageSize, D_file df) {
		PageDemo<D_file> pd = new PageDemo<D_file>();
		//(调用mapper的方法)
		int rowCount = mapper.getProductlwtCount(df);
		PageUtil page = new PageUtil(pageSize, nowPage, rowCount);
		List<D_file> list = mapper.getProductlwtInfo(page, df);
		pd.setCode(0);
		pd.setCount(rowCount);
		pd.setMsg("");
		pd.setData(list);
		return pd;
	}

	@Override
	public PageDemo<KuCun> getKuCunInfo(int nowPage, int pageSize, KuCun kc) {
		PageDemo<KuCun> pd = new PageDemo<KuCun>();
		//(调用mapper的方法)
		int rowCount = mapper.getKuCunCount(kc);
		PageUtil page = new PageUtil(pageSize, nowPage, rowCount);
		List<KuCun> list = mapper.getKuCunInfo(page, kc);
		pd.setCode(0);
		pd.setCount(rowCount);
		pd.setMsg("");
		pd.setData(list);
		return pd;
	}

	@Override
	public int addGoodsInfoByD_File(Goods g) {
		return mapper.addGoodsInfoByD_File(g);
	}
}
