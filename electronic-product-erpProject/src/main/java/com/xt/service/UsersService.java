package com.xt.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xt.pojo.Permissions;
import com.xt.pojo.SysLogs;
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
	//修改用户密码
	int updatepwd(String pwd, String u_name);
	//拿到用户登录信息，做一个日志记录
	int addUserLoginInfo(SysLogs sl);
	//查询用户登录信息
	public PageDemo<SysLogs> getUserLoginInfo(int nowPage, int pageSize,SysLogs sl);
	//拿到用户登录的信息
	public List<SysLogs>  getUserAllLoginInfo();
	//修改用户登录信息
	int updateUserLoginInfo(@Param("login_time")String login_time,@Param("u_name") String u_name,@Param("ip") String ip);
	//用户访问量加1
	int updateCount();
	//拿到用户的总数
	int selectAllUserCount();
	//拿到物料总成本
	double getMaterialSumMoney();
	//拿到产品总数
	int getProductAllCount();
	//记录用户单个访问量
	int updateSelfCount(String u_name);
	//查询前五用户的访问量
	public List<Users> getUsersInfoCount();
}
