package com.xt.pojo;

import java.io.Serializable;

/**
 * 产品生产计划实体类
 *
 * @author makejava
 * @since 2020-04-17 10:35:17
 */
public class MApply implements Serializable {
    private static final long serialVersionUID = 311706657090918042L;
    //序号
    private Integer id;
    //生产计划编号
    private String applyId;
    //产品编号
    private String productId;
    //产品名称
    private String productName;
    //产品描述
    private String productDescribe;
    //用途类型
    private String type;
    //数量
    private Object amount;
    //设计人
    private String designer;
    //备注
    private String remark;
    //登记人
    private String register;
    //登记时间
    private Object registerTime;
    //复核人
    private String checker;
    //审核意见
    private String checkSuggestion;
    //审核时间
    private Object checkTime;
    //审核标志    S001-0: 等待审核    S001-1: 审核通过   S001-2: 审核不通过
    private String checkTag;
    //派工标志    P001-0: 未派工     P001-1: 已派工
    private String manufactureTag;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescribe() {
        return productDescribe;
    }

    public void setProductDescribe(String productDescribe) {
        this.productDescribe = productDescribe;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getAmount() {
        return amount;
    }

    public void setAmount(Object amount) {
        this.amount = amount;
    }

    public String getDesigner() {
        return designer;
    }

    public void setDesigner(String designer) {
        this.designer = designer;
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

    public String getCheckSuggestion() {
        return checkSuggestion;
    }

    public void setCheckSuggestion(String checkSuggestion) {
        this.checkSuggestion = checkSuggestion;
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

    public String getManufactureTag() {
        return manufactureTag;
    }

    public void setManufactureTag(String manufactureTag) {
        this.manufactureTag = manufactureTag;
    }

}