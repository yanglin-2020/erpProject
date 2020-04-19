package com.xt.pojo;

import java.io.Serializable;

/**
 * 出库明细实体类
 *
 * @author makejava
 * @since 2020-04-17 10:35:18
 */
public class SPayDetails implements Serializable {
    private static final long serialVersionUID = -35134247554177231L;
    //序号
    private Integer id;
    //父级序号
    private Integer parentId;
    //产品编号
    private String productId;
    //产品名称
    private String productName;
    //描述
    private String productDescribe;
    //数量
    private Object amount;
    //单位
    private String amountUnit;
    //单价
    private Object costPrice;
    //小计
    private Object subtotal;
    //确认出库件数
    private Object paidAmount;
    //出库标志   K002-1: 已登记   K002-2: 已调度
    private String payTag;


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

    public Object getAmount() {
        return amount;
    }

    public void setAmount(Object amount) {
        this.amount = amount;
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

    public Object getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Object paidAmount) {
        this.paidAmount = paidAmount;
    }

    public String getPayTag() {
        return payTag;
    }

    public void setPayTag(String payTag) {
        this.payTag = payTag;
    }

}