package com.xt.pojo;

import java.io.Serializable;
/**
 * 记录登录的信息
 */
public class SysLogs implements Serializable {
	private int id;
	private String u_name;
	private String phone;
	private String login_time;
	private String login_address;
	private int login_num;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getLogin_time() {
		return login_time;
	}
	public void setLogin_time(String login_time) {
		this.login_time = login_time;
	}
	public String getLogin_address() {
		return login_address;
	}
	public void setLogin_address(String login_address) {
		this.login_address = login_address;
	}
	public int getLogin_num() {
		return login_num;
	}
	public void setLogin_num(int login_num) {
		this.login_num = login_num;
	}
	public SysLogs(String u_name, String phone, String login_time, String login_address) {
		super();
		this.u_name = u_name;
		this.phone = phone;
		this.login_time = login_time;
		this.login_address = login_address;
	}
	public SysLogs() {
		super();
	}
}