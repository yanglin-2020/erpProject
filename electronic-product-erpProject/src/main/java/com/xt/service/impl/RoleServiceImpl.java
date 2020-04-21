package com.xt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.mapper.RoleMapper;
import com.xt.pojo.Permission_Role;
import com.xt.pojo.Permissions;
import com.xt.pojo.Roles;
import com.xt.pojo.User_Role;
import com.xt.service.RoleService;
import com.xt.util.PageDemo;
import com.xt.util.PageUtil;
@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
	RoleMapper rm;
	
	@Override
	public PageDemo<Roles> getAllRolesInfo(int nowPage, int pageSize, Roles r) {
		PageDemo<Roles> pd = new PageDemo<Roles>();
		//获取总记录数
		int rowCount =rm.getRoleCount(r);
		PageUtil page = new PageUtil(pageSize, nowPage, rowCount);
		List<Roles> list = rm.getAllRolesInfo(page, r);
		pd.setCode(0);
		pd.setCount(rowCount);
		pd.setMsg("");
		pd.setData(list);
		return pd;
	}

	@Override
	public int addRole(Roles r) {
		return rm.addRole(r);
	}

	@Override
	public int addPermission_role(Permission_Role pr) {
		return rm.addPermission_role(pr);
	}

	@Override
	public int getRole_idByName(String name) {
		return rm.getRole_idByName(name);
	}

	@Override
	public int updateRoleInfo(Roles r) {
		return rm.updateRoleInfo(r);
	}

	@Override
	public int deletePermission_role(int id) {
		return rm.deletePermission_role(id);
	}

	@Override
	public int deleteRoleInfo(int id) {
		return rm.deleteRoleInfo(id);
	}

	@Override
	public User_Role getUser_Role(int id) {
		return rm.getUser_Role(id);
	}

	@Override
	public List<Permissions> querymenuInfo(int id) {
		return rm.querymenuInfo(id);
	}

	@Override
	public List<Roles> getAllRoles() {
		return rm.getAllRoles();
	}

	@Override
	public int addUserRole(User_Role ur) {
		return rm.addUserRole(ur);
	}

	@Override
	public List<Roles> selectAllRoles(int id) {
		return rm.selectAllRoles(id);
	}

	@Override
	public int delUserRole(int id) {
		return rm.delUserRole(id);
	}
}
