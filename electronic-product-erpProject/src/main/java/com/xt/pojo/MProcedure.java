package com.xt.pojo;

import java.io.Serializable;

/**
 * 生产工序实体类
 *
 * @author makejava
 * @since 2020-04-17 10:35:17
 */
public class MProcedure implements Serializable {
    private static final long serialVersionUID = -12339981787275587L;
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
    //设计工时数
    private Object labour_Hour_Amount;
    //实际工时数
    private Object realLabour_Hour_Amount;
    //设计工时成本
    private Object subtotal;
    //实际工时成本-
    private Object real_Subtotal;
    //设计物料成本
    private Object module_Subtotal;
    //实际物料成本
    private Object real_Module_Subtotal;
    //单位工时成本
    private Object cost_Price;
    //工序投产数量
    private Object demand_Amount;
    //工序合格数量
    private Object real_Amount;
    //工序完成标志   G004-0: 未开始   G004-1: 已完成   G004-2: 未完成  G004-3: 已审核
    private String procedure_Finish_Tag;
    //工序交接标志   G005-0: 未交接   G005-1: 已交接   G005-2: 已审核
    private String procedure_Transfer_Tag;
	@Override
	public String toString() {
		return "MProcedure [id=" + id + ", parent_Id=" + parent_Id + ", details_Number=" + details_Number
				+ ", procedure_Id=" + procedure_Id + ", procedure_Name=" + procedure_Name + ", labour_Hour_Amount="
				+ labour_Hour_Amount + ", realLabour_Hour_Amount=" + realLabour_Hour_Amount + ", subtotal=" + subtotal
				+ ", real_Subtotal=" + real_Subtotal + ", module_Subtotal=" + module_Subtotal
				+ ", real_Module_Subtotal=" + real_Module_Subtotal + ", cost_Price=" + cost_Price + ", demand_Amount="
				+ demand_Amount + ", real_Amount=" + real_Amount + ", procedure_Finish_Tag=" + procedure_Finish_Tag
				+ ", procedure_Transfer_Tag=" + procedure_Transfer_Tag + "]";
	}
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
	public Object getRealLabour_Hour_Amount() {
		return realLabour_Hour_Amount;
	}
	public void setRealLabour_Hour_Amount(Object realLabour_Hour_Amount) {
		this.realLabour_Hour_Amount = realLabour_Hour_Amount;
	}
	public Object getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Object subtotal) {
		this.subtotal = subtotal;
	}
	public Object getReal_Subtotal() {
		return real_Subtotal;
	}
	public void setReal_Subtotal(Object real_Subtotal) {
		this.real_Subtotal = real_Subtotal;
	}
	public Object getModule_Subtotal() {
		return module_Subtotal;
	}
	public void setModule_Subtotal(Object module_Subtotal) {
		this.module_Subtotal = module_Subtotal;
	}
	public Object getReal_Module_Subtotal() {
		return real_Module_Subtotal;
	}
	public void setReal_Module_Subtotal(Object real_Module_Subtotal) {
		this.real_Module_Subtotal = real_Module_Subtotal;
	}
	public Object getCost_Price() {
		return cost_Price;
	}
	public void setCost_Price(Object cost_Price) {
		this.cost_Price = cost_Price;
	}
	public Object getDemand_Amount() {
		return demand_Amount;
	}
	public void setDemand_Amount(Object demand_Amount) {
		this.demand_Amount = demand_Amount;
	}
	public Object getReal_Amount() {
		return real_Amount;
	}
	public void setReal_Amount(Object real_Amount) {
		this.real_Amount = real_Amount;
	}
	public String getProcedure_Finish_Tag() {
		return procedure_Finish_Tag;
	}
	public void setProcedure_Finish_Tag(String procedure_Finish_Tag) {
		this.procedure_Finish_Tag = procedure_Finish_Tag;
	}
	public String getProcedure_Transfer_Tag() {
		return procedure_Transfer_Tag;
	}
	public void setProcedure_Transfer_Tag(String procedure_Transfer_Tag) {
		this.procedure_Transfer_Tag = procedure_Transfer_Tag;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public MProcedure(Integer id, Integer parent_Id, Integer details_Number, String procedure_Id, String procedure_Name,
			Object labour_Hour_Amount, Object realLabour_Hour_Amount, Object subtotal, Object real_Subtotal,
			Object module_Subtotal, Object real_Module_Subtotal, Object cost_Price, Object demand_Amount,
			Object real_Amount, String procedure_Finish_Tag, String procedure_Transfer_Tag) {
		super();
		this.id = id;
		this.parent_Id = parent_Id;
		this.details_Number = details_Number;
		this.procedure_Id = procedure_Id;
		this.procedure_Name = procedure_Name;
		this.labour_Hour_Amount = labour_Hour_Amount;
		this.realLabour_Hour_Amount = realLabour_Hour_Amount;
		this.subtotal = subtotal;
		this.real_Subtotal = real_Subtotal;
		this.module_Subtotal = module_Subtotal;
		this.real_Module_Subtotal = real_Module_Subtotal;
		this.cost_Price = cost_Price;
		this.demand_Amount = demand_Amount;
		this.real_Amount = real_Amount;
		this.procedure_Finish_Tag = procedure_Finish_Tag;
		this.procedure_Transfer_Tag = procedure_Transfer_Tag;
	}
	public MProcedure() {
		super();
	}


}