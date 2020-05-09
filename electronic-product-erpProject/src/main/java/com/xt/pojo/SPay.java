package com.xt.pojo;

import java.io.Serializable;

/**
 * 出库实体类
 *
 * @author long
 */
public class SPay implements Serializable {
    //序号
    private Integer id;
    //出库单编号
    private String pay_id;
    //出库人
    private String storer;
    //出库理由   C002-1: 生产领料   C002-2: 赠送   C002-3: 内部借领   C002-4: 其他借领
    private String reason;
    //出库详细理由
    private String reasonexact;
    //总件数
    private Object amount_sum;
    //总金额
    private Object cost_price_sum;
    //确认出库总件数
    private Object paid_amount_sum;
    //备注
    private String remark;
    //登记人
    private String register;
    //登记时间
    private Object register_time;
    //复核人
    private String checker;
    public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	//复核时间
    private Object check_time;
    //审核标志    S001-0: 等待审核    S001-1: 审核通过   S001-2: 审核不通过
    private String check_tag;
    //调度人
    private String attemper;
    //调度时间
    private Object attemper_time;
    //库存标志    K002-1: 已登记   K002-2: 已调度
    private String store_tag;
    
    private String status;//完成状态
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPay_id() {
		return pay_id;
	}
	public void setPay_id(String pay_id) {
		this.pay_id = pay_id;
	}
	public String getStorer() {
		return storer;
	}
	public void setStorer(String storer) {
		this.storer = storer;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getReasonexact() {
		return reasonexact;
	}
	public void setReasonexact(String reasonexact) {
		this.reasonexact = reasonexact;
	}
	public Object getAmount_sum() {
		return amount_sum;
	}
	public void setAmount_sum(Object amount_sum) {
		this.amount_sum = amount_sum;
	}
	public Object getCost_price_sum() {
		return cost_price_sum;
	}
	public void setCost_price_sum(Object cost_price_sum) {
		this.cost_price_sum = cost_price_sum;
	}
	public Object getPaid_amount_sum() {
		return paid_amount_sum;
	}
	public void setPaid_amount_sum(Object paid_amount_sum) {
		this.paid_amount_sum = paid_amount_sum;
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
	public String getAttemper() {
		return attemper;
	}
	public void setAttemper(String attemper) {
		this.attemper = attemper;
	}
	public Object getAttemper_time() {
		return attemper_time;
	}
	public void setAttemper_time(Object attemper_time) {
		this.attemper_time = attemper_time;
	}
	public String getStore_tag() {
		return store_tag;
	}
	public void setStore_tag(String store_tag) {
		this.store_tag = store_tag;
	}
    

}