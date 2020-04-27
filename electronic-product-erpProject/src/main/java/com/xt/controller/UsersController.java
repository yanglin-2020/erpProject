package com.xt.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.xt.pojo.MDesignProcedureDetails;
import com.xt.pojo.Permissions;
import com.xt.pojo.Users;
import com.xt.service.UsersService;
import com.xt.util.PageDemo;

/**
 * 登录和用户的相关操作
 * 
 * @author yl
 *
 */
@Controller
public class UsersController {

	@Autowired
	UsersService service;

	// 请求的控制器-->跳转到页面
	@RequestMapping("{path}")
	public String path(@PathVariable String path) {
		return path;
	}

	// 登录操作
	@RequestMapping("/loginUser")
	public String login(String u_name, String u_password, HttpSession session, Model model, boolean rememberMe) {
		// 实现登陆认证,由shiro框架完成身份认证
		// 用户存起来
		Users u = service.selectByName(u_name);
		session.setAttribute("username", u_name);
		session.setAttribute("u", u);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(u_name, u_password, rememberMe);
		try {
			subject.login(token);
		} catch (AuthenticationException e) {
			// 认证失败,跳转到login.html,带提示信息
			model.addAttribute("errMsg", "用户名或密码错误");
			model.addAttribute("failUser", u_name);
			return "login";
		}
		// 认证成功，index主页面
		return "redirect:/selectMenus";
	}

	// 查询所有菜单
	@RequestMapping("/selectMenus")
	public String selectMenus(HttpSession session, Model model, String uName) {
		Subject currentUser = SecurityUtils.getSubject();
		String username = (String) currentUser.getPrincipal().toString();
		session.setAttribute("username", username);
		List<Permissions> Menuslist = service.selectMenus(username);
		model.addAttribute("Menuslist", Menuslist);
		return "index";
	}

	// 分页查询所有的用户信息
	@RequestMapping("/getAllUsersInfo")
	public void getAllUsersInfo(HttpServletResponse response, HttpServletRequest request) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		String nowpage = request.getParameter("page");
		String pageSize = request.getParameter("limit");
		String u_name = request.getParameter("name");
		Users u = new Users();
		if (u_name != null && !u_name.equals("") && !u_name.equals("null")) {
			u.setU_name(u_name);
		}
		PageDemo<Users> pd = service.getAllUserInfo(Integer.parseInt(nowpage), Integer.parseInt(pageSize), u);
		PrintWriter out = response.getWriter();
		String str = JSONArray.toJSONString(pd);
		out.print(str);
		out.flush();
		out.close();
	}

	// 添加用户
	@RequestMapping("/addUserInfo")
	@ResponseBody
	public String addUserInfo(HttpServletResponse response, HttpServletRequest request) {
		response.setContentType("text/html;charset=utf-8");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String salt = request.getParameter("salt");
		String phone = request.getParameter("phone");
		String sex = request.getParameter("sex");
		// md5密码加密
		Md5Hash md5 = new Md5Hash(pwd, salt, 2);
		Users u = new Users(name, sex, md5.toString(), salt, phone);
		int row = service.addUserInfo(u);
		return row > 0 ? "成功" : "失败";
	}

	// 删除一个用户
	@RequestMapping("/delUserInfo")
	@ResponseBody
	public String delUserInfo(HttpServletRequest request, HttpSession session) {
		String u_id = request.getParameter("id");
		Users user = (Users) session.getAttribute("u");
		if (Integer.parseInt(u_id) == user.getU_id()) {
			return "失败";
		} else {
			service.deleteUser(Integer.parseInt(u_id));
			return "成功";
		}
	}

	// 修改用户
	@RequestMapping("/updateUserInfo")
	@ResponseBody
	public String updateUserInfo(HttpServletResponse response, HttpServletRequest request) {
		response.setContentType("text/html;charset=utf-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String sex = request.getParameter("sex");
		Users u = new Users();
		u.setU_id(Integer.parseInt(id));
		u.setU_name(name);
		u.setSex(sex);
		u.setPhone(phone);
		int row = service.updateUserInfo(u);
		return row > 0 ? "1" : "0";
	}
}
