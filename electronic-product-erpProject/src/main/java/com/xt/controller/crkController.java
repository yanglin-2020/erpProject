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
import com.xt.pojo.D_file;
import com.xt.pojo.SGather;
import com.xt.pojo.SGatherDetails;
import com.xt.pojo.SPay;
import com.xt.pojo.SPayDetails;
import com.xt.service.CrkService;
import com.xt.util.DanhaoUtil;
import com.xt.util.PageDemo;

/**
 * 出入库调度的控制类
 * 
 * @author long
 *
 */
@Controller
public class crkController {
	@Autowired
	CrkService service;

	/**
	 * 查询已登记的出库单信息
	 * 
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/SPay_store")
	public void SPay_store(HttpServletResponse response, HttpServletRequest request) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		String nowPage = request.getParameter("page");
		String pageSize = request.getParameter("limit");
		PageDemo<SPay> cklist = service.SelectAllSPay(Integer.parseInt(nowPage), Integer.parseInt(pageSize));
		PrintWriter out = response.getWriter();
		String str = JSONArray.toJSONString(cklist);
		out.print(str);
		out.flush();
		out.close();
	}

	/**
	 * 查询已申请的出库单详细信息
	 * 
	 * @return
	 */
	@RequestMapping("/chukudiaodu")
	public String chukudiaodu(HttpSession session, Model model, String id) {
		// 根据父级序号查询出库单详细信息
		List<SPayDetails> spd = service.findD_fileById(id);
		model.addAttribute("list", spd);

		// 获取登记人和登记时间
		String username = (String) session.getAttribute("username");// 登记人名字
		SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = formate.format(new Date());
		model.addAttribute("username", username);
		model.addAttribute("time", time);
		return "kucun-chuku-details";
	}

	/**
	 * 插入出库详细表数据，添加已出库件数
	 * 
	 * @return
	 */
	@RequestMapping("/chuku_details")
	@ResponseBody
	public int chuku_details(String paid_amount, String spid, String id,String attemper,String attemper_time) {
		// 根据商品ID修改出库详细表
		int result = service.chukuDiaodu(paid_amount, id);
		// 查询所有出库详细记录，若都已调度完成，则修改根据出库单序号修改已调度
		List<SPayDetails> list = service.findD_fileById(id);// 根据父级序号查询已登记还未调度的商品信息
		if (list.size() == 0) {
			int updateStroe_tag = service.updateStore_tag(id,attemper,attemper_time);
		}
		return result;
	}

	/**
	 * 查询已申请的入库单信息
	 * 
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/SGather_store")
	public void SGather_store(HttpServletResponse response, HttpServletRequest request) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		String nowPage = request.getParameter("page");
		String pageSize = request.getParameter("limit");
		PageDemo<SGather> rklist = service.SelectAllSGather(Integer.parseInt(nowPage), Integer.parseInt(pageSize));//
		PrintWriter out = response.getWriter();
		String str = JSONArray.toJSONString(rklist);
		out.print(str);
		out.flush();
		out.close();
	}

	/**
	 * 查询已登记的入库单详细信息
	 * 
	 * @return
	 */
	@RequestMapping("/rukudiaodu")
	public String rukudiaodu(HttpSession session,Model model, String id) {
		// 根据父级序号查询入库单详细信息
		List<SGatherDetails> spd = service.findD_fileBySGatherId(id);
		model.addAttribute("list", spd);

		// 获取登记人和登记时间
		String username = (String) session.getAttribute("username");// 登记人名字
		SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = formate.format(new Date());
		model.addAttribute("username", username);
		model.addAttribute("time", time);
		return "kucun-ruku-details";
	}

	/**
	 * 插入 入库详细表数据，添加已入库件数
	 * 
	 * @return
	 */
	@RequestMapping("/ruku_details")
	@ResponseBody
	public int ruku_details(String gathered_amount, String spid, String id,String attemper,String attemper_time) {
		// 根据商品ID修改出库详细表
		int result = service.rukuDiaodu(gathered_amount, id);
		// 查询所有入库详细记录，若都已调度完成，则修改根据入库单序号修改已调度
		List<SGatherDetails> list = service.findD_fileBySGatherId(id);// 根据父级序号查询已登记还未调度的商品信息
		if (list.size() == 0) {
			int updateSGatherStroe_tag = service.updateSGatherStore_tag(id,attemper,attemper_time);
		}
		return result;
	}
}
