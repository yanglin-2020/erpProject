package com.xt.pojo;

import java.io.Serializable;

/**
 *  生产工序过程记录实体类
 *
 * @author makejava
 * @since 2020-04-17 10:35:18
 */
public class MProceduring implements Serializable {
    private static final long serialVersionUID = -79630538778011123L;
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
    //本次工时数
    private Object labourHourAmount;
    //单位工时成本
    private Object costPrice;
    //工时成本小计
    private Object subtotal;
    //工序描述
    private String procedureDescribe;
    //登记次数
    private Object regCount;
    //负责人
    private String procedureResponsiblePerson;
    //登记人
    private String register;
    //登记时间
    private Object registerTime;
    //审核人
    private String checker;
    //审核时间
    private Object checkTime;


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

    public String getProcedureDescribe() {
        return procedureDescribe;
    }

    public void setProcedureDescribe(String procedureDescribe) {
        this.procedureDescribe = procedureDescribe;
    }

    public Object getRegCount() {
        return regCount;
    }

    public void setRegCount(Object regCount) {
        this.regCount = regCount;
    }

    public String getProcedureResponsiblePerson() {
        return procedureResponsiblePerson;
    }

    public void setProcedureResponsiblePerson(String procedureResponsiblePerson) {
        this.procedureResponsiblePerson = procedureResponsiblePerson;
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

    public String getChecker() {
        return checker;
    }

    public void setChecker(String checker) {
        this.checker = checker;
    }

    public Object getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Object checkTime) {
        this.checkTime = checkTime;
    }

}