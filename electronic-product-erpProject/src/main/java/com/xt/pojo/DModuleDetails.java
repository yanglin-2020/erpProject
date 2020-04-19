package com.xt.pojo;

import java.io.Serializable;

/**
 * 产品物理组成明细实体类
 *
 * @author makejava
 * @since 2020-04-17 10:35:17
 */
public class DModuleDetails implements Serializable {
    private static final long serialVersionUID = -62915470413774120L;
    //序号
    private Integer id;
    //父级序号
    private Integer parentId;
    //物料序号
    private Integer detailsNumber;
    //物料编号
    private String productId;
    //物料名称
    private String productName;
    //用途类型
    private String type;
    //描述
    private String productDescribe;
    //单位
    private String amountUnit;
    //数量
    private Object amount;
    //可用数量
    private Object residualAmount;
    //单价
    private Object costPrice;
    //小计
    private Object subtotal;


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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProductDescribe() {
        return productDescribe;
    }

    public void setProductDescribe(String productDescribe) {
        this.productDescribe = productDescribe;
    }

    public String getAmountUnit() {
        return amountUnit;
    }

    public void setAmountUnit(String amountUnit) {
        this.amountUnit = amountUnit;
    }

    public Object getAmount() {
        return amount;
    }

    public void setAmount(Object amount) {
        this.amount = amount;
    }

    public Object getResidualAmount() {
        return residualAmount;
    }

    public void setResidualAmount(Object residualAmount) {
        this.residualAmount = residualAmount;
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

}