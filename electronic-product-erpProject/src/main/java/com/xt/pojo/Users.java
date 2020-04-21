package com.xt.pojo;

import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * 用户实体类
 *
 * @author makejava
 * @since 2020-04-17 10:35:18
 */
public class Users implements Serializable {
	private int u_id;
	private String u_name;
	private String sex;
	private String u_password;
	private String salt;
	private String phone;
	private String u_status;
	private String u_create;
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getU_password() {
		return u_password;
	}
	public void setU_password(String u_password) {
		this.u_password = u_password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getU_status() {
		return u_status;
	}
	public void setU_status(String u_status) {
		this.u_status = u_status;
	}
	public String getU_create() {
		return u_create;
	}
	public void setU_create(String u_create) {
		this.u_create = u_create;
	}
	public Users(String u_name, String sex, String u_password, String salt, String phone) {
		super();
		this.u_name = u_name;
		this.sex = sex;
		this.u_password = u_password;
		this.salt = salt;
		this.phone = phone;
	}
	public Users() {
		super();
	}
}