package com.xt.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 菜单信息实体类
 *
 * @author yl
 * @since 2020-04-17 10:35:18
 */
public class Permissions implements Serializable {
	private int id;
	private String name;
	private String descn;
	private String linkUrl;
	private int type;
	private int parentMenu;
	private String ico;//图标
	public String getIco() {
		return ico;
	}
	public void setIco(String ico) {
		this.ico = ico;
	}
	private List<Permissions> sonMenus;
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
	public String getDescn() {
		return descn;
	}
	public void setDescn(String descn) {
		this.descn = descn;
	}
	public String getLinkUrl() {
		return linkUrl;
	}
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getParentMenu() {
		return parentMenu;
	}
	public void setParentMenu(int parentMenu) {
		this.parentMenu = parentMenu;
	}
	public List<Permissions> getSonMenus() {
		return sonMenus;
	}
	public void setSonMenus(List<Permissions> sonMenus) {
		this.sonMenus = sonMenus;
	}
}