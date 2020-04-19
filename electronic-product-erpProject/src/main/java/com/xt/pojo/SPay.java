package com.xt.pojo;

import java.io.Serializable;

/**
 * 出库实体类
 *
 * @author makejava
 * @since 2020-04-17 10:35:18
 */
public class SPay implements Serializable {
    private static final long serialVersionUID = 223316791023593913L;
    //序号
    private Integer id;
    //出库单编号
    private String payId;
    //出库人
    private String storer;
    //出库理由   C002-1: 生产领料   C002-2: 赠送   C002-3: 内部借领   C002-4: 其他借领
    private String reason;
    //出库详细理由
    private String reasonexact;
    //总件数
    private Object amountSum;
    //总金额
    private Object costPriceSum;
    //确认出库总件数
    private Object paidAmountSum;
    //备注
    private String remark;
    //登记人
    private String register;
    //登记时间
    private Object registerTime;
    //复核人
    private String checker;
    //复核时间
    private Object checkTime;
    //审核标志    S001-0: 等待审核    S001-1: 审核通过   S001-2: 审核不通过
    private String checkTag;
    //调度人
    private String attemper;
    //调度时间
    private Object attemperTime;
    //库存标志    K002-1: 已登记   K002-2: 已调度
    private String storeTag;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPayId() {
        return payId;
    }

    public void setPayId(String payId) {
        this.payId = payId;
    }

    public String getStorer() {
        return storer;
    }

    public void setStorer(String storer) {
        this.storer = storer;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getReasonexact() {
        return reasonexact;
    }

    public void setReasonexact(String reasonexact) {
        this.reasonexact = reasonexact;
    }

    public Object getAmountSum() {
        return amountSum;
    }

    public void setAmountSum(Object amountSum) {
        this.amountSum = amountSum;
    }

    public Object getCostPriceSum() {
        return costPriceSum;
    }

    public void setCostPriceSum(Object costPriceSum) {
        this.costPriceSum = costPriceSum;
    }

    public Object getPaidAmountSum() {
        return paidAmountSum;
    }

    public void setPaidAmountSum(Object paidAmountSum) {
        this.paidAmountSum = paidAmountSum;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public String getCheckTag() {
        return checkTag;
    }

    public void setCheckTag(String checkTag) {
        this.checkTag = checkTag;
    }

    public String getAttemper() {
        return attemper;
    }

    public void setAttemper(String attemper) {
        this.attemper = attemper;
    }

    public Object getAttemperTime() {
        return attemperTime;
    }

    public void setAttemperTime(Object attemperTime) {
        this.attemperTime = attemperTime;
    }

    public String getStoreTag() {
        return storeTag;
    }

    public void setStoreTag(String storeTag) {
        this.storeTag = storeTag;
    }

}