package com.xt.pojo;
/**
 * 采购表
 * @author long
 *
 */
public class Buygoods {
	//序号
	private String id;
	//采购编号
	private String buy_id;
	//供货商id
	private String supplier_ID;
	//供货商名称
	private String supplier_name;
	//操作人员
	private String user_name;
	//采购登记审核标志
	private String status;
	//采购时间
	private String time;
	//审核人
	private String checker;
	//审核时间
	private String check_time;
	//总数量
	private String buy_sum;
	//总金额
	private String buy_price;
	//发票添加标志
	private String store_tag;
	
	@Override
	public String toString() {
		return "Buygoods [id=" + id + ", buy_id=" + buy_id + ", supplier_ID=" + supplier_ID + ", user_name=" + user_name
				+ ", status=" + status + ", time=" + time + ", checker=" + checker + ", check_time=" + check_time
				+ ", buy_sum=" + buy_sum + ", buy_price=" + buy_price + ", store_tag=" + store_tag + "]";
	}
	public String getSupplier_name() {
		return supplier_name;
	}
	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}
	public String getStore_tag() {
		return store_tag;
	}
	public void setStore_tag(String store_tag) {
		this.store_tag = store_tag;
	}
	public String getBuy_sum() {
		return buy_sum;
	}
	public void setBuy_sum(String buy_sum) {
		this.buy_sum = buy_sum;
	}
	public String getBuy_price() {
		return buy_price;
	}
	public void setBuy_price(String buy_price) {
		this.buy_price = buy_price;
	}
	public String getChecker() {
		return checker;
	}
	public void setChecker(String checker) {
		this.checker = checker;
	}
	public String getCheck_time() {
		return check_time;
	}
	public void setCheck_time(String check_time) {
		this.check_time = check_time;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public void setSupplier_ID(String supplier_ID) {
		this.supplier_ID = supplier_ID;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
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
}
