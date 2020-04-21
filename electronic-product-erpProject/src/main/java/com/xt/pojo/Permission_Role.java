package com.xt.pojo;

public class Permission_Role {
	private int rid;
	private int pid;
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public Permission_Role() {
		super();
	}
	public Permission_Role(int rid, int pid) {
		super();
		this.rid = rid;
		this.pid = pid;
	}
}
