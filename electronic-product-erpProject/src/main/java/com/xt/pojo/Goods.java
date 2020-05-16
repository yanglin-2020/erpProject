package com.xt.pojo;

public class Goods {
	private String goods_id;
	private String goods_name;
	private String goods_num;
	private double goods_price;
	private String type;
	private String goods_unit;
	private String goods_desc;
	private String goods_time;
	private String supplier_ID;
	private String imgName;
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
	public double getGoods_price() {
		return goods_price;
	}
	public void setGoods_price(double goods_price) {
		this.goods_price = goods_price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getGoods_unit() {
		return goods_unit;
	}
	public void setGoods_unit(String goods_unit) {
		this.goods_unit = goods_unit;
	}
	public String getGoods_desc() {
		return goods_desc;
	}
	public void setGoods_desc(String goods_desc) {
		this.goods_desc = goods_desc;
	}
	public String getGoods_time() {
		return goods_time;
	}
	public void setGoods_time(String goods_time) {
		this.goods_time = goods_time;
	}
	public String getSupplier_ID() {
		return supplier_ID;
	}
	public void setSupplier_ID(String supplier_ID) {
		this.supplier_ID = supplier_ID;
	}
	public String getImgName() {
		return imgName;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	public Goods() {
		super();
	}
	public Goods(String goods_id, String goods_name, String goods_num, double goods_price, String goods_unit,
			String goods_desc, String supplier_ID) {
		super();
		this.goods_id = goods_id;
		this.goods_name = goods_name;
		this.goods_num = goods_num;
		this.goods_price = goods_price;
		this.goods_unit = goods_unit;
		this.goods_desc = goods_desc;
		this.supplier_ID = supplier_ID;
	}
}
