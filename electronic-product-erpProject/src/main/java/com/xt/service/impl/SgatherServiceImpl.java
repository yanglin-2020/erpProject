package com.xt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.mapper.SgatherMapper;
import com.xt.pojo.Buygoods_detail;
import com.xt.pojo.D_file;
import com.xt.pojo.MManufacture;
import com.xt.pojo.SGather;
import com.xt.pojo.SGatherDetails;
import com.xt.pojo.Users;
import com.xt.service.SgatherService;
import com.xt.util.PageDemo;
import com.xt.util.PageUtil;

@Service
public class SgatherServiceImpl implements SgatherService {
	@Autowired
	SgatherMapper mapper;

	@Override
	public PageDemo<SGather> selectSgather(int nowPage, int pageSize, SGather sgather) {
		// TODO Auto-generated method stub
		PageDemo<SGather> pd = new PageDemo<SGather>();
		// 获取用户总记录数(调用mapper的方法)
		int rowCount = mapper.getSGatherCount(sgather);
		PageUtil page = new PageUtil(pageSize, nowPage, rowCount);
		// 获取用户的分页查询(调用mapper的方法)
		List<SGather> list = mapper.getAllSgatherInfo(page, sgather);
		pd.setCode(0);
		pd.setCount(rowCount);
		pd.setMsg("");
		pd.setData(list);
		return pd;
	}

	@Override
	public int getSGatherCount(SGather sgather) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 查询MManufacture已完工的数据
	 */
	@Override
	public PageDemo<Buygoods_detail> getMaterialInfo_ywg(int nowPage, int pageSize, Buygoods_detail df) {
		// TODO Auto-generated method stub
		PageDemo<Buygoods_detail> pd = new PageDemo<Buygoods_detail>();
		// 获取用户总记录数(调用mapper的方法)
		int rowCount = mapper.getMManufactureCount(df);
		PageUtil page = new PageUtil(pageSize, nowPage, rowCount);
		// 获取用户的分页查询(调用mapper的方法)
		List<Buygoods_detail> list = mapper.getAllMManufactureInfo(page, df);
		pd.setCode(0);
		pd.setCount(rowCount);
		pd.setMsg("");
		pd.setData(list);
		return pd;
	}

	@Override
	public int addSgatherDetail(SGatherDetails sd) {
		return mapper.addSgatherDetail(sd);
	}

	@Override
	public List<SGatherDetails> queryRukuDetail(String gather_id) {
		return mapper.queryRukuDetail(gather_id);
	}

	@Override
	public String queryRuKuCount(String gather_id) {
		return mapper.queryRuKuCount(gather_id);
	}

	@Override
	public String queryRuKuMoney(String gather_id) {
		return mapper.queryRuKuMoney(gather_id);
	}

	@Override
	public String getId() {
		return mapper.getId();
	}

	@Override
	public int delRuCudetail(String gather_id, String product_id) {
		return mapper.delRuCudetail(gather_id, product_id);
	}

	@Override
	public List<SGatherDetails> queryAllRuKuDetail() {
		return mapper.queryAllRuKuDetail();
	}

	@Override
	public int updateRuKuDetailNum(String gather_id, String product_id, double subtotal, int amount) {
		return mapper.updateRuKuDetailNum(gather_id, product_id, subtotal, amount);
	}

	@Override
	public int saveRuKu(SGather sg) {
		return mapper.saveRuKu(sg);
	}

	@Override
	public int RuKufuheSuccess(String gather_id, String checker, String check_time) {
		return mapper.RuKufuheSuccess(gather_id, checker, check_time);
	}

	@Override
	public int RuKufuheNoSuccess(String gather_id, String checker, String check_time) {
		return mapper.RuKufuheNoSuccess(gather_id, checker, check_time);
	}

	@Override
	public PageDemo<SGather> getRuKuInfo(int nowPage, int pageSize, SGather sg) {
		// TODO Auto-generated method stub
		PageDemo<SGather> pd = new PageDemo<SGather>();
		// 获取用户总记录数(调用mapper的方法)
		int rowCount = mapper.getRuKuCount(sg);
		PageUtil page = new PageUtil(pageSize, nowPage, rowCount);
		// 获取用户的分页查询(调用mapper的方法)
		List<SGather> list = mapper.getRuKuInfo(page, sg);
		pd.setCode(0);
		pd.setCount(rowCount);
		pd.setMsg("");
		pd.setData(list);
		return pd;
	}

	@Override
	public List<SGatherDetails> querydetail(String gather_id) {
		return mapper.querydetail(gather_id);
	}

	@Override
	public int updateBuyGoods_Detail_Status2(String id) {
		return mapper.updateBuyGoods_Detail_Status2(id);
	}
}
