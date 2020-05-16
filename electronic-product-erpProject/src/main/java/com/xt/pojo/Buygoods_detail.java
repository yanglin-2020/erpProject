package com.xt.pojo;
/**
 * 采购详细表
 * @author long
 *
 */
public class Buygoods_detail {
	//商品ID
	private String goods_id;
	//商品名称
	private String goods_name;
	//商品数量
	private String goods_num;
	//商品单价
	private String goods_price;
	//商品单位
	private String goods_unit;
	//类型
	private String type;
	//采购编号
	private String buy_id;
	//状态,审核标志
	private String status;
	//状态
	private String status2;
	
	public String getStatus2() {
		return status2;
	}
	public void setStatus2(String status2) {
		this.status2 = status2;
	}
	public String getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(String goods_id) {
		this.goods_id = goods_id;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public String getGoods_num() {
		return goods_num;
	}
	public void setGoods_num(String goods_num) {
		this.goods_num = goods_num;
	}
	public String getGoods_price() {
		return goods_price;
	}
	public void setGoods_price(String goods_price) {
		this.goods_price = goods_price;
	}
	public String getGoods_unit() {
		return goods_unit;
	}
	public void setGoods_unit(String goods_unit) {
		this.goods_unit = goods_unit;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBuy_id() {
		return buy_id;
	}
	public void setBuy_id(String buy_id) {
		this.buy_id = buy_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
