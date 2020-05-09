package com.xt.pojo;

import java.io.Serializable;

/**
 * 出库明细实体类
 *
 * @author long
 */
public class SPayDetails implements Serializable {
    //序号
    private Integer id;
    //父级序号
    private Integer parent_id;
    //产品编号
    private String product_id;
    //产品名称
    private String product_name;
    //描述
    private String product_describe;
    //数量
    private Integer amount;
    //单位
    private String amount_unit;
    //单价
    private Object cost_price;
    //小计
    private double subtotal;
    //确认出库件数
    private Object paid_amount;
    //出库标志   K002-1: 已登记   K002-2: 已调度
    private String pay_tag;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getParent_id() {
		return parent_id;
	}
	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
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
	public String getProduct_describe() {
		return product_describe;
	}
	public void setProduct_describe(String product_describe) {
		this.product_describe = product_describe;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getAmount_unit() {
		return amount_unit;
	}
	public void setAmount_unit(String amount_unit) {
		this.amount_unit = amount_unit;
	}
	public Object getCost_price() {
		return cost_price;
	}
	public void setCost_price(Object cost_price) {
		this.cost_price = cost_price;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public Object getPaid_amount() {
		return paid_amount;
	}
	public void setPaid_amount(Object paid_amount) {
		this.paid_amount = paid_amount;
	}
	public String getPay_tag() {
		return pay_tag;
	}
	public void setPay_tag(String pay_tag) {
		this.pay_tag = pay_tag;
	}
    
}