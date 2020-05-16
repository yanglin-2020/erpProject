package com.xt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xt.pojo.Buygoods;
import com.xt.pojo.Buygoods_detail;
import com.xt.pojo.Goods;
import com.xt.pojo.Supplier;
import com.xt.util.PageUtil;

public interface Caigou_diaoduMapper {
	// 获取采购总记录数
	int getBuygoodsCount(Buygoods b);

	// 获取采购的分页查询
	List<Buygoods> getAllBuygoodsInfo(@Param("page") PageUtil page, @Param("b") Buygoods b);

	// 查询采购详细记录
	List<Buygoods_detail> getBuygoodsdetails(String buy_id);

	// 查询所有供应商
	List<Supplier> gysSelect();

	// 根据供应商ID查询商品总数
	int getGoodsCount(Goods g);

	// 根据供应商ID查询商品信息
	List<Goods> selectGoodsBySupplier_ID(@Param("page") PageUtil page, @Param("g") Goods g);

	// 添加采购详细
	int addBuygoods_details(Buygoods_detail b);

	// 查询总数量
	String selectBuy_sum(String buy_id);

	// 查询总金额
	String selectBuy_price(String buy_id);

	// 添加采购表
	int addBuygoods(Buygoods b);

	// 审核采购表
	int shenheBuygoods(Buygoods b);

	// 审核采购详细表
	int shenheBuygoods_details(Buygoods b);

	// 删除采购详细
	int delBuygoods_detail(Buygoods_detail b);

	// 查询采购详细，根据采购编号和商品ID
	int findBuygoods_detail(Buygoods_detail b);

	// 如果采购编号和商品ID都相同，则添加商品数量
	int updateBuygoods_detail(Buygoods_detail b);

}
