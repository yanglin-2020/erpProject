package com.xt.pojo;
/**
 * 发票
 * @author LWT
 *
 */
public class Invoice {
	private String id;
	private String buy_id;//采购id
	private String supplier_name;
	private String supplier_ID;//供货商id
	private Double num;//总金额
	private String liyou;//购买理由
	private String register;//登记人
	private String register_time;//登记时间
	private String chanr;//审核人
	private String status;//审核状态
	private String time;//审核时间
	private String yijian;//通过意见
	
	
	public String getSupplier_name() {
		return supplier_name;
	}
	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}
	public String getBuy_id() {
		return buy_id;
	}
	public void setBuy_id(String buy_id) {
		this.buy_id = buy_id;
	}
	public String getSupplier_ID() {
		return supplier_ID;
	}
	public void setSupplier_ID(String string) {
		this.supplier_ID = string;
	}
	public Double getNum() {
		return num;
	}
	public void setNum(Double num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLiyou() {
		return liyou;
	}
	public void setLiyou(String liyou) {
		this.liyou = liyou;
	}
	public String getRegister() {
		return register;
	}
	public void setRegister(String register) {
		this.register = register;
	}
	public String getRegister_time() {
		return register_time;
	}
	public void setRegister_time(String register_time) {
		this.register_time = register_time;
	}
	public String getChanr() {
		return chanr;
	}
	public void setChanr(String chanr) {
		this.chanr = chanr;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getYijian() {
		return yijian;
	}
	public void setYijian(String yijian) {
		this.yijian = yijian;
	}
	@Override
	public String toString() {
		return "Invoice [id=" + id + ", buy_id=" + buy_id + ", supplier_ID=" + supplier_ID + ", num=" + num + ", liyou="
				+ liyou + ", register=" + register + ", register_time=" + register_time + ", chanr=" + chanr
				+ ", status=" + status + ", time=" + time + ", yijian=" + yijian + "]";
	}
	
	
	
}
