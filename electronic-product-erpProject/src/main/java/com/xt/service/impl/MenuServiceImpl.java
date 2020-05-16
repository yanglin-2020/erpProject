package com.xt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.xt.mapper.MenuMapper;
import com.xt.pojo.Permissions;
import com.xt.pojo.Roles;
import com.xt.service.MenuService;
import com.xt.util.PageDemo;
import com.xt.util.PageUtil;
@Service
public class MenuServiceImpl implements MenuService{
	@Autowired
	MenuMapper mm;
	@Autowired
	RedisTemplate<String, Object> rt;
	@Override
	public PageDemo<Permissions> getAllMenusInfo(int nowPage, int pageSize, Permissions p) {
		PageDemo<Permissions> pd = new PageDemo<Permissions>();
		boolean haskey1 = rt.opsForHash().hasKey("getAllMenusInfo", p);
		boolean haskey2 = rt.opsForHash().hasKey("getMenuCount", p);
		if(haskey1&&haskey2) {
			// 缓存存在，从redis拿
			List<Permissions> list = (List<Permissions>) (Object) rt.opsForHash().get("getAllMenusInfo", p);
			int rowCount = (int) rt.opsForHash().get("getMenuCount", p);
			pd.setCode(0);
			pd.setCount(rowCount);
			pd.setMsg("");
			pd.setData(list);
			return pd;
		}else {
			int rowCount =mm.getMenuCount(p);
			PageUtil page = new PageUtil(pageSize, nowPage, rowCount);
			List<Permissions> list = mm.getAllMenusInfo(page, p);
			pd.setCode(0);
			pd.setCount(rowCount);
			pd.setMsg("");
			pd.setData(list);
			rt.opsForHash().put("getAllMenusInfo", p, list);
			rt.opsForHash().put("getMenuCount", p, rowCount);
			return pd;
		}
		
	}

	@Override
	public List<Permissions> loadMenu() {
		return mm.loadMenu();
	}

	@Override
	public int addMenu(Permissions p) {
		int row = mm.addMenu(p);
		if(row>0) {
			rt.delete("getAllMenusInfo");
		}
		return row;
	}

	@Override
	public int deleteMenu(int id) {
		int row = mm.deleteMenu(id);
		if(row>0) {
			rt.delete("getAllMenusInfo");
		}
		return row;
	}

	@Override
	public int updateMenu(Permissions p) {
		int row = mm.updateMenu(p);
		if(row>0) {
			rt.delete("getAllMenusInfo");
		}
		return row;
	}

	@Override
	public List<Permissions> Menubangding() {
		return mm.Menubangding();
	}
}
