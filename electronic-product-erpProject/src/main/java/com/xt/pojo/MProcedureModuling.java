package com.xt.pojo;

import java.io.Serializable;

/**
 * 生产工序物料过程记录实体类
 *
 * @author makejava
 * @since 2020-04-17 10:35:17
 */
public class MProcedureModuling implements Serializable {
    private static final long serialVersionUID = 793772593958000768L;
    //序号
    private Integer id;
    //父级序号
    private Integer parentId;
    //本工序物料序号
    private Integer detailsNumber;
    //产品编号
    private String productId;
    //产品名称
    private String productName;
    //单位物料成本
    private Object costPrice;
    //本次使用数量
    private Object amount;
    //物料成本小计
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

    public Object getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Object subtotal) {
        this.subtotal = subtotal;
    }

}