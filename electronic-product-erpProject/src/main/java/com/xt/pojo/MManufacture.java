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
    private String manufacture_id;
    //产品编号
    private String product_id;
    //产品名称
    private String product_name;
    //投产数量
    private Object amount;
    //合格数量
    private Object tested_amount;
    //生产计划序号组
    private String apply_id_group;
    //产品描述
    private String product_describe;
    //设计物料总成本
    private Object module_cost_price_sum;
    //实际物料总成本
    private Object real_module_cost_price_sum;
    //设计工时总成本
    private Object labour_cost_price_sum;
    //实际工时总成本
    private Object real_labour_cost_price_sum;
    //工单制定人
    private String designer;
    //登记人
    private String register;
    //登记时间
    private Object register_time;
    //审核人
    private String checker;
    //审核时间
    private Object check_time;
    //备注
    private String remark;
    //审核标志    S001-0: 等待审核   S001-1: 审核通过   S001-2: 审核不通过
    private String check_tag;
    //生产过程标志    S002-0: 待登记    S002-1: 未审核   S002-2: 已完工
    private String manufacture_procedure_tag;
	public MManufacture() {
		super();
	}
	public MManufacture(Integer id, String manufacture_id, String product_id, String product_name, Object amount,
			Object tested_amount, String apply_id_group, String product_describe, Object module_cost_price_sum,
			Object real_module_cost_price_sum, Object labour_cost_price_sum, Object real_labour_cost_price_sum,
			String designer, String register, Object register_time, String checker, Object check_time, String remark,
			String check_tag, String manufacture_procedure_tag) {
		super();
		this.id = id;
		this.manufacture_id = manufacture_id;
		this.product_id = product_id;
		this.product_name = product_name;
		this.amount = amount;
		this.tested_amount = tested_amount;
		this.apply_id_group = apply_id_group;
		this.product_describe = product_describe;
		this.module_cost_price_sum = module_cost_price_sum;
		this.real_module_cost_price_sum = real_module_cost_price_sum;
		this.labour_cost_price_sum = labour_cost_price_sum;
		this.real_labour_cost_price_sum = real_labour_cost_price_sum;
		this.designer = designer;
		this.register = register;
		this.register_time = register_time;
		this.checker = checker;
		this.check_time = check_time;
		this.remark = remark;
		this.check_tag = check_tag;
		this.manufacture_procedure_tag = manufacture_procedure_tag;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getManufacture_id() {
		return manufacture_id;
	}
	public void setManufacture_id(String manufacture_id) {
		this.manufacture_id = manufacture_id;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public Object getAmount() {
		return amount;
	}
	public void setAmount(Object amount) {
		this.amount = amount;
	}
	public Object getTested_amount() {
		return tested_amount;
	}
	public void setTested_amount(Object tested_amount) {
		this.tested_amount = tested_amount;
	}
	public String getApply_id_group() {
		return apply_id_group;
	}
	public void setApply_id_group(String apply_id_group) {
		this.apply_id_group = apply_id_group;
	}
	public String getProduct_describe() {
		return product_describe;
	}
	public void setProduct_describe(String product_describe) {
		this.product_describe = product_describe;
	}
	public Object getModule_cost_price_sum() {
		return module_cost_price_sum;
	}
	public void setModule_cost_price_sum(Object module_cost_price_sum) {
		this.module_cost_price_sum = module_cost_price_sum;
	}
	public Object getReal_module_cost_price_sum() {
		return real_module_cost_price_sum;
	}
	public void setReal_module_cost_price_sum(Object real_module_cost_price_sum) {
		this.real_module_cost_price_sum = real_module_cost_price_sum;
	}
	public Object getLabour_cost_price_sum() {
		return labour_cost_price_sum;
	}
	public void setLabour_cost_price_sum(Object labour_cost_price_sum) {
		this.labour_cost_price_sum = labour_cost_price_sum;
	}
	public Object getReal_labour_cost_price_sum() {
		return real_labour_cost_price_sum;
	}
	public void setReal_labour_cost_price_sum(Object real_labour_cost_price_sum) {
		this.real_labour_cost_price_sum = real_labour_cost_price_sum;
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
	public Object getRegister_time() {
		return register_time;
	}
	public void setRegister_time(Object register_time) {
		this.register_time = register_time;
	}
	public String getChecker() {
		return checker;
	}
	public void setChecker(String checker) {
		this.checker = checker;
	}
	public Object getCheck_time() {
		return check_time;
	}
	public void setCheck_time(Object check_time) {
		this.check_time = check_time;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getCheck_tag() {
		return check_tag;
	}
	public void setCheck_tag(String check_tag) {
		this.check_tag = check_tag;
	}
	public String getManufacture_procedure_tag() {
		return manufacture_procedure_tag;
	}
	public void setManufacture_procedure_tag(String manufacture_procedure_tag) {
		this.manufacture_procedure_tag = manufacture_procedure_tag;
	}
}