package com.xt.pojo;

import java.io.Serializable;

/**
 * 产品物料组成明细实体类
 * 
 * @author yl
 */
public class DModuleDetails implements Serializable {
	private int id;// 序号
	private String parent_id;// 父级序号(产品单号，外键)
	private String details_number;// 物料序号
	private String product_id;// 物料编号
	private String product_name;// 物料名称
	private String type;// 用途类型
	private String product_describe;// 描述
	private String amount_unit;// 单位
	private int amount;// 数量
	private int residual_amount;// 可用数量
	private double cost_price;// 单价
	private double subtotal;// 小计
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getParent_id() {
		return parent_id;
	}
	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}
	public String getDetails_number() {
		return details_number;
	}
	public void setDetails_number(String details_number) {
		this.details_number = details_number;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getProduct_describe() {
		return product_describe;
	}
	public void setProduct_describe(String product_describe) {
		this.product_describe = product_describe;
	}
	public String getAmount_unit() {
		return amount_unit;
	}
	public void setAmount_unit(String amount_unit) {
		this.amount_unit = amount_unit;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getResidual_amount() {
		return residual_amount;
	}
	public void setResidual_amount(int residual_amount) {
		this.residual_amount = residual_amount;
	}
	public double getCost_price() {
		return cost_price;
	}
	public void setCost_price(double cost_price) {
		this.cost_price = cost_price;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public DModuleDetails() {
		super();
	}
	public DModuleDetails(String parent_id, String product_id, String product_name, String type,
			String product_describe, String amount_unit, int amount, double cost_price, double subtotal) {
		super();
		this.parent_id = parent_id;
		this.product_id = product_id;
		this.product_name = product_name;
		this.type = type;
		this.product_describe = product_describe;
		this.amount_unit = amount_unit;
		this.amount = amount;
		this.cost_price = cost_price;
		this.subtotal = subtotal;
	}
}