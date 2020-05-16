package com.xt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.xt.pojo.SGather;
import com.xt.pojo.SGatherDetails;
import com.xt.service.crkGuanliService;
import com.xt.util.PageDemo;

/**
 * 出入库管理控制类
 * @author long
 *
 */
@Controller
public class RkGuanliController {
	@Autowired
	crkGuanliService service;
	
	/**
	 * 查询已调度的入库单，进行登记
	 */
	@RequestMapping("/selectRuku")
	public void selectRuku(HttpServletResponse response, HttpServletRequest request)  throws IOException {
		response.setContentType("text/html;charset=utf-8");
		String nowPage = request.getParameter("page");
		String pageSize = request.getParameter("limit");
		//获取所有已调度的入库单
		PageDemo<SGather> list = service.SelectSGather(Integer.parseInt(nowPage), Integer.parseInt(pageSize));
		PrintWriter out = response.getWriter();
		String str = JSONArray.toJSONString(list);
		out.print(str);
		out.flush();
		out.close();
	}
	
	/**
	 * 查询已调度的入库单详细信息
	 * @return
	 */
	@RequestMapping("/rukudengji")
	public String rukudengji(HttpSession session,Model model,String id) {
		//根据父级序号查询入库单详细信息
		List<SGatherDetails> list = service.findD_fileById(id);
		model.addAttribute("list",list);
		//获取登记人和登记时间
		String username = (String) session.getAttribute("username");// 登记人名字
		SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = formate.format(new Date());
		model.addAttribute("username", username);
		model.addAttribute("time", time);
		return "ruku-guanli-dengji";
	}
	
	/**
	 * 修改入库表登记，登记人，时间
	 * @return
	 */
	@RequestMapping("/ruku_dengji")
	@ResponseBody
	public int ruku_dengji(String amount,String id, String register, String register_time) {
		SGather sg = new SGather();
		sg.setGather_id(id);
		sg.setRegister(register);
		sg.setRegister_time(register_time);
		sg.setStore_tag("已入库");
		//根据入库单序号修改登记人，登记时间
		int result = service.dengji(sg);
		//根据父级ID修改入库详细表的已登记
		if(result>0) {
			result = service.updateStoreByParent_id(id);
		}
		return result;
	}
	
	/**
	 * 查询已登记的入库单，进行审核
	 */
	@RequestMapping("/RukuShenhe")
	public void RukuShenhe(HttpServletResponse response, HttpServletRequest request)  throws IOException {
		response.setContentType("text/html;charset=utf-8");
		String nowPage = request.getParameter("page");
		String pageSize = request.getParameter("limit");
		//获取所有已登记的入库单
		PageDemo<SGather> list = service.selectDengji(Integer.parseInt(nowPage), Integer.parseInt(pageSize));
		PrintWriter out = response.getWriter();
		String str = JSONArray.toJSONString(list);
		out.print(str);
		out.flush();
		out.close();
	}
	
	/**
	 * 查询已登记的入库单详细信息
	 * @return
	 */
	@RequestMapping("/rukushenhe")
	public String rukushenhe(HttpSession session,Model model,String id) {
		//根据父级序号查询入库单详细信息
		List<SGatherDetails> list = service.findD_fileById(id);
		model.addAttribute("list",list);
		//获取审核人和审核时间
		String username = (String) session.getAttribute("username");// 登记人名字
		SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = formate.format(new Date());
		model.addAttribute("username", username);
		model.addAttribute("time", time);
		return "ruku-guanli-shenhe";
	}
	
	/**
	 * 修改入库表登记，登记人，时间
	 * @return
	 */
	@RequestMapping("/ruku_shenhe")
	@ResponseBody
	public int ruku_shenhe(SGather s) {
		//根据入库单序号修改审核人，审核时间和审核标志
		s.setStatus("已完成");
		int result = service.shenhe(s);
		//审核通过的话，就根据入库单序号查询商品id和确认入库数量并修改库存数量
		if(result>0) {
			List<SGatherDetails> list = service.findD_fileById(s.getGather_id());
			for (SGatherDetails ss : list) {
				result = service.addKucun(ss);//循环修改库存数量
			}
		}
		return result;
	}
	
	/**
	 * 查询所有入库单
	 */
	@RequestMapping("/selectAllRuku")
	public void selectAllRuku(HttpServletResponse response, HttpServletRequest request)  throws IOException {
		response.setContentType("text/html;charset=utf-8");
		String nowPage = request.getParameter("page");
		String pageSize = request.getParameter("limit");
		String euUserName = request.getParameter("euUserName");
		SGather s = new SGather();
		s.setGather_id(euUserName);
		//获取所有入库单
		PageDemo<SGather> list = service.SelectAllSGather(Integer.parseInt(nowPage), Integer.parseInt(pageSize),s);
		PrintWriter out = response.getWriter();
		String str = JSONArray.toJSONString(list);
		out.print(str);
		out.flush();
		out.close();
	}
	
	/**
	 * 查询所有入库单详细信息
	 * @return
	 */
	@RequestMapping("/rukuchaxun")
	public String rukuchaxun(Model model,String id) {
		//根据父级序号查询入库单详细信息
		List<SGatherDetails> list = service.findD_fileById(id);
		model.addAttribute("list",list);
		return "ruku-guanli-select-details";
	}
}
