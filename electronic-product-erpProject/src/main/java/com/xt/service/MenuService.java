package com.xt.service;

import java.util.List;

import com.xt.pojo.Permissions;
import com.xt.util.PageDemo;

public interface MenuService {
	//分页查询所有菜单权限信息
	public PageDemo<Permissions> getAllMenusInfo(int nowPage,int pageSize,Permissions r);
	//加载菜单和权限loadMenu
	public List<Permissions> loadMenu();
	//添加菜单或权限
	public int addMenu(Permissions p);
	//删除一个菜单或权限
	public int deleteMenu(int id);
	//修改菜单或权限
	public int updateMenu(Permissions p);
	//菜单下拉框绑定
	public List<Permissions> Menubangding();
}
