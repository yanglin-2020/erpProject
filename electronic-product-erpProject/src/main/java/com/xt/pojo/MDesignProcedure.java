package com.xt.pojo;

import java.io.Serializable;

/**
 * 产品生产工序实体类
 *
 * @author makejava
 * @since 2020-04-17 10:35:17
 */
public class MDesignProcedure implements Serializable {
    //序号
    private Integer id;
    //设计编号
    private String designId;
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
    //产品编号
    private String productId;
    //产品名称
    private String productName;
    //设计要求
    private String procedureDescribe;
    //工时总成本
    private Object costPriceSum;
    //物料总成本
    private Object moduleCostPriceSum;
    //设计人
    private String designer;
    //登记人
    private String register;
    //登记时间
    private Object registerTime;
    //复核人
    private String checker;
    //审核时间
    private Object checkTime;
    //审核意见
    private String checkSuggestion;
    //审核标志   S001-0: 等待审核     S001-1: 审核通过    S001-2: 审核不通过
    private String checkTag;
    //变更人
    private String changer;
    //变更时间
    private Object changeTime;
    //变更标志
    private String changeTag;
    //工序物料设计标志   G002-0: 未设计    G002-1: 已提交   G002-2: 已审核
    private String designModuleTag;
    //工序物料变更标志    G003-0: 未变更     G003-1: 已变更
    private String designModuleChangeTag;


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

    public String getProcedureDescribe() {
        return procedureDescribe;
    }

    public void setProcedureDescribe(String procedureDescribe) {
        this.procedureDescribe = procedureDescribe;
    }

    public Object getCostPriceSum() {
        return costPriceSum;
    }

    public void setCostPriceSum(Object costPriceSum) {
        this.costPriceSum = costPriceSum;
    }

    public Object getModuleCostPriceSum() {
        return moduleCostPriceSum;
    }

    public void setModuleCostPriceSum(Object moduleCostPriceSum) {
        this.moduleCostPriceSum = moduleCostPriceSum;
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

    public String getCheckSuggestion() {
        return checkSuggestion;
    }

    public void setCheckSuggestion(String checkSuggestion) {
        this.checkSuggestion = checkSuggestion;
    }

    public String getCheckTag() {
        return checkTag;
    }

    public void setCheckTag(String checkTag) {
        this.checkTag = checkTag;
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

    public String getChangeTag() {
        return changeTag;
    }

    public void setChangeTag(String changeTag) {
        this.changeTag = changeTag;
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