package com.xt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.xt.pojo.D_file;
import com.xt.pojo.SCell;
import com.xt.service.SafeService;
import com.xt.util.DanhaoUtil;
import com.xt.util.PageDemo;

/**
 * 安全库存配置管理
 * 
 * @author long
 *
 */
@Controller
public class SafeController {

	@Autowired
	SafeService service;

	/**
	 * 查询所有产品信息
	 * 
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/getAllGoods")
	public void getAllGoods(HttpServletResponse response, HttpServletRequest request) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		String nowpage = request.getParameter("page");
		String pageSize = request.getParameter("limit");
		String product_name =request.getParameter("product_name");
		D_file d = new D_file();
		d.setProduct_name(product_name);
		PageDemo<D_file> pd = service.getAllUserInfo(Integer.parseInt(nowpage), Integer.parseInt(pageSize), d);
		PrintWriter out = response.getWriter();
		String str = JSONArray.toJSONString(pd);
		out.print(str);
		out.flush();
		out.close();
	}

	/**
	 * 跳转到add页面，带值
	 */
	@RequestMapping("/forwordAdd")
	public String forwordAdd(HttpSession session, Model model) {
		String username = (String) session.getAttribute("username");// 登记人名字
		SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = formate.format(new Date());
		model.addAttribute("username", username);
		model.addAttribute("time", time);
		return "save-add";
	}

	/**
	 * 添加安全配置单
	 */
	@RequestMapping("/addSavePage")
	@ResponseBody
	public int addSavePage(HttpServletRequest request) {
		String product_name = request.getParameter("product_name");
		String product_id = request.getParameter("product_id");
		String min_amount = request.getParameter("min_amount");
		String max_amount = request.getParameter("max_amount");
		String max_capacity_amount = request.getParameter("max_capacity_amount");
		String register = request.getParameter("register");
		String register_time = request.getParameter("register_time");
		String config = request.getParameter("config");
		SCell s = new SCell();
		s.setProduct_id(product_id);
		s.setProduct_name(product_name);
		s.setMin_amount(min_amount);
		s.setMax_amount(max_amount);
		s.setMax_capacity_amount(max_capacity_amount);
		s.setRegister(register);
		s.setRegister_time(register_time);
		s.setConfig(config);
		// 自动生成库存编号
		String kc_num = DanhaoUtil.getKcBianhao();
		s.setStore_id(kc_num);
		int result = service.addSaveSCell(s);
		//添加成功后，修改产品档案的设计标志为‘已设计‘
		int row = service.updateD_filedesign_cell_tag(product_id);
		return result;
	}

	/**
	 * 查询未复核的安全配置单
	 */
	@RequestMapping("/nofuheSave")
	public void nofuheSave(HttpServletResponse response, HttpServletRequest request) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		String nowpage = request.getParameter("page");
		String pageSize = request.getParameter("limit");
		SCell s = new SCell();
		PageDemo<SCell> pd = service.getNoFuheInfo(Integer.parseInt(nowpage), Integer.parseInt(pageSize), s);
		PrintWriter out = response.getWriter();
		String str = JSONArray.toJSONString(pd);
		out.print(str);
		out.flush();
		out.close();
	}

	/**
	 * 跳转到复核页面，带值
	 */
	@RequestMapping("/SelectFuhe")
	public String SelectFuhe(HttpSession session, Model model, String id) {
		System.out.println("--------------------------" + id);
		SCell scel = service.getScellByid(id);// 根据序号查询库存信息

		String username = (String) session.getAttribute("username");// 复核人名字
		SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String checkTime = formate.format(new Date());// 复核时间
		model.addAttribute("username", username);
		model.addAttribute("checkTime", checkTime);
		model.addAttribute("s", scel);
		return "Save-fuhe";
	}

	/**
	 * 复核配置单
	 */
	@RequestMapping("/fuhe")
	@ResponseBody
	public int fuhe(String fh, SCell s) {
		int result = service.fuheSCell(s, fh);
		return result;
	}

	/**
	 * 查询库存单元所有信息(有条件就模糊查询)
	 * 
	 * @throws IOException
	 */
	@RequestMapping("/AllS_cell")
	public void AllS_cell(HttpServletResponse response, HttpServletRequest request) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		String nowpage = request.getParameter("page");
		String pageSize = request.getParameter("limit");
		String product_name = request.getParameter("euUserName");// 获取查询条件，进行模糊查询
		SCell s = new SCell();
		s.setProduct_name(product_name);
		PageDemo<SCell> pd = service.getS_cellInfo(Integer.parseInt(nowpage), Integer.parseInt(pageSize), s);
		PrintWriter out = response.getWriter();
		String str = JSONArray.toJSONString(pd);
		out.print(str);
		out.flush();
		out.close();
	}
	
	/**
	 * 跳转到修改页面，带值
	 */
	@RequestMapping("/UpdateScellInfo")
	public String UpdateScellInfo(HttpSession session, Model model, String id) {
		SCell scel = service.getScellByid(id);// 根据序号查询库存信息
		model.addAttribute("s", scel);
		return "Save-update";
	}
	
	/**
	 * 修改库存配置单
	 * @param sc
	 * @return
	 */
	@RequestMapping("/updateScell")
	@ResponseBody
	public int updateScell(SCell sc) {
		int result = service.updateSCell(sc);
		return result;
	}
	
}
