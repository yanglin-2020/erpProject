package com.xt.pojo;

import java.io.Serializable;

/**
 * 库存单元实体类
 *
 * @author long
 */
public class SCell implements Serializable {
    //序号
    private Integer id;
    //库存编号
    private String store_id;
    //产品编号
    private String product_id;
    //产品名称
    private String product_name;
    //产品I级分类编号
    private String first_kind_id;
    //产品I级分类名称
    private String first_kind_name;
    //产品II级分类编号
    private String second_kind_id;
    //产品II级分类名称
    private String second_kind_name;
    //产品III级分类编号
    private String third_kind_id;
    //产品III级分类名称
    private String third_kind_name;
    //库存报警下限数
    private Object min_amount;
    //库存报警上限数
    private Object max_amount;
    //最大存储量
    private Object max_capacity_amount;
    //当前存储量
    private Object amount;
    //配置要求
    private String config;
    //登记人
    private String register;
    //登记时间
    private Object register_time;
    //复核人
    private String checker;
    //复核时间
    private Object check_time;
    //审核标志
    private String check_tag;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStore_id() {
		return store_id;
	}
	public void setStore_id(String store_id) {
		this.store_id = store_id;
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
	public String getFirst_kind_id() {
		return first_kind_id;
	}
	public void setFirst_kind_id(String first_kind_id) {
		this.first_kind_id = first_kind_id;
	}
	public String getFirst_kind_name() {
		return first_kind_name;
	}
	public void setFirst_kind_name(String first_kind_name) {
		this.first_kind_name = first_kind_name;
	}
	public String getSecond_kind_id() {
		return second_kind_id;
	}
	public void setSecond_kind_id(String second_kind_id) {
		this.second_kind_id = second_kind_id;
	}
	public String getSecond_kind_name() {
		return second_kind_name;
	}
	public void setSecond_kind_name(String second_kind_name) {
		this.second_kind_name = second_kind_name;
	}
	public String getThird_kind_id() {
		return third_kind_id;
	}
	public void setThird_kind_id(String third_kind_id) {
		this.third_kind_id = third_kind_id;
	}
	public String getThird_kind_name() {
		return third_kind_name;
	}
	public void setThird_kind_name(String third_kind_name) {
		this.third_kind_name = third_kind_name;
	}
	public Object getMin_amount() {
		return min_amount;
	}
	public void setMin_amount(Object min_amount) {
		this.min_amount = min_amount;
	}
	public Object getMax_amount() {
		return max_amount;
	}
	public void setMax_amount(Object max_amount) {
		this.max_amount = max_amount;
	}
	public Object getMax_capacity_amount() {
		return max_capacity_amount;
	}
	public void setMax_capacity_amount(Object max_capacity_amount) {
		this.max_capacity_amount = max_capacity_amount;
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
	public String getCheck_tag() {
		return check_tag;
	}
	public void setCheck_tag(String check_tag) {
		this.check_tag = check_tag;
	}
}