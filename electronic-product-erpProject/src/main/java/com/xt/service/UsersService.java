package com.xt.service;

import java.util.List;

import com.xt.pojo.Permissions;
import com.xt.pojo.Users;
import com.xt.util.PageDemo;

public interface UsersService {
	//根据名称获取用户对象
	Users selectByName(String username);
	//根据用户的名称拿到相应的权限
	List<String> selectPermissions(String username);
	//根据用户的id拿到相应的菜单
	List<Permissions> selectMenus(int u_id);
	//分页查询所有用户信息
	public PageDemo<Users> getAllUserInfo(int nowPage, int pageSize,Users u);
}
