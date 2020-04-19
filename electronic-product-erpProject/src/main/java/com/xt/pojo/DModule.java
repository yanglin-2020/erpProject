package com.xt.pojo;

import java.io.Serializable;

/**
 * 产品物理组成实体类
 *
 * @author makejava
 * @since 2020-04-17 10:35:17
 */
public class DModule implements Serializable {
    private static final long serialVersionUID = -55640476932053956L;
    //序号
    private Integer id;
    //设计编号
    private String designId;
    //产品编号
    private String productId;
    //产品名称
    private String productName;
    //产品I级分类编号
    private String firstKindId;
    //产品I级分类名称
    private String firstKindName;
    //产品II级分类编号
    private String secondKindId;
    //产品II级分类名称
    private String secondKindName;
    //产品III级分类编号
    private String thirdKindId;
    //产品III级分类名称
    private String thirdKindName;
    //设计人
    private String designer;
    //设计要求
    private String moduleDescribe;
    //物料总成本
    private Object costPriceSum;
    //登记人
    private String register;
    //登记时间
    private Object registerTime;
    //复核人
    private String checker;
    //复核时间
    private Object checkTime;
    //变更人
    private String changer;
    //变更时间
    private Object changeTime;
    //审核标志    S001-0: 等待审核   S001-1: 审核通过    S001-2: 审核不通过
    private String checkTag;
    //变更标志    B002-0: 未变更     B002-1: 已变更
    private String changeTag;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesignId() {
        return designId;
    }

    public void setDesignId(String designId) {
        this.designId = designId;
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

    public String getFirstKindId() {
        return firstKindId;
    }

    public void setFirstKindId(String firstKindId) {
        this.firstKindId = firstKindId;
    }

    public String getFirstKindName() {
        return firstKindName;
    }

    public void setFirstKindName(String firstKindName) {
        this.firstKindName = firstKindName;
    }

    public String getSecondKindId() {
        return secondKindId;
    }

    public void setSecondKindId(String secondKindId) {
        this.secondKindId = secondKindId;
    }

    public String getSecondKindName() {
        return secondKindName;
    }

    public void setSecondKindName(String secondKindName) {
        this.secondKindName = secondKindName;
    }

    public String getThirdKindId() {
        return thirdKindId;
    }

    public void setThirdKindId(String thirdKindId) {
        this.thirdKindId = thirdKindId;
    }

    public String getThirdKindName() {
        return thirdKindName;
    }

    public void setThirdKindName(String thirdKindName) {
        this.thirdKindName = thirdKindName;
    }

    public String getDesigner() {
        return designer;
    }

    public void setDesigner(String designer) {
        this.designer = designer;
    }

    public String getModuleDescribe() {
        return moduleDescribe;
    }

    public void setModuleDescribe(String moduleDescribe) {
        this.moduleDescribe = moduleDescribe;
    }

    public Object getCostPriceSum() {
        return costPriceSum;
    }

    public void setCostPriceSum(Object costPriceSum) {
        this.costPriceSum = costPriceSum;
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

    public String getChanger() {
        return changer;
    }

    public void setChanger(String changer) {
        this.changer = changer;
    }

    public Object getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(Object changeTime) {
        this.changeTime = changeTime;
    }

    public String getCheckTag() {
        return checkTag;
    }

    public void setCheckTag(String checkTag) {
        this.checkTag = checkTag;
    }

    public String getChangeTag() {
        return changeTag;
    }

    public void setChangeTag(String changeTag) {
        this.changeTag = changeTag;
    }

}