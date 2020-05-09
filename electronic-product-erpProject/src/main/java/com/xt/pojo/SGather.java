package com.xt.pojo;

import java.io.Serializable;

/**
 * 入库实体类
 *
 * @author makejava
 * @since 2020-04-17 10:35:18
 * 
 * 
 */
public class SGather implements Serializable {
    private static final long serialVersionUID = 212413245098077569L;
    //序号
    private Integer id;
    //入库单编号
    private String gather_id;
    //厂库编号
    private String storer;
    //入库理由   R001-1: 生产入库   R001-2: 库存初始   R001-3: 赠送   R001-4: 内部归还   R001-5: 其他归还
    private String reason;
    //入库详细理由
    private String reasonexact;
    //总件数
    private String amount_sum;
    //总金额
    private String cost_price_sum;
    //确认入库总件数
    private int gathered_amount_sum;
    //备注
    private String remark;
    //入库人
    private String rukuperson;
    //登记人
    private String register;
    //登记时间
    private String register_time;
    //复核人
    private String checker;
    //复核时间
    private String check_time;
    //审核标志    S001-0: 等待审核    S001-1: 审核通过    S001-2: 审核不通过
    private String check_tag;
    //调度人
    private String attemper;
    //调度时间
    private String attemper_time;
    //库存标志    K002-1: 已登记   K002-2: 已调度
    private String store_tag;
    public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	//状态
    private String status;
    
    
	public String getRukuperson() {
		return rukuperson;
	}
	public void setRukuperson(String rukuperson) {
		this.rukuperson = rukuperson;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getGather_id() {
		return gather_id;
	}
	public void setGather_id(String gather_id) {
		this.gather_id = gather_id;
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
	public void setAmount_sum(String amount_sum) {
		this.amount_sum = amount_sum;
	}
	public Object getCost_price_sum() {
		return cost_price_sum;
	}
	public void setCost_price_sum(String cost_price_sum) {
		this.cost_price_sum = cost_price_sum;
	}
	public Object getGathered_amount_sum() {
		return gathered_amount_sum;
	}
	public void setGathered_amount_sum(int gathered_amount_sum) {
		this.gathered_amount_sum = gathered_amount_sum;
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
	public void setRegister_time(String register_time) {
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
	public void setCheck_time(String check_time) {
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
	public void setAttemper_time(String attemper_time) {
		this.attemper_time = attemper_time;
	}
	public String getStore_tag() {
		return store_tag;
	}
	public void setStore_tag(String store_tag) {
		this.store_tag = store_tag;
	}
	public SGather() {
		super();
	}
	public SGather(String gather_id, String reason, String amount_sum, String cost_price_sum, String remark,
			String rukuperson, String register, String register_time) {
		super();
		this.gather_id = gather_id;
		this.reason = reason;
		this.amount_sum = amount_sum;
		this.cost_price_sum = cost_price_sum;
		this.remark = remark;
		this.rukuperson = rukuperson;
		this.register = register;
		this.register_time = register_time;
	}
}