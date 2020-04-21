package com.xt.pojo;

public class Roles {
	private int id;
	private String name;
	private String descinfo;
	private String time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescinfo() {
		return descinfo;
	}
	public void setDescinfo(String descinfo) {
		this.descinfo = descinfo;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Roles(int id, String name, String descinfo, String time) {
		super();
		this.id = id;
		this.name = name;
		this.descinfo = descinfo;
		this.time = time;
	}
	public Roles() {
		super();
	}
}
