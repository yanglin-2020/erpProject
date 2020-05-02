package com.xt.controller;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.xt.pojo.D_file;
import com.xt.pojo.MApply;
import com.xt.pojo.MManufacture;
import com.xt.service.MManufactureService;
import com.xt.util.PageDemo;

@Controller
public class MManufactureController {
	@Autowired
	MManufactureService service;

	// 分页查询生产计划
	@RequestMapping("/getAllMapplyInfo")
	public void getAllMapplyInfo(HttpServletResponse response, HttpServletRequest request) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		String nowPage = request.getParameter("page");
		String pageSize = request.getParameter("limit");
		String product_name = request.getParameter("name");
		MApply m = new MApply();
		if (product_name != null && !product_name.equals("") && !product_name.equals("null")) {
			product_name = new String(product_name.getBytes("ISO-8859-1"), "utf-8");
			m.setProduct_name(product_name);
		}
		PageDemo<MApply> pd = service.getAllMapplyInfo(Integer.parseInt(nowPage), Integer.parseInt(pageSize), m);
		PrintWriter out = response.getWriter();
		String str = JSONArray.toJSONString(pd);
		out.print(str);
		out.flush();
		out.close();
	}
	//打开生产派工单
	@RequestMapping("/openscpgd")
	public void openscpgd(HttpServletRequest request) {
		String product_id = request.getParameter("product_id");// 产品id
		String product_describe = request.getParameter("product_describe");// 物料的描述
		String product_name = request.getParameter("product_name");// 产品名字
	}
	
	
	
	// 分页查询派工单
	@RequestMapping("/getAllMManufactureInfo")
	public void getAllMManufactureInfo(HttpServletResponse response, HttpServletRequest request) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		String nowPage = request.getParameter("page");
		String pageSize = request.getParameter("limit");
		String product_name = request.getParameter("name");
		MManufacture mm = new MManufacture();
		if (product_name != null && !product_name.equals("") && !product_name.equals("null")) {
			product_name = new String(product_name.getBytes("ISO-8859-1"), "utf-8");
			mm.setProduct_name(product_name);
		}
		PageDemo<MManufacture> pd = service.getAllMManufacture(Integer.parseInt(nowPage), Integer.parseInt(pageSize),
				mm);
		PrintWriter out = response.getWriter();
		String str = JSONArray.toJSONString(pd);
		out.print(str);
		out.flush();
		out.close();
	}

	// 分页查询派工单审核通过的信息
	@RequestMapping("/getAllMManufactureInfoo")
	public void getAllMapplyInfoo(HttpServletResponse response, HttpServletRequest request) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		String manufacture_id = request.getParameter("manufacture_id");// 派工单编号
		String product_id = request.getParameter("product_id");// 产品编号
		String nowPage = request.getParameter("page");
		String pageSize = request.getParameter("limit");
		String product_name = request.getParameter("product_name");// 产品名称
		MManufacture mm = new MManufacture();
		mm.setProduct_name(product_name);
		mm.setManufacture_id(manufacture_id);
		mm.setProduct_id(product_id);
		PageDemo<MManufacture> pd = service.getAllMManufacturee(Integer.parseInt(nowPage), Integer.parseInt(pageSize),
				mm);
		PrintWriter out = response.getWriter();
		String str = JSONArray.toJSONString(pd);
		out.print(str);
		out.flush();
		out.close();
	}

	// 审核通过
	@RequestMapping("/shenheMManufacture")
	@ResponseBody
	public String shenheMManufacture(HttpServletRequest request, HttpSession session) {
		String manufacture_id = request.getParameter("manufacture_id");// 派工单编号
		MManufacture mm = new MManufacture();
		mm.setManufacture_id(manufacture_id);
		String checkName = (String) session.getAttribute("username");// 审核人
		mm.setChecker(checkName);
		mm.setCheck_tag("审核通过");
		SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		mm.setCheck_time(formate.format(new Date()));// 审核的时间
		service.updateMManufacture(mm);
		return "成功";
	}

	// 复核产品档案(不通过)
	@RequestMapping("/noshenheMManufacture")
	@ResponseBody
	public String nofuheProduct(HttpServletRequest request, HttpSession session) {
		String manufacture_id = request.getParameter("manufacture_id");// 派工单编号
		String remark = request.getParameter("remark");// 审核不通过的理由
		MManufacture mm = new MManufacture();
		mm.setManufacture_id(manufacture_id);
		String checkerName = (String) session.getAttribute("username");// 审核人姓名
		mm.setChecker(checkerName);
		mm.setCheck_tag("审核不通过");
		mm.setRemark(remark);
		SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		mm.setCheck_time(formate.format(new Date()));// 审核的时间
		service.updateMManufacture(mm);
		return "成功";
	}
}
