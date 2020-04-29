package com.xt.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xt.pojo.Permissions;
import com.xt.pojo.Users;
import com.xt.util.PageDemo;

public interface UsersService {
	//根据名称获取用户对象
	Users selectByName(String username);
	//根据用户的名称拿到相应的权限
	List<String> selectPermissions(String username);
	//根据用户的id拿到相应的菜单
	List<Permissions> selectMenus(@Param("u_name") String u_name,@Param("gongneng")int gongneng);
	//分页查询所有用户信息
	public PageDemo<Users> getAllUserInfo(int nowPage, int pageSize,Users u);
	//添加一个用户信息
	int addUserInfo(Users u);
	//删除一个用户信息
	int deleteUser(int id);
	//修改用户信息
	int updateUserInfo(Users u);
	//个人的详细信息添加到数据库
	int addUserDetailInfo(Users u);
}
