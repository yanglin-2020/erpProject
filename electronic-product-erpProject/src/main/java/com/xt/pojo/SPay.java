package com.xt.pojo;

import java.io.Serializable;

/**
 * 出库实体类
 *
 * @author lwt
 * @since 2020-04-17 10:35:18
 */
public class SPay implements Serializable {
    private static final long serialVersionUID = 223316791023593913L;
    //序号
    private Integer id;
    //出库单编号
    private String pay_Id;
    //出库人
    private String storer;
    //出库理由   C002-1: 生产领料   C002-2: 赠送   C002-3: 内部借领   C002-4: 其他借领
    private String reason;
    //出库详细理由
    private String reasonexact;
    //总件数
    private int amount_Sum;
    //总金额
    private Object cost_Price_Sum;
    //确认出库总件数
    private int paid_Amount_Sum;
    //备注
    private String remark;
    //登记人
    private String register;
    //登记时间
    private String register_Time;
    //复核人
    private String checker;
    //复核时间
    private String check_Time;
    //审核标志    S001-0: 等待审核    S001-1: 审核通过   S001-2: 审核不通过
    private String check_Tag;
    //调度人
    private String attemper;
    //调度时间
    private String attemper_Time;
    //库存标志    K002-1: 已登记   K002-2: 已调度
    private String store_Tag;
	@Override
	public String toString() {
		return "SPay [id=" + id + ", pay_Id=" + pay_Id + ", storer=" + storer + ", reason=" + reason + ", reasonexact="
				+ reasonexact + ", amount_Sum=" + amount_Sum + ", cost_Price_Sum=" + cost_Price_Sum
				+ ", paid_Amount_Sum=" + paid_Amount_Sum + ", remark=" + remark + ", register=" + register
				+ ", register_Time=" + register_Time + ", checker=" + checker + ", check_Time=" + check_Time
				+ ", check_Tag=" + check_Tag + ", attemper=" + attemper + ", attemper_Time=" + attemper_Time
				+ ", store_Tag=" + store_Tag + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPay_Id() {
		return pay_Id;
	}
	public void setPay_Id(String pay_Id) {
		this.pay_Id = pay_Id;
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
	public int getAmount_Sum() {
		return amount_Sum;
	}
	public void setAmount_Sum(int amount_Sum) {
		this.amount_Sum = amount_Sum;
	}
	public Object getCost_Price_Sum() {
		return cost_Price_Sum;
	}
	public void setCost_Price_Sum(Object cost_Price_Sum) {
		this.cost_Price_Sum = cost_Price_Sum;
	}
	public int getPaid_Amount_Sum() {
		return paid_Amount_Sum;
	}
	public void setPaid_Amount_Sum(int paid_Amount_Sum) {
		this.paid_Amount_Sum = paid_Amount_Sum;
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
	public String getRegister_Time() {
		return register_Time;
	}
	public void setRegister_Time(String register_Time) {
		this.register_Time = register_Time;
	}
	public String getChecker() {
		return checker;
	}
	public void setChecker(String checker) {
		this.checker = checker;
	}
	public String getCheck_Time() {
		return check_Time;
	}
	public void setCheck_Time(String check_Time) {
		this.check_Time = check_Time;
	}
	public String getCheck_Tag() {
		return check_Tag;
	}
	public void setCheck_Tag(String check_Tag) {
		this.check_Tag = check_Tag;
	}
	public String getAttemper() {
		return attemper;
	}
	public void setAttemper(String attemper) {
		this.attemper = attemper;
	}
	public String getAttemper_Time() {
		return attemper_Time;
	}
	public void setAttemper_Time(String attemper_Time) {
		this.attemper_Time = attemper_Time;
	}
	public String getStore_Tag() {
		return store_Tag;
	}
	public void setStore_Tag(String store_Tag) {
		this.store_Tag = store_Tag;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}



}