package com.xt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import com.xt.mapper.UsersMapper;
import com.xt.pojo.GongGao;
import com.xt.pojo.Permissions;
import com.xt.pojo.SCell;
import com.xt.pojo.SysLogs;
import com.xt.pojo.Users;
import com.xt.service.UsersService;
import com.xt.util.PageDemo;
import com.xt.util.PageUtil;

@Service
@SuppressWarnings("all")
public class UsersServcieImpl implements UsersService{
	@Autowired
	UsersMapper mapper;
	@Autowired
	RedisTemplate<String, Object> rt;
	
	@Override
	public Users selectByName(String username) {
		return mapper.selectByName(username);
	}
	@Override
	public List<String> selectPermissions(String username) {
		boolean haskey = rt.opsForHash().hasKey("selectPermissions", username);
		if(haskey) {
			//缓存存在，从redis整中获取数据
			List<String> list=(List<String>)(Object)rt.opsForHash().get("selectPermissions", username);
			return list;
		}else {
			//缓存不存在，从mysql拿数据
			List<String> list = mapper.selectPermissions(username);
			//写入缓存
			//重新设置序列化器
			rt.setValueSerializer(new Jackson2JsonRedisSerializer<String>(String.class));
			rt.opsForHash().put("selectPermissions", username, list);
			return list;
		}
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
		boolean haskey1 = rt.opsForHash().hasKey("getAllUserInfo",u);
		boolean haskey2 = rt.opsForHash().hasKey("getUsersCount",u);
		if(haskey1&&haskey2) {
			//缓存存在，从redis整中获取数据
			List<Users> list = (List<Users>)(Object)rt.opsForHash().get("getAllUserInfo", u);
			int rowCount = (int) rt.opsForHash().get("getUsersCount", u);
			pd.setCode(0);
			pd.setCount(rowCount);
			pd.setMsg("");
			pd.setData(list);
			return pd;
		}else {
			//获取用户的分页查询(调用mapper的方法)
			int rowCount = mapper.getUsersCount(u);
			PageUtil page = new PageUtil(pageSize, nowPage, rowCount);
			List<Users> list = mapper.getAllUserInfo(page, u);
			pd.setCode(0);
			pd.setCount(rowCount);
			pd.setMsg("");
			pd.setData(list);
			rt.opsForHash().put("getAllUserInfo", u, list);
			rt.opsForHash().put("getUsersCount", u, rowCount);
			return pd;
		}
	}
	@Override
	public int addUserInfo(Users u) {
		int row = mapper.addUserInfo(u);
		if(row>0) {
			//加入缓存
			//重新设置序列化器
			rt.setValueSerializer(new JdkSerializationRedisSerializer());
			rt.delete("getAllUserInfo");
		}
		return row;
	}
	/**
	 * 删除策略：删除数据表中数据，然后删除缓存
	 */
	@Override
	public int deleteUser(int id) {
		int row = mapper.deleteUser(id);
		if(row>0) {
			//判断是否有缓存
			rt.setValueSerializer(new JdkSerializationRedisSerializer());
			rt.delete("getAllUserInfo");
		}
		return row;
	}
	/**
	 * 更新策略：先更新数据表，成功之后，删除原来的缓存，再更新缓存
	 */
	@Override
	public int updateUserInfo(Users u) {
		int row = mapper.updateUserInfo(u);
		if(row>0) {
			//删除缓存中的key
			rt.delete("getAllUserInfo");
		}
		return row;
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
	@Override
	public PageDemo<GongGao> getGongGaoInfo(int nowPage, int pageSize, GongGao gg) {
		PageDemo<GongGao> pd = new PageDemo<GongGao>();
		//获取用户总记录数(调用mapper的方法)
		int rowCount = mapper.getGongGaoCount(gg);
		PageUtil page = new PageUtil(pageSize, nowPage, rowCount);
		//获取用户的分页查询(调用mapper的方法)
		List<GongGao> list = mapper.getGongGaoInfo(page, gg);
		pd.setCode(0);
		pd.setCount(rowCount);
		pd.setMsg("");
		pd.setData(list);
		return pd;
	}
	@Override
	public PageDemo<SCell> getyjInfo(int nowPage, int pageSize, SCell s) {
		PageDemo<SCell> pd = new PageDemo<SCell>();
		//获取用户总记录数(调用mapper的方法)
		int rowCount = mapper.getyjCount(s);
		PageUtil page = new PageUtil(pageSize, nowPage, rowCount);
		//获取用户的分页查询(调用mapper的方法)
		List<SCell> list = mapper.getyjInfo(page, s);
		pd.setCode(0);
		pd.setCount(rowCount);
		pd.setMsg("");
		pd.setData(list);
		return pd;
	}
	@Override
	public PageDemo<GongGao> getGongGaoAllInfo(int nowPage, int pageSize, GongGao gg) {
		PageDemo<GongGao> pd = new PageDemo<GongGao>();
		//获取用户总记录数(调用mapper的方法)
		int rowCount = mapper.getGongGaoAllCount(gg);
		PageUtil page = new PageUtil(pageSize, nowPage, rowCount);
		//获取用户的分页查询(调用mapper的方法)
		List<GongGao> list = mapper.getGongGaoAllInfo(page, gg);
		pd.setCode(0);
		pd.setCount(rowCount);
		pd.setMsg("");
		pd.setData(list);
		return pd;
	}
	@Override
	public int addGongGao(GongGao gg) {
		return mapper.addGongGao(gg);
	}
	@Override
	public int updateGongGao(GongGao gg) {
		return mapper.updateGongGao(gg);
	}
	@Override
	public int deleteGongGao(String id) {
		return mapper.deleteGongGao(id);
	}
}
