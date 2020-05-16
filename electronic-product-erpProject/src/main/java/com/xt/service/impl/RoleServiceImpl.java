package com.xt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
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
public class RoleServiceImpl implements RoleService {
	@Autowired
	RoleMapper rm;
	@Autowired
	RedisTemplate<String, Object> rt;

	@Override
	public PageDemo<Roles> getAllRolesInfo(int nowPage, int pageSize, Roles r) {
		PageDemo<Roles> pd = new PageDemo<Roles>();
		boolean haskey1 = rt.opsForHash().hasKey("getAllRolesInfo", r);
		boolean haskey2 = rt.opsForHash().hasKey("getRoleCount", r);
		if (haskey1 && haskey2) {
			// 缓存存在，从redis拿
			List<Roles> list = (List<Roles>) (Object) rt.opsForHash().get("getAllRolesInfo", r);
			int rowCount = (int) rt.opsForHash().get("getRoleCount", r);
			pd.setCode(0);
			pd.setCount(rowCount);
			pd.setMsg("");
			pd.setData(list);
			return pd;
		} else {
			// 获取总记录数
			int rowCount = rm.getRoleCount(r);
			PageUtil page = new PageUtil(pageSize, nowPage, rowCount);
			List<Roles> list = rm.getAllRolesInfo(page, r);
			pd.setCode(0);
			pd.setCount(rowCount);
			pd.setMsg("");
			pd.setData(list);
			rt.opsForHash().put("getAllRolesInfo", r, list);
			rt.opsForHash().put("getRoleCount", r, rowCount);
			return pd;
		}
	}

	@Override
	public int addRole(Roles r) {
		int row = rm.addRole(r);
		if(row>0) {
			rt.delete("getAllRolesInfo");
		}
		return row;
	}

	@Override
	public int addPermission_role(Permission_Role pr) {
		int row = rm.addPermission_role(pr);
		if(row>0) {
			rt.delete("getAllRolesInfo");
		}
		return row;
	}

	@Override
	public int getRole_idByName(String name) {
		return rm.getRole_idByName(name);
	}

	@Override
	public int updateRoleInfo(Roles r) {
		int row = rm.updateRoleInfo(r);
		if(row>0) {
			rt.delete("getAllRolesInfo");
		}
		return row;
	}

	@Override
	public int deletePermission_role(int id) {
		int row = rm.deletePermission_role(id);
		if(row>0) {
			rt.delete("getAllRolesInfo");
		}
		return row;
	}

	@Override
	public int deleteRoleInfo(int id) {
		int row = rm.deleteRoleInfo(id);
		if(row>0) {
			rt.delete("getAllRolesInfo");
		}
		return row;
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
		int row = rm.addUserRole(ur);
		if(row>0) {
			rt.delete("getAllRolesInfo");
		}
		return row;
	}

	@Override
	public List<Roles> selectAllRoles(int id) {
		return rm.selectAllRoles(id);
	}

	@Override
	public int delUserRole(int id) {
		int row = rm.delUserRole(id);
		if(row>0) {
			rt.delete("getAllRolesInfo");
		}
		return row;
	}
}
