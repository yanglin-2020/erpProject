package com.xt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.xt.pojo.Permissions;
import com.xt.pojo.Roles;
import com.xt.service.MenuService;
import com.xt.util.PageDemo;

 

@Controller
public class MenuController {
	@Autowired
	MenuService service;
	//菜单查询
	@RequestMapping("/getAllMenuInfo")
	public void getAllMenuInfo(HttpServletResponse response, HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String nowPage = request.getParameter("page");
		String pageSize = request.getParameter("limit");
		String menu_name = request.getParameter("name");//获取角色名称
		Permissions p = new Permissions();
		if (menu_name != null && menu_name != "" && !menu_name.equals("null")) {
			p.setName(menu_name);
		}
		PageDemo<Permissions> pd = service.getAllMenusInfo(Integer.parseInt(nowPage), Integer.parseInt(pageSize), p);
		PrintWriter out = response.getWriter();
		String str = JSONArray.toJSONString(pd);
		out.print(str);
		out.flush();
		out.close();
	}
	//加载菜单
	@RequestMapping("/loadMenu")
	@ResponseBody
	public List<Permissions> loadMenu() {
		List<Permissions> list = new ArrayList<Permissions>();
		list = service.loadMenu();
		return list;
	}	
	//添加(修改)菜单(权限)
	@RequestMapping("/addMenuInfo")
	public void addMenuInfo(HttpServletResponse response,HttpServletRequest request) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//为空执行添加操作,不为空更新操作
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String miaoshu = request.getParameter("miaoshu");
		String url = request.getParameter("url");
		String type = request.getParameter("type");
		String parentid = request.getParameter("parentid");
		Permissions p = new Permissions();
		p.setName(name);
		p.setDescn(miaoshu);
		p.setLinkUrl(url);
		p.setType(Integer.parseInt(type));
		p.setParentMenu(Integer.parseInt(parentid));
		int id1 = id==""?0:1;
		if(id1==0) {
			//添加操作
			int count = service.addMenu(p);
			out.print(count);
		}else {
			//更新操作
			p.setId(Integer.parseInt(id));
			int count = service.updateMenu(p);
			out.print(count);
		}
		out.flush();
		out.close();
	}
	//删除一个权限或菜单
	@RequestMapping("/delMenuInfo")
	@ResponseBody
	public String delMenuInfo(int id) {
		service.deleteMenu(id);
		return "1";
	}
	//菜单下拉框绑定
	@RequestMapping("/Menubangding")
	@ResponseBody
	public void Menubangding(HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		List<Permissions> list = service.Menubangding();
		String str = JSONArray.toJSONString(list);
		PrintWriter out = response.getWriter();
		out.print(str);
		out.flush();
		out.close();
	}
}
