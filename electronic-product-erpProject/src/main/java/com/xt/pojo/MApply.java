package com.xt.pojo;

import java.io.Serializable;

/**
 * 产品生产计划实体类
 *
 * @author makejava
 * @since 2020-04-17 10:35:17
 */
public class MApply implements Serializable {
    private static final long serialVersionUID = 311706657090918042L;
    //序号
    private Integer id;
    //生产计划编号
    private String apply_id;
    //产品编号
    private String product_id;
    //产品名称
    private String product_name;
    //产品描述
    private String product_describe;
    //用途类型
    private String type;
    //数量
    private Object amount;
    //设计人
    private String designer;
    //备注
    private String remark;
    //登记人
    private String register;
    //登记时间
    private Object register_time;
    //复核人
    private String checker;
    //审核意见
    private String check_suggestion;
    //审核时间
    private Object check_time;
    //审核标志    S001-0: 等待审核    S001-1: 审核通过   S001-2: 审核不通过
    private String check_tag;
    //派工标志    P001-0: 未派工     P001-1: 已派工
    private String manufacture_tag;
	public MApply() {
		super();
	}
	public MApply(Integer id, String apply_id, String product_id, String product_name, String product_describe,
			String type, Object amount, String designer, String remark, String register, Object register_time,
			String checker, String check_suggestion, Object check_time, String check_tag, String manufacture_tag) {
		super();
		this.id = id;
		this.apply_id = apply_id;
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_describe = product_describe;
		this.type = type;
		this.amount = amount;
		this.designer = designer;
		this.remark = remark;
		this.register = register;
		this.register_time = register_time;
		this.checker = checker;
		this.check_suggestion = check_suggestion;
		this.check_time = check_time;
		this.check_tag = check_tag;
		this.manufacture_tag = manufacture_tag;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getApply_id() {
		return apply_id;
	}
	public void setApply_id(String apply_id) {
		this.apply_id = apply_id;
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
	public String getProduct_describe() {
		return product_describe;
	}
	public void setProduct_describe(String product_describe) {
		this.product_describe = product_describe;
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
	public String getDesigner() {
		return designer;
	}
	public void setDesigner(String designer) {
		this.designer = designer;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
	public String getCheck_suggestion() {
		return check_suggestion;
	}
	public void setCheck_suggestion(String check_suggestion) {
		this.check_suggestion = check_suggestion;
	}
	public Object getCheck_time() {
		return check_time;
	}
	public void setCheck_time(Object check_time) {
		this.check_time = check_time;
	}
	public String getCheck_tag() {
		return check_tag;
	}
	public void setCheck_tag(String check_tag) {
		this.check_tag = check_tag;
	}
	public String getManufacture_tag() {
		return manufacture_tag;
	}
	public void setManufacture_tag(String manufacture_tag) {
		this.manufacture_tag = manufacture_tag;
	}
	
}