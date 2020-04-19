package com.xt.pojo;

import java.io.Serializable;

/**
 * 生产工序物料表实体类
 *
 * @author makejava
 * @since 2020-04-17 10:35:17
 */
public class MProcedureModule implements Serializable {
    private static final long serialVersionUID = -37482235524467547L;
    //序号
    private Integer id;
    //父级序号
    private Integer parentId;
    //工序物料序号
    private Integer detailsNumber;
    //产品编号
    private String productId;
    //产品名称
    private String productName;
    //物料单价
    private Object costPrice;
    //设计数量
    private Object amount;
    //已从库存领料数量
    private Object renewAmount;
    //实际使用数量
    private Object realAmount;
    //设计物料成本小计
    private Object subtotal;
    //实际物料成本小计
    private Object realSubtotal;


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

    public Object getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Object costPrice) {
        this.costPrice = costPrice;
    }

    public Object getAmount() {
        return amount;
    }

    public void setAmount(Object amount) {
        this.amount = amount;
    }

    public Object getRenewAmount() {
        return renewAmount;
    }

    public void setRenewAmount(Object renewAmount) {
        this.renewAmount = renewAmount;
    }

    public Object getRealAmount() {
        return realAmount;
    }

    public void setRealAmount(Object realAmount) {
        this.realAmount = realAmount;
    }

    public Object getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Object subtotal) {
        this.subtotal = subtotal;
    }

    public Object getRealSubtotal() {
        return realSubtotal;
    }

    public void setRealSubtotal(Object realSubtotal) {
        this.realSubtotal = realSubtotal;
    }

}