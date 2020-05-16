package com.xt.service;

import java.util.List;

import com.xt.pojo.Buygoods;
import com.xt.pojo.Buygoods_detail;
import com.xt.pojo.Goods;
import com.xt.pojo.Supplier;
import com.xt.util.PageDemo;
/**
 * 采购调度接口
 * @author long
 *
 */
public interface Caigou_DiaoduService {
	//查询所有采购信息
	PageDemo<Buygoods> getAllBuygoodsInfo(int nowPage, int pageSize, Buygoods b);
	//查询采购详细记录
	List<Buygoods_detail> getBuygoodsdetails(String buy_id);
	//查询所有供应商
	List<Supplier> gysSelect();
	//根据供应商ID查询商品信息
	PageDemo<Goods> selectGoodsBySupplier_ID(int nowPage, int pageSize, Goods b);
	//添加采购详细
	int addBuygoods_details(Buygoods_detail b);
	//查询总数量
	String selectBuy_sum(String buy_id);
	//查询总金额
	String selectBuy_price(String buy_id);
	//添加采购表
	int addBuygoods(Buygoods b);
	//采购审核
	int shenhe(Buygoods b);
	//删除采购详细
	int delBuygoods_detail(Buygoods_detail b);
	//查询采购详细，根据采购编号和商品ID
	int findBuygoods_detail(Buygoods_detail b);
	//如果采购编号和商品ID都相同，则添加商品数量
	int updateBuygoods_detail(Buygoods_detail b);

}
