package com.xt.pojo;

import java.io.Serializable;

/**
 * 出库明细实体类
 *
 * @author lwt
 * @since 2020-04-17 10:35:18
 */
public class SPayDetails implements Serializable {
    private static final long serialVersionUID = -35134247554177231L;
    //序号
    private Integer id;
    //父级序号
    private String parent_Id;
    //产品编号
    private String product_Id;
    //产品名称
    private String product_Name;
    //描述
    private String product_Describe;
    //数量
    private int amount;
    //单位
    private String amount_Unit;
    //单价
    private String cost_Price;
    //小计
    private String subtotal;
    //确认出库件数
    private int paid_Amount;
    //出库标志   K002-1: 已登记   K002-2: 已调度
    private String pay_Tag;
    
    private int shul;
    
    
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getShul() {
		return shul;
	}
	public void setShul(int shul) {
		this.shul = shul;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getParent_Id() {
		return parent_Id;
	}
	public void setParent_Id(String parent_Id) {
		this.parent_Id = parent_Id;
	}
	public String getProduct_Id() {
		return product_Id;
	}
	public void setProduct_Id(String product_Id) {
		this.product_Id = product_Id;
	}
	public String getProduct_Name() {
		return product_Name;
	}
	public void setProduct_Name(String product_Name) {
		this.product_Name = product_Name;
	}
	public String getProduct_Describe() {
		return product_Describe;
	}
	public void setProduct_Describe(String product_Describe) {
		this.product_Describe = product_Describe;
	}
	public String getAmount_Unit() {
		return amount_Unit;
	}
	public void setAmount_Unit(String amount_Unit) {
		this.amount_Unit = amount_Unit;
	}
	public String getCost_Price() {
		return cost_Price;
	}
	public void setCost_Price(String cost_Price) {
		this.cost_Price = cost_Price;
	}
	public String getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(String subtotal) {
		this.subtotal = subtotal;
	}
	public int getPaid_Amount() {
		return paid_Amount;
	}
	public void setPaid_Amount(int paid_Amount) {
		this.paid_Amount = paid_Amount;
	}
	public String getPay_Tag() {
		return pay_Tag;
	}
	public void setPay_Tag(String pay_Tag) {
		this.pay_Tag = pay_Tag;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "SPayDetails [id=" + id + ", parent_Id=" + parent_Id + ", product_Id=" + product_Id + ", product_Name="
				+ product_Name + ", product_Describe=" + product_Describe + ", amount=" + amount + ", amount_Unit="
				+ amount_Unit + ", cost_Price=" + cost_Price + ", subtotal=" + subtotal + ", paid_Amount=" + paid_Amount
				+ ", pay_Tag=" + pay_Tag + "]";
	}


    
}