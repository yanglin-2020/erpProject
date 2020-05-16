package com.xt.pojo;

public class Invoice_detail {
	private Integer id;
	private String des_id;//父级id
	private String 	product_name;//商品名称
	private Double cost_price;//商品价格
	private Integer cost_num;//商品数量
	private Double subtotal;//小计
	private String cost_time;//购买时间
	
	public String getCost_time() {
		return cost_time;
	}
	public void setCost_time(String cost_time) {
		this.cost_time = cost_time;
	}
	@Override
	public String toString() {
		return "Invoice_detail [id=" + id + ", des_id=" + des_id + ", product_name=" + product_name + ", cost_price="
				+ cost_price + ", cost_num=" + cost_num + ", subtotal=" + subtotal + ", cost_time=" + cost_time + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getDes_id() {
		return des_id;
	}
	public void setDes_id(String des_id) {
		this.des_id = des_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public Double getCost_price() {
		return cost_price;
	}
	public void setCost_price(Double cost_price) {
		this.cost_price = cost_price;
	}
	public Integer getCost_num() {
		return cost_num;
	}
	public void setCost_num(Integer cost_num) {
		this.cost_num = cost_num;
	}
	public Double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}
	

}
