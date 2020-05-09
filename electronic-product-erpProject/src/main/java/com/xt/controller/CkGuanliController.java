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
import com.xt.pojo.SPay;
import com.xt.pojo.SPayDetails;
import com.xt.service.ckGuanliService;
import com.xt.util.PageDemo;

/**
 * 出入库管理控制类
 * @author long
 *
 */
@Controller
public class CkGuanliController {
	@Autowired
	ckGuanliService service;
	
	/**
	 * 查询已调度的出库单，进行登记
	 */
	@RequestMapping("/selectChuku")
	public void selectChuku(HttpServletResponse response, HttpServletRequest request)  throws IOException {
		response.setContentType("text/html;charset=utf-8");
		String nowPage = request.getParameter("page");
		String pageSize = request.getParameter("limit");
		//获取所有已调度的出库单
		PageDemo<SPay> list = service.SelectSPay(Integer.parseInt(nowPage), Integer.parseInt(pageSize));
		PrintWriter out = response.getWriter();
		String str = JSONArray.toJSONString(list);
		out.print(str);
		out.flush();
		out.close();
	}
	
	/**
	 * 查询已调度的出库单详细信息
	 * @return
	 */
	@RequestMapping("/chukudengji")
	public String chukudengji(HttpSession session,Model model,String id) {
		//根据父级序号查询出库单详细信息
		List<SPayDetails> list = service.findD_fileById(id);
		model.addAttribute("list",list);
		//获取登记人和登记时间
		String username = (String) session.getAttribute("username");// 登记人名字
		SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = formate.format(new Date());
		model.addAttribute("username", username);
		model.addAttribute("time", time);
		return "chuku-guanli-dengji";
	}
	
	/**
	 * 修改入库表登记，登记人，时间
	 * @return
	 */
	@RequestMapping("/chuku_dengji")
	@ResponseBody
	public int chuku_dengji(String amount,int id, String register, String register_time) {
		SPay sg = new SPay();
		sg.setId(id);
		sg.setRegister(register);
		sg.setRegister_time(register_time);
		sg.setStore_tag("已出库");
		//根据出库单序号修改登记人，登记时间
		int result = service.dengji(sg);
		//根据父级ID修改入库详细表的已登记
		if(result>0) {
			result = service.updateStoreByParent_id(id);
		}
		return result;
	}
	
	/**
	 * 查询已登记的出库单，进行审核
	 */
	@RequestMapping("/ChukuShenhe")
	public void ChukuShenhe(HttpServletResponse response, HttpServletRequest request)  throws IOException {
		response.setContentType("text/html;charset=utf-8");
		String nowPage = request.getParameter("page");
		String pageSize = request.getParameter("limit");
		//获取所有已登记的出库单
		PageDemo<SPay> list = service.selectDengji(Integer.parseInt(nowPage), Integer.parseInt(pageSize));
		PrintWriter out = response.getWriter();
		String str = JSONArray.toJSONString(list);
		out.print(str);
		out.flush();
		out.close();
	}
	
	/**
	 * 查询已登记的出库单详细信息
	 * @return
	 */
	@RequestMapping("/chukushenhe")
	public String chukushenhe(HttpSession session,Model model,String id) {
		//根据父级序号查询出库单详细信息
		List<SPayDetails> list = service.findD_fileById(id);
		model.addAttribute("list",list);
		//获取审核人和审核时间
		String username = (String) session.getAttribute("username");// 登记人名字
		SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = formate.format(new Date());
		model.addAttribute("username", username);
		model.addAttribute("time", time);
		return "chuku-guanli-shenhe";
	}
	
	/**
	 * 修改入库表登记，登记人，时间
	 * @return
	 */
	@RequestMapping("/chuku_shenhe")
	@ResponseBody
	public int chuku_shenhe(SPay s) {
		//根据出库单序号修改审核人，审核时间和审核标志
		s.setStatus("已完成");
		int result = service.shenhe(s);
		//审核通过的话，就根据出库单序号查询商品id和确认入库数量并修改库存数量
		if(s.getCheck_tag().equals("审核通过") && result>0) {
			List<SPayDetails> list = service.findD_fileById(s.getId().toString());
			for (SPayDetails ss : list) {
				result = service.updateKucun(ss);//循环修改库存数量
			}
		}
		return result;
	}
	
	/**
	 * 查询所有出库单
	 */
	@RequestMapping("/selectAllChuku")
	public void selectAllChuku(HttpServletResponse response, HttpServletRequest request)  throws IOException {
		response.setContentType("text/html;charset=utf-8");
		String nowPage = request.getParameter("page");
		String pageSize = request.getParameter("limit");
		String euUserName = request.getParameter("euUserName");
		SPay s = new SPay();
		s.setPay_id(euUserName);
		//获取所有出库单
		PageDemo<SPay> list = service.SelectAllSPay(Integer.parseInt(nowPage), Integer.parseInt(pageSize),s);
		PrintWriter out = response.getWriter();
		String str = JSONArray.toJSONString(list);
		out.print(str);
		out.flush();
		out.close();
	}
	
	/**
	 * 查询所有出库单详细信息
	 * @return
	 */
	@RequestMapping("/chukuchaxun")
	public String chukuchaxun(Model model,String id) {
		//根据父级序号查询出库单详细信息
		List<SPayDetails> list = service.findD_fileById(id);
		model.addAttribute("list",list);
		return "chuku-guanli-select-details";
	}
}
