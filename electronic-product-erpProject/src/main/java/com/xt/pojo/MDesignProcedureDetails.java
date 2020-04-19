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
    private Integer parentId;
    //工序序号
    private Integer detailsNumber;
    //工序编号
    private String procedureId;
    //工序名称
    private String procedureName;
    //工时数
    private Object labourHourAmount;
    //工序描述
    private String procedureDescribe;
    //单位
    private String amountUnit;
    //单位工时成本
    private Object costPrice;
    //工时成本小计
    private Object subtotal;
    //物料成本小计
    private Object moduleSubtotal;
    //登记人
    private String register;
    //登记时间
    private Object registerTime;
    //当前工序物料标志      D002-0: 未设计    D002-1: 已设计
    private String designModuleTag;
    //当前工序物料变更标志    D003-0: 未变更     D003-0: 已变更
    private String designModuleChangeTag;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getDetailsNumber() {
        return detailsNumber;
    }

    public void setDetailsNumber(Integer detailsNumber) {
        this.detailsNumber = detailsNumber;
    }

    public String getProcedureId() {
        return procedureId;
    }

    public void setProcedureId(String procedureId) {
        this.procedureId = procedureId;
    }

    public String getProcedureName() {
        return procedureName;
    }

    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }

    public Object getLabourHourAmount() {
        return labourHourAmount;
    }

    public void setLabourHourAmount(Object labourHourAmount) {
        this.labourHourAmount = labourHourAmount;
    }

    public String getProcedureDescribe() {
        return procedureDescribe;
    }

    public void setProcedureDescribe(String procedureDescribe) {
        this.procedureDescribe = procedureDescribe;
    }

    public String getAmountUnit() {
        return amountUnit;
    }

    public void setAmountUnit(String amountUnit) {
        this.amountUnit = amountUnit;
    }

    public Object getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Object costPrice) {
        this.costPrice = costPrice;
    }

    public Object getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Object subtotal) {
        this.subtotal = subtotal;
    }

    public Object getModuleSubtotal() {
        return moduleSubtotal;
    }

    public void setModuleSubtotal(Object moduleSubtotal) {
        this.moduleSubtotal = moduleSubtotal;
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    public Object getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Object registerTime) {
        this.registerTime = registerTime;
    }

    public String getDesignModuleTag() {
        return designModuleTag;
    }

    public void setDesignModuleTag(String designModuleTag) {
        this.designModuleTag = designModuleTag;
    }

    public String getDesignModuleChangeTag() {
        return designModuleChangeTag;
    }

    public void setDesignModuleChangeTag(String designModuleChangeTag) {
        this.designModuleChangeTag = designModuleChangeTag;
    }

}