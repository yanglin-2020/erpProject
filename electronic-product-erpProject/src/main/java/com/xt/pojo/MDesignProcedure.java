package com.xt.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 产品生产工序实体类
 *LWT
 * @author makejava
 * @since 2020-04-17 10:35:17
 */
public class MDesignProcedure implements Serializable {
    //序号
    private Integer id;
    //设计编号
    private String design_Id;
    //产品I级分类编号
    private String first_Kind_Id;
    //产品I级分类名称
    private String first_Kind_Name;
    //产品编号
    private String product_Id;
    //产品名称
    private String product_Name;
    //设计要求
    private String procedure_Describe;
    //工时总成本
    private Object cost_Price_Sum;
    //物料总成本
    private int module_Cost_Price_Sum;
    //设计人
    private String designer;
    //登记人
    private String register;
    //登记时间
    private String register_Time;
    //复核人
    private String checker;
    //审核时间
    private String check_Time;
    //审核意见
    private String check_Suggestion;
    //审核标志   S001-0: 等待审核     S001-1: 审核通过    S001-2: 审核不通过
    private String check_Tag;
    //变更人
    private String changer;
    //变更时间
    private Object change_Time;
    //变更标志B002-0: 未变更  B002-1: 已变更
    private String change_Tag;
    //工序物料设计标志   G002-0: 未设计    G002-1: 已提交   G002-2: 已审核
    private String design_Module_Tag;
    //工序物料变更标志    G003-0: 未变更     G003-1: 已变更
    private String design_Module_Change_Tag;
    
    private List<MDesignProcedureDetails> listMdes;
    
	public List<MDesignProcedureDetails> getListMdes() {
		return listMdes;
	}
	public void setListMdes(List<MDesignProcedureDetails> listMdes) {
		this.listMdes = listMdes;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDesign_Id() {
		return design_Id;
	}
	public void setDesign_Id(String design_Id) {
		this.design_Id = design_Id;
	}
	public String getFirst_Kind_Id() {
		return first_Kind_Id;
	}
	public void setFirst_Kind_Id(String first_Kind_Id) {
		this.first_Kind_Id = first_Kind_Id;
	}
	public String getFirst_Kind_Name() {
		return first_Kind_Name;
	}
	public void setFirst_Kind_Name(String first_Kind_Name) {
		this.first_Kind_Name = first_Kind_Name;
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
	public String getProcedure_Describe() {
		return procedure_Describe;
	}
	public void setProcedure_Describe(String procedure_Describe) {
		this.procedure_Describe = procedure_Describe;
	}
	public Object getCost_Price_Sum() {
		return cost_Price_Sum;
	}
	public void setCost_Price_Sum(Object cost_Price_Sum) {
		this.cost_Price_Sum = cost_Price_Sum;
	}
	public int getModule_Cost_Price_Sum() {
		return module_Cost_Price_Sum;
	}
	public void setModule_Cost_Price_Sum(int module_Cost_Price_Sum) {
		this.module_Cost_Price_Sum = module_Cost_Price_Sum;
	}
	public String getDesigner() {
		return designer;
	}
	public void setDesigner(String designer) {
		this.designer = designer;
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
	public String getChecker() {
		return checker;
	}
	public void setChecker(String checker) {
		this.checker = checker;
	}
	public String getCheck_Time() {
		return check_Time;
	}
	public void setCheck_Time(String check_Time) {
		this.check_Time = check_Time;
	}
	public String getCheck_Suggestion() {
		return check_Suggestion;
	}
	public void setCheck_Suggestion(String check_Suggestion) {
		this.check_Suggestion = check_Suggestion;
	}
	public String getCheck_Tag() {
		return check_Tag;
	}
	public void setCheck_Tag(String check_Tag) {
		this.check_Tag = check_Tag;
	}
	public String getChanger() {
		return changer;
	}
	public void setChanger(String changer) {
		this.changer = changer;
	}
	public Object getChange_Time() {
		return change_Time;
	}
	public void setChange_Time(Object change_Time) {
		this.change_Time = change_Time;
	}
	public String getChange_Tag() {
		return change_Tag;
	}
	public void setChange_Tag(String change_Tag) {
		this.change_Tag = change_Tag;
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
	public MDesignProcedure() {
		super();
	}
	
	@Override
	public String toString() {
		return "MDesignProcedure [id=" + id + ", design_Id=" + design_Id + ", first_Kind_Id=" + first_Kind_Id
				+ ", first_Kind_Name=" + first_Kind_Name + ", product_Id=" + product_Id + ", product_Name="
				+ product_Name + ", procedure_Describe=" + procedure_Describe + ", cost_Price_Sum=" + cost_Price_Sum
				+ ", module_Cost_Price_Sum=" + module_Cost_Price_Sum + ", designer=" + designer + ", register="
				+ register + ", register_Time=" + register_Time + ", checker=" + checker + ", check_Time=" + check_Time
				+ ", check_Suggestion=" + check_Suggestion + ", check_Tag=" + check_Tag + ", changer=" + changer
				+ ", change_Time=" + change_Time + ", change_Tag=" + change_Tag + ", design_Module_Tag="
				+ design_Module_Tag + ", design_Module_Change_Tag=" + design_Module_Change_Tag + ", listMdes="
				+ listMdes + "]";
	}
	public MDesignProcedure(Integer id, String design_Id, String first_Kind_Id, String first_Kind_Name,
			String product_Id, String product_Name, String procedure_Describe, Object cost_Price_Sum,
			int module_Cost_Price_Sum, String designer, String register, String register_Time, String checker,
			String check_Time, String check_Suggestion, String check_Tag, String changer, Object change_Time,
			String change_Tag, String design_Module_Tag, String design_Module_Change_Tag) {
		super();
		this.id = id;
		this.design_Id = design_Id;
		this.first_Kind_Id = first_Kind_Id;
		this.first_Kind_Name = first_Kind_Name;
		this.product_Id = product_Id;
		this.product_Name = product_Name;
		this.procedure_Describe = procedure_Describe;
		this.cost_Price_Sum = cost_Price_Sum;
		this.module_Cost_Price_Sum = module_Cost_Price_Sum;
		this.designer = designer;
		this.register = register;
		this.register_Time = register_Time;
		this.checker = checker;
		this.check_Time = check_Time;
		this.check_Suggestion = check_Suggestion;
		this.check_Tag = check_Tag;
		this.changer = changer;
		this.change_Time = change_Time;
		this.change_Tag = change_Tag;
		this.design_Module_Tag = design_Module_Tag;
		this.design_Module_Change_Tag = design_Module_Change_Tag;
	}



}