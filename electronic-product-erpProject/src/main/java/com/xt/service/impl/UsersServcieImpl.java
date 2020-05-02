package com.xt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.mapper.UsersMapper;
import com.xt.pojo.Permissions;
import com.xt.pojo.SysLogs;
import com.xt.pojo.Users;
import com.xt.service.UsersService;
import com.xt.util.PageDemo;
import com.xt.util.PageUtil;

@Service
public class UsersServcieImpl implements UsersService{
	@Autowired
	UsersMapper mapper;
	@Override
	public Users selectByName(String username) {
		return mapper.selectByName(username);
	}
	@Override
	public List<String> selectPermissions(String username) {
		return mapper.selectPermissions(username);
	}
	@Override
	public List<Permissions> selectMenus(String u_name,int gongneng) {
		List<Permissions> parentMenus = mapper.selectMenus(u_name,gongneng);
		List<Permissions> sonMenus;//存放子菜单
		for (Permissions p : parentMenus) {
			sonMenus = mapper.selectSonMenus(u_name, p.getId());
			//子菜单放入集合中储存
			p.setSonMenus(sonMenus);
		}
		return parentMenus;
	}
	//用户的分页查询
	@Override
	public PageDemo<Users> getAllUserInfo(int nowPage, int pageSize, Users u) {
		PageDemo<Users> pd = new PageDemo<Users>();
		//获取用户总记录数(调用mapper的方法)
		int rowCount = mapper.getUsersCount(u);
		PageUtil page = new PageUtil(pageSize, nowPage, rowCount);
		//获取用户的分页查询(调用mapper的方法)
		List<Users> list = mapper.getAllUserInfo(page, u);
		pd.setCode(0);
		pd.setCount(rowCount);
		pd.setMsg("");
		pd.setData(list);
		return pd;
	}
	@Override
	public int addUserInfo(Users u) {
		return mapper.addUserInfo(u);
	}
	@Override
	public int deleteUser(int id) {
		return mapper.deleteUser(id);
	}
	@Override
	public int updateUserInfo(Users u) {
		return mapper.updateUserInfo(u);
	}
	@Override
	public int addUserDetailInfo(Users u) {
		return mapper.addUserDetailInfo(u);
	}
	@Override
	public int updatepwd(String pwd, String u_name) {
		return mapper.updatepwd(pwd,u_name);
	}
	@Override
	public int addUserLoginInfo(SysLogs sl) {
		return mapper.addUserLoginInfo(sl);
	}
	@Override
	public PageDemo<SysLogs> getUserLoginInfo(int nowPage, int pageSize, SysLogs sl) {
		PageDemo<SysLogs> pd = new PageDemo<SysLogs>();
		//获取用户总记录数(调用mapper的方法)
		int rowCount = mapper.getUserLoginInfoCount(sl);
		PageUtil page = new PageUtil(pageSize, nowPage, rowCount);
		//获取用户的分页查询(调用mapper的方法)
		List<SysLogs> list = mapper.getUserLoginInfo(page, sl);
		pd.setCode(0);
		pd.setCount(rowCount);
		pd.setMsg("");
		pd.setData(list);
		return pd;
	}
	@Override
	public List<SysLogs> getUserAllLoginInfo() {
		return mapper.getUserAllLoginInfo();
	}
	@Override
	public int updateUserLoginInfo(String login_time, String u_name,String ip) {
		return mapper.updateUserLoginInfo(login_time, u_name,ip);
	}
	@Override
	public int updateCount() {
		return mapper.updateCount();
	}
	@Override
	public int selectAllUserCount() {
		return mapper.selectAllUserCount();
	}
	@Override
	public double getMaterialSumMoney() {
		return mapper.getMaterialSumMoney();
	}
	@Override
	public int getProductAllCount() {
		return mapper.getProductAllCount();
	}
	@Override
	public int updateSelfCount(String u_name) {
		return mapper.updateSelfCount(u_name);
	}
	@Override
	public List<Users> getUsersInfoCount() {
		return mapper.getUsersInfoCount();
	}
}
