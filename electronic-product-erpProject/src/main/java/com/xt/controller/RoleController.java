package com.xt.controller;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.xt.pojo.Permission_Role;
import com.xt.pojo.Permissions;
import com.xt.pojo.Roles;
import com.xt.pojo.User_Role;
import com.xt.service.RoleService;
import com.xt.util.PageDemo;

@Controller
public class RoleController {
	@Autowired
	RoleService service;
	//查询角色信息
	@RequestMapping("/getAllRolesInfo")
	public void getAllRolesInfo(HttpServletResponse response, HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String nowPage = request.getParameter("page");
		String pageSize = request.getParameter("limit");
		String role_name = request.getParameter("name");//获取角色名称
		Roles r = new Roles();
		if (role_name != null && role_name != "" && !role_name.equals("null")) {
			r.setName(role_name);
		}
		PageDemo<Roles> pd = service.getAllRolesInfo(Integer.parseInt(nowPage), Integer.parseInt(pageSize), r);
		PrintWriter out = response.getWriter();
		String str = JSONArray.toJSONString(pd);
		out.print(str);
		out.flush();
		out.close();
	}
	//添加(修改)角色菜单信息
	@RequestMapping("/addRoleMenu")
	@ResponseBody
	public void addRoleMenu(HttpServletRequest request,HttpServletResponse response) throws Exception {
		PrintWriter out = response.getWriter();
		//用于做判断，为空执行添加功能，不为空执行修改功能
		String id1 = request.getParameter("roleid");
		String name = request.getParameter("name");
		String miaoshu = request.getParameter("miaoshu");
		Roles role = new Roles();
		role.setName(name);
		role.setDescinfo(miaoshu);
		int id2 = id1==""?0:1;
		if(id2==0) {
			//添加操作
			service.addRole(role);
			//拿到刚刚添加的角色id
			int roleid = service.getRole_idByName(name);
			String []id = request.getParameterValues("id[]");
			Permission_Role pr = null;
			for (int i = 0; i < id.length; i++) {
				pr = new Permission_Role();
				pr.setRid(roleid);
				pr.setPid(Integer.parseInt(id[i]));
				service.addPermission_role(pr);
			}
		}else {
			//修改操作
			String []id = request.getParameterValues("id[]");
			role.setId(Integer.parseInt(id1));
			service.updateRoleInfo(role);
			service.deletePermission_role(Integer.parseInt(id1));
			Permission_Role pr = null;
			for (int i = 0; i < id.length; i++) {
				pr = new Permission_Role();
				pr.setRid(Integer.parseInt(id1));
				pr.setPid(Integer.parseInt(id[i]));
				service.addPermission_role(pr);
			}
		}
		out.print("1");
		out.flush();
		out.close();
	}
	//删除一个角色信息
	@RequestMapping("/deleteRoleInfo")
	@ResponseBody
	public String deleteRoleInfo(int id) {
		System.out.println("角色id为："+id);
		//删除一个角色前，看是否已经被赋予用户，如果是，则不能删除
		User_Role ur = service.getUser_Role(id);
		if(ur!=null) {
			return "0";
		}else {
			service.deleteRoleInfo(id);
			service.deletePermission_role(id);
			return "1";
		}
	}
	//查询单个角色下的所有权限
	@RequestMapping("/querymenuInfo")
	@ResponseBody
	public String querymenuInfo(int id,HttpServletRequest request) {
		HttpSession session = request.getSession();
		List<Permissions> list = service.querymenuInfo(id);
		session.setAttribute("querymenuInfo", list);
		return "1";
	}
	//查询所有角色(不分页)
	@RequestMapping("/getRole")
	@ResponseBody
	public String getRole(HttpServletRequest request) {
		String id =request.getParameter("id");
		HttpSession session = request.getSession();
		session.setAttribute("getUserId", id);
		List<Roles> list = service.getAllRoles();
		session.setAttribute("RoleList", list);
		return "1";
	}
	//授予用户角色
	@RequestMapping("/addUserRole")
	@ResponseBody
	public int addUserRole(HttpServletRequest request) {
		User_Role role = null;
		HttpSession session = request.getSession();
		String id1 = (String) session.getAttribute("getUserId");
		String[] role_id = request.getParameterValues("id[]");
		for(int i=0;i<role_id.length;i++){
			role = new User_Role();
			role.setU_id(Integer.parseInt(id1));
			role.setR_id(Integer.parseInt(role_id[i]));
			service.addUserRole(role);
		}	
		return 1;
	}	
	//查询用户拥有的角色
	@RequestMapping("/cancelRole")
	@ResponseBody
	public int cancelRole(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		session.setAttribute("userid", id);
		List<Roles> list = service.selectAllRoles(Integer.parseInt(id));
		session.setAttribute("RoleList1", list);
		return 0;
	}
	//修改用户角色
	@RequestMapping("/updateUserRole")
	@ResponseBody
	public int updateUserRole(HttpServletRequest request) {
		User_Role role = null;
		HttpSession session = request.getSession();
		String id1 = (String) session.getAttribute("userid");
		String[] role_id = request.getParameterValues("id[]");
		if(role_id==null) {
			service.delUserRole(Integer.parseInt(id1));
		}else {
			service.delUserRole(Integer.parseInt(id1));
			for(int i=0;i<role_id.length;i++){
				role = new User_Role();
				role.setU_id(Integer.parseInt(id1));
				role.setR_id(Integer.parseInt(role_id[i]));
				service.addUserRole(role);
			}	
		}
		return 1;
	}
}
