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
	private String u_image;
	private String trueName;
	private String birthday;
	private String address;
	private String email;
	private String personl;
	private String province;
	private String city;
	private String area;
	private int count;//用户访问量
	private int selfcount;//用户单独访问量
	
	public int getSelfcount() {
		return selfcount;
	}
	public void setSelfcount(int selfcount) {
		this.selfcount = selfcount;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPersonl() {
		return personl;
	}
	public void setPersonl(String personl) {
		this.personl = personl;
	}
	public String getU_image() {
		return u_image;
	}
	public void setU_image(String u_image) {
		this.u_image = u_image;
	}
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
	public Users(String u_name,String trueName, String birthday, String address, String email, String personl,
			String province, String city, String area) {
		super();
		this.u_name=u_name;
		this.trueName = trueName;
		this.birthday = birthday;
		this.address = address;
		this.email = email;
		this.personl = personl;
		this.province = province;
		this.city = city;
		this.area = area;
	}
}
