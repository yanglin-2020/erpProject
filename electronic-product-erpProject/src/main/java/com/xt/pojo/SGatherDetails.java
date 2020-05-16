package com.xt.pojo;

import java.io.Serializable;

/**
 * 入库明细实体类
 *
 * @author makejava
 * @since 2020-04-17 10:35:18
 */
public class SGatherDetails implements Serializable {
    //序号
    private Integer id;
    //父级序号
    private String parent_id;
    //产品编号
    private String product_id;
    //产品名称
    private String product_name;
    //描述
    private String product_describe;
    //数量
    private Object amount;
    //单位
    private String amount_unit;
    //单价
    private Object cost_price;
    //小计
    private Object subtotal;
    //确认入库件数
    private Object gathered_amount;
    //入库标志    K002-1: 已登记    K002-2: 已调度
    private String gather_tag;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getParent_id() {
		return parent_id;
	}
	public void setParent_id(String parent_id) {
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
	public Object getAmount() {
		return amount;
	}
	public void setAmount(Object amount) {
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
	public Object getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Object subtotal) {
		this.subtotal = subtotal;
	}
	public Object getGathered_amount() {
		return gathered_amount;
	}
	public void setGathered_amount(Object gathered_amount) {
		this.gathered_amount = gathered_amount;
	}
	public String getGather_tag() {
		return gather_tag;
	}
	public void setGather_tag(String gather_tag) {
		this.gather_tag = gather_tag;
	}
	public SGatherDetails() {
		super();
	}
	public SGatherDetails(String parent_id, String product_id, String product_name, String product_describe,
			Object amount, String amount_unit, Object cost_price, Object subtotal) {
		super();
		this.parent_id = parent_id;
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_describe = product_describe;
		this.amount = amount;
		this.amount_unit = amount_unit;
		this.cost_price = cost_price;
		this.subtotal = subtotal;
	}
	public SGatherDetails(String parent_id, String product_id, String product_name, String product_describe,
			Object amount, Object subtotal) {
		super();
		this.parent_id = parent_id;
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_describe = product_describe;
		this.amount = amount;
		this.subtotal = subtotal;
	}
}