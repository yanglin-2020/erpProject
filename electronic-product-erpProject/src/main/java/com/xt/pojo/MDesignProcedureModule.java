package com.xt.pojo;

import java.io.Serializable;

/**
 * 产品生产工序物料明细实体类
 *
 * @author makejava
 * @since 2020-04-17 10:35:17
 */
public class MDesignProcedureModule implements Serializable {
    private static final long serialVersionUID = 646847354107499086L;
    //序号
    private Integer id;
    //父级序号
    private Integer parentId;
    //工序物料序号
    private Integer detailsNumber;
    //物料编号
    private String productId;
    //物料名称
    private String productName;
    //用途类型
    private String type;
    //本工序数量
    private Object amount;
    //描述
    private String productDescribe;
    //单位
    private String amountUnit;
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

    public Object getAmount() {
        return amount;
    }

    public void setAmount(Object amount) {
        this.amount = amount;
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