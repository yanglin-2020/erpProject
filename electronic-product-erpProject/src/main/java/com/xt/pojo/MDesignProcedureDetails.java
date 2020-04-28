package com.xt.pojo;

import java.io.Serializable;

/**
 * 产品生产工序明细实体类
 *
 * @author makejava
 * @since 2020-04-17 10:35:17
 */
public class MDesignProcedureDetails implements Serializable {
    private static final long serialVersionUID = -82773682098904902L;
    
    //序号
    private Integer id;
    //父级序号
    private Integer parent_Id;
    //工序序号
    private Integer details_Number;
    //工序编号
    private String procedure_Id;
    //工序名称
    private String procedure_Name;
    //工时数
    private Object labour_Hour_Amount;
    //工序描述
    private String procedure_Describe;
    //单位
    private String amount_Unit;
    //单位工时成本
    private Object cost_Price;
    //工时成本小计
    private Object subtotal;
    //物料成本小计
    private Object module_Subtotal;
    //登记人
    private String register;
    //登记时间
    private String register_Time;
    //当前工序物料标志      D002-0: 未设计    D002-1: 已设计
    private String design_Module_Tag;
    //当前工序物料变更标志    D003-0: 未变更     D003-0: 已变更
    private String design_Module_Change_Tag;
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
	public String getProcedure_Id() {
		return procedure_Id;
	}
	public void setProcedure_Id(String procedure_Id) {
		this.procedure_Id = procedure_Id;
	}
	public String getProcedure_Name() {
		return procedure_Name;
	}
	public void setProcedure_Name(String procedure_Name) {
		this.procedure_Name = procedure_Name;
	}
	public Object getLabour_Hour_Amount() {
		return labour_Hour_Amount;
	}
	public void setLabour_Hour_Amount(Object labour_Hour_Amount) {
		this.labour_Hour_Amount = labour_Hour_Amount;
	}
	public String getProcedure_Describe() {
		return procedure_Describe;
	}
	public void setProcedure_Describe(String procedure_Describe) {
		this.procedure_Describe = procedure_Describe;
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
	public Object getModule_Subtotal() {
		return module_Subtotal;
	}
	public void setModule_Subtotal(Object module_Subtotal) {
		this.module_Subtotal = module_Subtotal;
	}
	public String getRegister() {
		return register;
	}
	public void setRegister(String register) {
		this.register = register;
	}
	public String getRegister_Time() {
		return register_Time;
	}
	public void setRegister_Time(String register_Time) {
		this.register_Time = register_Time;
	}
	public String getDesign_Module_Tag() {
		return design_Module_Tag;
	}
	public void setDesign_Module_Tag(String design_Module_Tag) {
		this.design_Module_Tag = design_Module_Tag;
	}
	public String getDesign_Module_Change_Tag() {
		return design_Module_Change_Tag;
	}
	public void setDesign_Module_Change_Tag(String design_Module_Change_Tag) {
		this.design_Module_Change_Tag = design_Module_Change_Tag;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "MDesignProcedureDetails [id=" + id + ", parent_Id=" + parent_Id + ", details_Number=" + details_Number
				+ ", procedure_Id=" + procedure_Id + ", procedure_Name=" + procedure_Name + ", labour_Hour_Amount="
				+ labour_Hour_Amount + ", procedure_Describe=" + procedure_Describe + ", amount_Unit=" + amount_Unit
				+ ", cost_Price=" + cost_Price + ", subtotal=" + subtotal + ", module_Subtotal=" + module_Subtotal
				+ ", register=" + register + ", register_Time=" + register_Time + ", design_Module_Tag="
				+ design_Module_Tag + ", design_Module_Change_Tag=" + design_Module_Change_Tag + "]";
	}



}