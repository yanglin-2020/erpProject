package com.xt.pojo;

public class User_Role {
	private int u_id;
	private int r_id;
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public int getR_id() {
		return r_id;
	}
	public void setR_id(int r_id) {
		this.r_id = r_id;
	}
	public User_Role() {
		super();
	}
	public User_Role(int u_id, int r_id) {
		super();
		this.u_id = u_id;
		this.r_id = r_id;
	}
}
