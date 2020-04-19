package com.xt.pojo;

import java.io.Serializable;

/**
 * 库存单元实体类
 *
 * @author makejava
 * @since 2020-04-17 10:35:18
 */
public class SCell implements Serializable {
    private static final long serialVersionUID = 879536020135324498L;
    //序号
    private Integer id;
    //库存编号
    private String storeId;
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
    //库存报警下限数
    private Object minAmount;
    //库存报警上限数
    private Object maxAmount;
    //最大存储量
    private Object maxCapacityAmount;
    //当前存储量
    private Object amount;
    //配置要求
    private String config;
    //登记人
    private String register;
    //登记时间
    private Object registerTime;
    //复核人
    private String checker;
    //复核时间
    private Object checkTime;
    //审核标志
    private String checkTag;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
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

    public Object getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(Object minAmount) {
        this.minAmount = minAmount;
    }

    public Object getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(Object maxAmount) {
        this.maxAmount = maxAmount;
    }

    public Object getMaxCapacityAmount() {
        return maxCapacityAmount;
    }

    public void setMaxCapacityAmount(Object maxCapacityAmount) {
        this.maxCapacityAmount = maxCapacityAmount;
    }

    public Object getAmount() {
        return amount;
    }

    public void setAmount(Object amount) {
        this.amount = amount;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
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

}