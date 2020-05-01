package com.xt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.mapper.MenuMapper;
import com.xt.pojo.Permissions;
import com.xt.service.MenuService;
import com.xt.util.PageDemo;
import com.xt.util.PageUtil;
@Service
public class MenuServiceImpl implements MenuService{
	@Autowired
	MenuMapper mm;
	
	@Override
	public PageDemo<Permissions> getAllMenusInfo(int nowPage, int pageSize, Permissions p) {
		PageDemo<Permissions> pd = new PageDemo<Permissions>();
		int rowCount =mm.getMenuCount(p);
		PageUtil page = new PageUtil(pageSize, nowPage, rowCount);
		List<Permissions> list = mm.getAllMenusInfo(page, p);
		pd.setCode(0);
		pd.setCount(rowCount);
		pd.setMsg("");
		pd.setData(list);
		return pd;
	}

	@Override
	public List<Permissions> loadMenu() {
		return mm.loadMenu();
	}

	@Override
	public int addMenu(Permissions p) {
		return mm.addMenu(p);
	}

	@Override
	public int deleteMenu(int id) {
		return mm.deleteMenu(id);
	}

	@Override
	public int updateMenu(Permissions p) {
		return mm.updateMenu(p);
	}

	@Override
	public List<Permissions> Menubangding() {
		return mm.Menubangding();
	}
}
