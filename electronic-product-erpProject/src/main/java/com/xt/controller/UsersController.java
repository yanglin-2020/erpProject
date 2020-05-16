package com.xt.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.xt.pojo.GongGao;
import com.xt.pojo.MDesignProcedureDetails;
import com.xt.pojo.Permissions;
import com.xt.pojo.SCell;
import com.xt.pojo.SysLogs;
import com.xt.pojo.Users;
import com.xt.service.UsersService;
import com.xt.util.Config;
import com.xt.util.DanhaoUtil;
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
		// 查询用户访问前五的个人信息
		session.removeAttribute("userInfoList");
		List<Users> userInfoList = service.getUsersInfoCount();
		session.setAttribute("userInfoList", userInfoList);
		try {
			Users u = service.selectByName(u_name);
			session.setAttribute("username", u_name);
			session.removeAttribute("u");
			session.setAttribute("u", u);
			session.setAttribute("u_image", u.getU_image());
			session.setAttribute("gongneng", "0");
			Subject subject = SecurityUtils.getSubject();
			UsernamePasswordToken token = new UsernamePasswordToken(u_name, u_password, rememberMe);
			subject.login(token);
			// 用户访问加1
			service.updateCount();
		} catch (Exception e) {
			// 认证失败,跳转到login.html,带提示信息
			model.addAttribute("errMsg", "用户名或密码错误");
			model.addAttribute("failUser", u_name);
			return "Userlogin";
		}
		// 认证成功，
		String ip = DanhaoUtil.getLocalAddress();// 登录的ip地址
		SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Users u = service.selectByName(u_name);
		// 拿到用户访问量
		session.removeAttribute("count");
		session.setAttribute("count", u.getCount());
		// 拿到用户的总数
		int UsersCount = service.selectAllUserCount();
		session.removeAttribute("UsersCount");
		session.setAttribute("UsersCount", UsersCount);
		// 拿到物料总成本
		double materialMoney = service.getMaterialSumMoney();
		session.removeAttribute("materialMoney");
		session.setAttribute("materialMoney", materialMoney);
		// 拿到产品总数
		int productCount = service.getProductAllCount();
		session.removeAttribute("productCount");
		session.setAttribute("productCount", productCount);
		// 记录单个用户访问量
		service.updateSelfCount(u_name);
		SysLogs sl = new SysLogs(u_name, u.getPhone(), formate.format(new Date()), ip);
		// 拿到用户登录的信息。做一个日志记录
		List<SysLogs> userlist = service.getUserAllLoginInfo();
		for (SysLogs s : userlist) {
			if (u_name.equals(s.getU_name())) {
				// 修改操作
				service.updateUserLoginInfo(formate.format(new Date()), u_name, ip);
				return "redirect:/selectMenus";
			}
		}
		// 添加操作
		service.addUserLoginInfo(sl);
		return "redirect:/selectMenus";
	}

	// 查询所有菜单
	@RequestMapping("/selectMenus")
	public String selectMenus(HttpSession session, Model model, String uName) {
		// 用户访问加1
		service.updateCount();
		// 查询用户访问前五的个人信息
		session.removeAttribute("userInfoList");
		List<Users> userInfoList = service.getUsersInfoCount();
		session.setAttribute("userInfoList", userInfoList);
		Subject currentUser = SecurityUtils.getSubject();
		String username = (String) currentUser.getPrincipal().toString();
		String gongneng = (String) session.getAttribute("gongneng");
		Users u = service.selectByName(username);
		// 记录单个用户访问量
		service.updateSelfCount(username);
		session.setAttribute("u_image", u.getU_image());
		session.removeAttribute("u");
		session.setAttribute("u", u);
		List<Permissions> Menuslist = new ArrayList<Permissions>();
		if (gongneng != null && !gongneng.equals("")) {
			Menuslist = service.selectMenus(username, Integer.parseInt(gongneng));
		} else {
			Menuslist = service.selectMenus(username, 0);
		}
		session.setAttribute("username", username);
		model.addAttribute("Menuslist", Menuslist);
		// 拿到用户访问量
		session.removeAttribute("count");
		session.setAttribute("count", u.getCount());
		// 拿到用户的总数
		int UsersCount = service.selectAllUserCount();
		session.removeAttribute("UsersCount");
		session.setAttribute("UsersCount", UsersCount);
		// 拿到物料总成本
		double materialMoney = service.getMaterialSumMoney();
		session.removeAttribute("materialMoney");
		session.setAttribute("materialMoney", materialMoney);
		// 拿到产品总数
		int productCount = service.getProductAllCount();
		session.removeAttribute("productCount");
		session.setAttribute("productCount", productCount);
		return "index";
	}

	// 功能模块
	@RequestMapping("/gongneng")
	public String gongneng(int gongnengid, HttpSession session, Model model) {
		// 查询用户访问前五的个人信息
		session.removeAttribute("userInfoList");
		List<Users> userInfoList = service.getUsersInfoCount();
		session.setAttribute("userInfoList", userInfoList);
		// 用户访问加1
		service.updateCount();
		// 拿到用户的总数
		int UsersCount = service.selectAllUserCount();
		session.removeAttribute("UsersCount");
		session.setAttribute("UsersCount", UsersCount);
		// 拿到物料总成本
		double materialMoney = service.getMaterialSumMoney();
		session.removeAttribute("materialMoney");
		session.setAttribute("materialMoney", materialMoney);
		// 拿到产品总数
		int productCount = service.getProductAllCount();
		session.removeAttribute("productCount");
		session.setAttribute("productCount", productCount);
		Subject currentUser = SecurityUtils.getSubject();
		String username = (String) currentUser.getPrincipal().toString();
		// 记录单个用户访问量
		service.updateSelfCount(username);
		Users u = service.selectByName(username);
		// 拿到用户访问量
		session.removeAttribute("count");
		session.setAttribute("count", u.getCount());
		List<Permissions> Menuslist = service.selectMenus(username, gongnengid);
		session.setAttribute("username", username);
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

	// 上传商品图片
	@RequestMapping(value = "/uploadImg", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Map<String, Object> uploadImg(@RequestParam("file") MultipartFile file, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// String path =
		// "D:\\毕业项目\\repository\\electronic-product-erpProject\\src\\main\\resources\\static\\images";
		File dir = new File("src/main/resources/static/images");
		File newfile = new File(dir.getAbsolutePath(), file.getOriginalFilename());
		String imgName = file.getOriginalFilename();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			file.transferTo(newfile);
			map.put("msg", imgName);
			map.put("code", 200);
		} catch (IOException e) {
			e.printStackTrace();
			map.put("msg", "erro");
			map.put("code", 0);
		}
		return map;
	}

	// 把个人信息添加到数据库
	@RequestMapping("/addUserDetailInfo")
	@ResponseBody
	public String addUserDetailInfo(HttpServletRequest request, HttpSession session) {
		String imgName = request.getParameter("imgName");// 获的图片的名称
		String trueName = request.getParameter("trueName");
		String birthday = request.getParameter("birthday");
		String email = request.getParameter("email");
		String personl = request.getParameter("personl");// 个性宣言
		String province = request.getParameter("province");// 省份
		String city = request.getParameter("city");// 城市
		String area = request.getParameter("area");// 县、区
		String u_name = (String) session.getAttribute("username");
		String address = province + "/" + city + "/" + area;
		Users u = new Users(u_name, trueName, birthday, address, email, personl, province, city, area);
		if (imgName != null && !imgName.equals("")) {
			String u_image = "./images/" + imgName;
			session.removeAttribute("u_image");
			session.removeAttribute("u");
			session.setAttribute("u_image", u_image);
			u.setU_image(u_image);
		}
		int row = service.addUserDetailInfo(u);
		return row > 0 ? "成功" : "失败";
	}

	// 修改密码时确认旧密码
	@RequestMapping("/querenOldPwd")
	@ResponseBody
	public String querenOldPwd(HttpServletRequest request) {
		String u_name = request.getParameter("u_name");
		String oldpwd = request.getParameter("oldpwd");
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(u_name, oldpwd);
		try {
			subject.login(token);
		} catch (AuthenticationException e) {
			// 认证失败,跳转到login.jsp,带提示信息
			return "0";
		}
		// 认证成功，index主页面
		return "1";
	}

	// 验证码
	@RequestMapping("/yanzhengma")
	@ResponseBody
	public String yanzhengma(HttpServletRequest request) throws Exception {
		String phone = request.getParameter("phone1");
		Config.getCode(phone);
		String random = Config.random;
		System.out.println("验证码为:" + random);
		return random;
	}

	// 修改密码
	@RequestMapping("/updatepwd")
	@ResponseBody
	public String updatepwd(HttpServletRequest request) {
		String newpwd = request.getParameter("newPwd");
		String u_name = request.getParameter("u_name");
		HttpSession session = request.getSession();
		Users u = (Users) session.getAttribute("u");
		String salt = u.getSalt();
		// md5密码加密
		Md5Hash md5 = new Md5Hash(newpwd, salt, 2);
		service.updatepwd(md5.toString(), u_name);
		return "1";
	}

	@RequestMapping("/tiaozhuan")
	public String tiaozhuan(HttpSession session) {
		session.removeAttribute("u");
		session.removeAttribute("username");
		session.removeAttribute("count");
		return "redirect:/Userlogin.html";
	}

	// 查询用户的登录信息
	@RequestMapping("/getUserLoginInfo")
	public void getUserLoginInfo(HttpServletResponse response, HttpServletRequest request) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		String nowpage = request.getParameter("page");
		String pageSize = request.getParameter("limit");
		SysLogs sl = new SysLogs();
		PageDemo<SysLogs> pd = service.getUserLoginInfo(Integer.parseInt(nowpage), Integer.parseInt(pageSize), sl);
		PrintWriter out = response.getWriter();
		String str = JSONArray.toJSONString(pd);
		out.print(str);
		out.flush();
		out.close();
	}

	// 查询最新公告信息
	@RequestMapping("/getGongGaoInfo")
	public void queryGongGao(HttpServletResponse response, HttpServletRequest request) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		String nowpage = request.getParameter("page");
		String pageSize = request.getParameter("limit");
		GongGao gg = new GongGao();
		PageDemo<GongGao> pd = service.getGongGaoInfo(Integer.parseInt(nowpage), Integer.parseInt(pageSize), gg);
		PrintWriter out = response.getWriter();
		String str = JSONArray.toJSONString(pd);
		out.print(str);
		out.flush();
		out.close();
	}

	// 分页查询库存预警信息
	@RequestMapping("/getyjInfo")
	public void queryyjInfo(HttpServletResponse response, HttpServletRequest request) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		String nowpage = request.getParameter("page");
		String pageSize = request.getParameter("limit");
		SCell s = new SCell();
		PageDemo<SCell> pd = service.getyjInfo(Integer.parseInt(nowpage), Integer.parseInt(pageSize), s);
		PrintWriter out = response.getWriter();
		String str = JSONArray.toJSONString(pd);
		out.print(str);
		out.flush();
		out.close();
	}

	// 查询最新公告信息
	@RequestMapping("/getGongGaoAllInfo")
	public void getGongGaoAllInfo(HttpServletResponse response, HttpServletRequest request) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		String nowpage = request.getParameter("page");
		String pageSize = request.getParameter("limit");
		GongGao gg = new GongGao();
		String name = request.getParameter("name");
		gg.setTitle(name);
		PageDemo<GongGao> pd = service.getGongGaoAllInfo(Integer.parseInt(nowpage), Integer.parseInt(pageSize), gg);
		PrintWriter out = response.getWriter();
		String str = JSONArray.toJSONString(pd);
		out.print(str);
		out.flush();
		out.close();
	}
	//添加或修改公告信息
	@RequestMapping("/addOrUpdateGongGaoInfo")
	@ResponseBody
	public String addOrUpdateGongGaoInfo(HttpServletRequest request) {
		String id = request.getParameter("id");//传入id，为空添加操作，不为空修改操作
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String name = request.getParameter("name");
		SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//时间
		if(id != "" && id != null && !id.equals("")) {
			//修改操作
			GongGao gg = new GongGao(Integer.parseInt(id), title, content, formate.format(new Date()), name);
			int row = service.updateGongGao(gg);
			return row>0?"1":"0";
		}else {
			//添加操作
			GongGao gg = new GongGao(title, content, formate.format(new Date()), name);
			int row = service.addGongGao(gg);
			return row>0?"1":"0";
		}
	}
	//删除一个公告信息
	@RequestMapping("/deleteGongGaoInfo")
	@ResponseBody
	public String deleteGongGaoInfo(HttpServletRequest request) {
		String id = request.getParameter("id");
		int row = service.deleteGongGao(id);
		return row>0?"1":"0";
	}
}
