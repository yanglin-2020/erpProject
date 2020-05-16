package com.xt.pojo;

public class Supplier {
	private String supplier_ID; //供货商编号
	private String name;  //供货商名称
	private String address; //所在地
	private String phone;  //联系电话
	private String khyh; //开户银行
	private String constactPerson; //联系人
	private String register;  //登记人
	private Object register_time; //登记时间
	private String checker;  //复核人
	private Object check_time;  //复核时间
	private String check_tag; //审核状态
	private String reason;  //审核意见
	private String remark;  //备注
	private String delstate; //删除状态
	public Supplier() {
		super();
	}
	
	public Supplier(String supplier_ID, String name, String address, String phone, String khyh, String constactPerson,
			String register, Object register_time, String checker, Object check_time, String check_tag, String reason,
			String remark, String delstate) {
		super();
		this.supplier_ID = supplier_ID;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.khyh = khyh;
		this.constactPerson = constactPerson;
		this.register = register;
		this.register_time = register_time;
		this.checker = checker;
		this.check_time = check_time;
		this.check_tag = check_tag;
		this.reason = reason;
		this.remark = remark;
		this.delstate = delstate;
	}

	public String getDelstate() {
		return delstate;
	}

	public void setDelstate(String delstate) {
		this.delstate = delstate;
	}

	public String getSupplier_ID() {
		return supplier_ID;
	}
	public void setSupplier_ID(String supplier_ID) {
		this.supplier_ID = supplier_ID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getKhyh() {
		return khyh;
	}
	public void setKhyh(String khyh) {
		this.khyh = khyh;
	}
	public String getConstactPerson() {
		return constactPerson;
	}
	public void setConstactPerson(String constactPerson) {
		this.constactPerson = constactPerson;
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
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	


}
