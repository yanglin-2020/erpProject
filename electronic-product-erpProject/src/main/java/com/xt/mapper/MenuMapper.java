package com.xt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xt.pojo.Permissions;
import com.xt.util.PageUtil;

public interface MenuMapper {
	//查询权限和菜单的总数
	public int getMenuCount(@Param("p") Permissions p);
	//权限和菜单查询(分页)
	public List<Permissions> getAllMenusInfo(@Param("page") PageUtil page,@Param("p") Permissions p);
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
