package com.xt.pojo;

import java.io.Serializable;

/**
 * 生产工序实体类
 *
 * @author makejava
 * @since 2020-04-17 10:35:17
 */
public class MProcedure implements Serializable {
    private static final long serialVersionUID = -12339981787275587L;
    //序号
    private Integer id;
    //父级序号
    private Integer parentId;
    //工序序号
    private Integer detailsNumber;
    //工序编号
    private String procedureId;
    //工序名称
    private String procedureName;
    //设计工时数
    private Object labourHourAmount;
    //实际工时数
    private Object realLabourHourAmount;
    //设计工时成本
    private Object subtotal;
    //实际工时成本
    private Object realSubtotal;
    //设计物料成本
    private Object moduleSubtotal;
    //实际物料成本
    private Object realModuleSubtotal;
    //单位工时成本
    private Object costPrice;
    //工序投产数量
    private Object demandAmount;
    //工序合格数量
    private Object realAmount;
    //工序完成标志   G004-0: 未开始   G004-1: 已完成   G004-2: 未完成  G004-3: 已审核
    private String procedureFinishTag;
    //工序交接标志   G005-0: 未交接   G005-1: 已交接   G005-2: 已审核
    private String procedureTransferTag;


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

    public String getProcedureId() {
        return procedureId;
    }

    public void setProcedureId(String procedureId) {
        this.procedureId = procedureId;
    }

    public String getProcedureName() {
        return procedureName;
    }

    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }

    public Object getLabourHourAmount() {
        return labourHourAmount;
    }

    public void setLabourHourAmount(Object labourHourAmount) {
        this.labourHourAmount = labourHourAmount;
    }

    public Object getRealLabourHourAmount() {
        return realLabourHourAmount;
    }

    public void setRealLabourHourAmount(Object realLabourHourAmount) {
        this.realLabourHourAmount = realLabourHourAmount;
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

    public Object getModuleSubtotal() {
        return moduleSubtotal;
    }

    public void setModuleSubtotal(Object moduleSubtotal) {
        this.moduleSubtotal = moduleSubtotal;
    }

    public Object getRealModuleSubtotal() {
        return realModuleSubtotal;
    }

    public void setRealModuleSubtotal(Object realModuleSubtotal) {
        this.realModuleSubtotal = realModuleSubtotal;
    }

    public Object getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Object costPrice) {
        this.costPrice = costPrice;
    }

    public Object getDemandAmount() {
        return demandAmount;
    }

    public void setDemandAmount(Object demandAmount) {
        this.demandAmount = demandAmount;
    }

    public Object getRealAmount() {
        return realAmount;
    }

    public void setRealAmount(Object realAmount) {
        this.realAmount = realAmount;
    }

    public String getProcedureFinishTag() {
        return procedureFinishTag;
    }

    public void setProcedureFinishTag(String procedureFinishTag) {
        this.procedureFinishTag = procedureFinishTag;
    }

    public String getProcedureTransferTag() {
        return procedureTransferTag;
    }

    public void setProcedureTransferTag(String procedureTransferTag) {
        this.procedureTransferTag = procedureTransferTag;
    }

}