package com.xt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xt.pojo.Permission_Role;
import com.xt.pojo.Permissions;
import com.xt.pojo.Roles;
import com.xt.pojo.User_Role;
import com.xt.util.PageUtil;

public interface RoleMapper {
	//获取角色的总数
	public int getRoleCount(@Param("r") Roles r);
	//角色查询(分页)
	public List<Roles> getAllRolesInfo(@Param("page") PageUtil page,@Param("r") Roles r);
	//添加一个角色
	public int addRole(Roles r);
	//为角色赋予权限
	public int addPermission_role(Permission_Role pr);
	//拿到刚刚添加角色的id
	public int getRole_idByName(String name);
	//更新角色信息
	public int updateRoleInfo(Roles r);
	//删除角色拥有的权限
	public int deletePermission_role(int id);
	//删除一个角色
	public int deleteRoleInfo(int id);
	//删除一个角色前看是否已经被 赋予用户
	public User_Role getUser_Role(int id);
	//查询单个角色下面的权限
	public List<Permissions> querymenuInfo(int id);
	//查询所有角色(不分页)
	public List<Roles> getAllRoles();
	//把角色赋予用户
	public int addUserRole(User_Role ur);
	//查询用户拥有的角色
	public List<Roles> selectAllRoles(int id);
	//删除用户拥有的角色
	public int delUserRole(int id);
}