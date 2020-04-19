package com.xt.pojo;

import java.io.Serializable;

/**
 * 产品档案实体类
 *
 * @author makejava
 * @since 2020-04-17 10:35:17
 */
public class DFile implements Serializable {
    private static final long serialVersionUID = 738065929038968895L;
    //序号
    private Integer id;
    //产品编号
    private String productId;
    //产品名称
    private String productName;
    //制作商
    private String factoryName;
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
    //产品简称
    private String productNick;
    //用途类型    Y001-1: 商品       Y001-2: 物料
    private String type;
    //档次级别    D001-1: 高档    D001-2: 中档    D001-3: 低档
    private String productClass;
    //计量单位
    private String personalUnit;
    //计量值
    private String personalValue;
    //供应商集合
    private String providerGroup;
    //保修期
    private String warranty;
    //替代品名称
    private String twinName;
    //替代品编号
    private String twinId;
    //生命周期
    private String lifecycle;
    //市场单价
    private Object listPrice;
    //计划成本单价
    private Object costPrice;
    //成本单价
    private Object realCostPrice;
    //单位
    private String amountUnit;
    //产品描述
    private String productDescribe;
    //产品经理
    private String responsiblePerson;
    //登记人
    private String register;
    //建档时间
    private Object registerTime;
    //复核人
    private String checker;
    //复核时间
    private Object checkTime;
    //审核标志    S001-0: 等待审核   S001-1: 审核通过    S001-2: 审核不通过
    private String checkTag;
    //变更人
    private String changer;
    //变更时间
    private Object changeTime;
    //档案变更标志   D002-0: 未变更    D002-1: 已变更
    private String changeTag;
    //价格变更标志   J001-0：未变更    J001-1：已变更
    private String priceChangeTag;
    //档案变更累计
    private Integer fileChangeAmount;
    //产品删除标志   C001-0: 未删除     C001-1: 已删除
    private String deleteTag;
    //物料组成标志   W001-0: 未设计    W001-1: 已设计
    private String designModuleTag;
    //工序组成标志   G001-0: 未设计    G001-1: 已设计
    private String designProcedureTag;
    //库存分配标志   K001-0: 未设计    K001-1: 已设计
    private String designCellTag;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
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

    public String getProductNick() {
        return productNick;
    }

    public void setProductNick(String productNick) {
        this.productNick = productNick;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProductClass() {
        return productClass;
    }

    public void setProductClass(String productClass) {
        this.productClass = productClass;
    }

    public String getPersonalUnit() {
        return personalUnit;
    }

    public void setPersonalUnit(String personalUnit) {
        this.personalUnit = personalUnit;
    }

    public String getPersonalValue() {
        return personalValue;
    }

    public void setPersonalValue(String personalValue) {
        this.personalValue = personalValue;
    }

    public String getProviderGroup() {
        return providerGroup;
    }

    public void setProviderGroup(String providerGroup) {
        this.providerGroup = providerGroup;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public String getTwinName() {
        return twinName;
    }

    public void setTwinName(String twinName) {
        this.twinName = twinName;
    }

    public String getTwinId() {
        return twinId;
    }

    public void setTwinId(String twinId) {
        this.twinId = twinId;
    }

    public String getLifecycle() {
        return lifecycle;
    }

    public void setLifecycle(String lifecycle) {
        this.lifecycle = lifecycle;
    }

    public Object getListPrice() {
        return listPrice;
    }

    public void setListPrice(Object listPrice) {
        this.listPrice = listPrice;
    }

    public Object getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Object costPrice) {
        this.costPrice = costPrice;
    }

    public Object getRealCostPrice() {
        return realCostPrice;
    }

    public void setRealCostPrice(Object realCostPrice) {
        this.realCostPrice = realCostPrice;
    }

    public String getAmountUnit() {
        return amountUnit;
    }

    public void setAmountUnit(String amountUnit) {
        this.amountUnit = amountUnit;
    }

    public String getProductDescribe() {
        return productDescribe;
    }

    public void setProductDescribe(String productDescribe) {
        this.productDescribe = productDescribe;
    }

    public String getResponsiblePerson() {
        return responsiblePerson;
    }

    public void setResponsiblePerson(String responsiblePerson) {
        this.responsiblePerson = responsiblePerson;
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

    public String getPriceChangeTag() {
        return priceChangeTag;
    }

    public void setPriceChangeTag(String priceChangeTag) {
        this.priceChangeTag = priceChangeTag;
    }

    public Integer getFileChangeAmount() {
        return fileChangeAmount;
    }

    public void setFileChangeAmount(Integer fileChangeAmount) {
        this.fileChangeAmount = fileChangeAmount;
    }

    public String getDeleteTag() {
        return deleteTag;
    }

    public void setDeleteTag(String deleteTag) {
        this.deleteTag = deleteTag;
    }

    public String getDesignModuleTag() {
        return designModuleTag;
    }

    public void setDesignModuleTag(String designModuleTag) {
        this.designModuleTag = designModuleTag;
    }

    public String getDesignProcedureTag() {
        return designProcedureTag;
    }

    public void setDesignProcedureTag(String designProcedureTag) {
        this.designProcedureTag = designProcedureTag;
    }

    public String getDesignCellTag() {
        return designCellTag;
    }

    public void setDesignCellTag(String designCellTag) {
        this.designCellTag = designCellTag;
    }

}