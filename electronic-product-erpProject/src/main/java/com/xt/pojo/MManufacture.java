package com.xt.pojo;

import java.io.Serializable;

/**
 * 生产总表实体类
 *
 * @author makejava
 * @since 2020-04-17 10:35:17
 */
public class MManufacture implements Serializable {
    private static final long serialVersionUID = -27490427353250496L;
    //序号
    private Integer id;
    //派工单编号
    private String manufactureId;
    //产品编号
    private String productId;
    //产品名称
    private String productName;
    //投产数量
    private Object amount;
    //合格数量
    private Object testedAmount;
    //生产计划序号组
    private String applyIdGroup;
    //产品描述
    private String productDescribe;
    //设计物料总成本
    private Object moduleCostPriceSum;
    //实际物料总成本
    private Object realModuleCostPriceSum;
    //设计工时总成本
    private Object labourCostPriceSum;
    //实际工时总成本
    private Object realLabourCostPriceSum;
    //工单制定人
    private String designer;
    //登记人
    private String register;
    //登记时间
    private Object registerTime;
    //审核人
    private String checker;
    //审核时间
    private Object checkTime;
    //备注
    private String remark;
    //审核标志    S001-0: 等待审核   S001-1: 审核通过   S001-2: 审核不通过
    private String checkTag;
    //生产过程标志    S002-0: 待登记    S002-1: 未审核   S002-2: 已完工
    private String manufactureProcedureTag;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getManufactureId() {
        return manufactureId;
    }

    public void setManufactureId(String manufactureId) {
        this.manufactureId = manufactureId;
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

    public Object getAmount() {
        return amount;
    }

    public void setAmount(Object amount) {
        this.amount = amount;
    }

    public Object getTestedAmount() {
        return testedAmount;
    }

    public void setTestedAmount(Object testedAmount) {
        this.testedAmount = testedAmount;
    }

    public String getApplyIdGroup() {
        return applyIdGroup;
    }

    public void setApplyIdGroup(String applyIdGroup) {
        this.applyIdGroup = applyIdGroup;
    }

    public String getProductDescribe() {
        return productDescribe;
    }

    public void setProductDescribe(String productDescribe) {
        this.productDescribe = productDescribe;
    }

    public Object getModuleCostPriceSum() {
        return moduleCostPriceSum;
    }

    public void setModuleCostPriceSum(Object moduleCostPriceSum) {
        this.moduleCostPriceSum = moduleCostPriceSum;
    }

    public Object getRealModuleCostPriceSum() {
        return realModuleCostPriceSum;
    }

    public void setRealModuleCostPriceSum(Object realModuleCostPriceSum) {
        this.realModuleCostPriceSum = realModuleCostPriceSum;
    }

    public Object getLabourCostPriceSum() {
        return labourCostPriceSum;
    }

    public void setLabourCostPriceSum(Object labourCostPriceSum) {
        this.labourCostPriceSum = labourCostPriceSum;
    }

    public Object getRealLabourCostPriceSum() {
        return realLabourCostPriceSum;
    }

    public void setRealLabourCostPriceSum(Object realLabourCostPriceSum) {
        this.realLabourCostPriceSum = realLabourCostPriceSum;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCheckTag() {
        return checkTag;
    }

    public void setCheckTag(String checkTag) {
        this.checkTag = checkTag;
    }

    public String getManufactureProcedureTag() {
        return manufactureProcedureTag;
    }

    public void setManufactureProcedureTag(String manufactureProcedureTag) {
        this.manufactureProcedureTag = manufactureProcedureTag;
    }

}