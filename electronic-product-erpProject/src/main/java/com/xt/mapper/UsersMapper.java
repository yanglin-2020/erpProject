package com.xt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xt.pojo.Permissions;
import com.xt.pojo.Users;
import com.xt.util.PageUtil;

public interface UsersMapper {
	//根据名称获取用户对象
	Users selectByName(String username);
	//根据用户的名称拿到相应的权限
	List<String> selectPermissions(String username);
	//根据用户的id拿到相应的菜单
	List<Permissions> selectMenus(int u_id);
	//拿到子菜单
	List<Permissions> selectSonMenus(@Param("u_id") int u_id,@Param("menu_id")int menu_id);
	//拿到用户的数量
	int getUsersCount(@Param("u") Users user);
	//分页查询用户
	public List<Users> getAllUserInfo(@Param("page") PageUtil page,@Param("u") Users u);
}
