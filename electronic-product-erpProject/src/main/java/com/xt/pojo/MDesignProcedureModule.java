package com.xt.pojo;

import java.io.Serializable;

/**
 * 产品生产工序物料明细实体类
 *LWT
 * @author makejava
 * @since 2020-04-17 10:35:17
 */
public class MDesignProcedureModule implements Serializable {
    private static final long serialVersionUID = 646847354107499086L;
    //序号
    private Integer id;
    //父级序号
    private Integer parent_Id;	
    //工序物料序号
    private Integer details_Number;
    //物料编号
    private String product_Id;
    //物料名称
    private String product_Name;
    //用途类型
    private String type;
    //本工序数量
    private int amount;
    //描述
    private String product_Describe;
    //单位
    private String amount_Unit;
    //单价
    private Object cost_Price;
    //小计
    private Object subtotal;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getParent_Id() {
		return parent_Id;
	}
	public void setParent_Id(Integer parent_Id) {
		this.parent_Id = parent_Id;
	}
	public Integer getDetails_Number() {
		return details_Number;
	}
	public void setDetails_Number(Integer details_Number) {
		this.details_Number = details_Number;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
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
	public Object getCost_Price() {
		return cost_Price;
	}
	public void setCost_Price(Object cost_Price) {
		this.cost_Price = cost_Price;
	}
	public Object getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Object subtotal) {
		this.subtotal = subtotal;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "MDesignProcedureModule [id=" + id + ", parent_Id=" + parent_Id + ", details_Number=" + details_Number
				+ ", product_Id=" + product_Id + ", product_Name=" + product_Name + ", type=" + type + ", amount="
				+ amount + ", product_Describe=" + product_Describe + ", amount_Unit=" + amount_Unit + ", cost_Price="
				+ cost_Price + ", subtotal=" + subtotal + "]";
	}
	public MDesignProcedureModule(Integer id, Integer parent_Id, Integer details_Number, String product_Id,
			String product_Name, String type, int amount, String product_Describe, String amount_Unit,
			Object cost_Price, Object subtotal) {
		super();
		this.id = id;
		this.parent_Id = parent_Id;
		this.details_Number = details_Number;
		this.product_Id = product_Id;
		this.product_Name = product_Name;
		this.type = type;
		this.amount = amount;
		this.product_Describe = product_Describe;
		this.amount_Unit = amount_Unit;
		this.cost_Price = cost_Price;
		this.subtotal = subtotal;
	}
	public MDesignProcedureModule() {
		super();
	}


}