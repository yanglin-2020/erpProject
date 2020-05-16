package com.xt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.mapper.Caigou_diaoduMapper;
import com.xt.mapper.ckGuanliMapper;
import com.xt.pojo.Buygoods;
import com.xt.pojo.Buygoods_detail;
import com.xt.pojo.Goods;
import com.xt.pojo.SPay;
import com.xt.pojo.Supplier;
import com.xt.service.Caigou_DiaoduService;
import com.xt.util.PageDemo;
import com.xt.util.PageUtil;
/**
 * 采购调度实现类
 * @author long
 *
 */
@Service
public class Caigou_diaoduServiceImpl implements Caigou_DiaoduService {
	
	@Autowired
	Caigou_diaoduMapper mapper;
	/**
	 * 查询所有采购信息
	 */
	@Override
	public PageDemo<Buygoods> getAllBuygoodsInfo(int nowPage, int pageSize, Buygoods b) {
		PageDemo<Buygoods> pd = new PageDemo<Buygoods>();
		// 获取采购总记录数(调用mapper的方法)
		int rowCount = mapper.getBuygoodsCount(b);
		PageUtil page = new PageUtil(pageSize, nowPage, rowCount);
		// 获取采购的分页查询(调用mapper的方法)
		List<Buygoods> list = mapper.getAllBuygoodsInfo(page,b);
		System.out.println(list);
		pd.setCode(0);
		pd.setCount(rowCount);
		pd.setMsg("");
		pd.setData(list);
		return pd;
	}
	/**
	 * 查询采购详细记录
	 */
	@Override
	public List<Buygoods_detail> getBuygoodsdetails(String buy_id) {
		return mapper.getBuygoodsdetails(buy_id);
	}
	/**
	 * 查询所有供应商
	 */
	@Override
	public List<Supplier> gysSelect() {
		return mapper.gysSelect();
	}
	/**
	 * 根据供应商ID查询商品信息
	 */
	@Override
	public PageDemo<Goods> selectGoodsBySupplier_ID(int nowPage, int pageSize, Goods b) {
		PageDemo<Goods> pd = new PageDemo<Goods>();
		// 获取采购总记录数(调用mapper的方法)
		int rowCount = mapper.getGoodsCount(b);
		PageUtil page = new PageUtil(pageSize, nowPage, rowCount);
		// 获取采购的分页查询(调用mapper的方法)
		List<Goods> list = mapper.selectGoodsBySupplier_ID(page,b);
		pd.setCode(0);
		pd.setCount(rowCount);
		pd.setMsg("");
		pd.setData(list);
		return pd;
	}
	/**
	 * 添加采购详细
	 */
	@Override
	public int addBuygoods_details(Buygoods_detail b) {
		return mapper.addBuygoods_details(b);
	}
	/**
	 * 查询总数量
	 */
	@Override
	public String selectBuy_sum(String buy_id) {
		return mapper.selectBuy_sum(buy_id);
	}
	/**
	 * 查询总金额
	 */
	@Override
	public String selectBuy_price(String buy_id) {
		return mapper.selectBuy_price(buy_id);
	}
	/**
	 * 添加采购表
	 */
	@Override
	public int addBuygoods(Buygoods b) {
		return mapper.addBuygoods(b);
	}
	/**
	 * 采购审核
	 */
	@Override
	public int shenhe(Buygoods b) {
		int result = mapper.shenheBuygoods(b);
		if(result>0){
			result = mapper.shenheBuygoods_details(b);
		}
		return result;
	}
	/**
	 * 删除采购详细
	 */
	@Override
	public int delBuygoods_detail(Buygoods_detail b) {
		return mapper.delBuygoods_detail(b);
	}
	/**
	 * 查询采购详细，根据采购编号和商品ID
	 */
	@Override
	public int findBuygoods_detail(Buygoods_detail b) {
		return mapper.findBuygoods_detail(b);
	}
	/**
	 * 如果采购编号和商品ID都相同，则添加商品数量
	 */
	@Override
	public int updateBuygoods_detail(Buygoods_detail b) {
		return mapper.updateBuygoods_detail(b);
	}

}
