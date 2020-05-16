package com.xt.controller;

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
import com.xt.pojo.MApply;
import com.xt.pojo.MDesignProcedureDetails;
import com.xt.pojo.MDesignProcedureModule;
import com.xt.pojo.MManufacture;
import com.xt.service.MManufactureService;
import com.xt.util.PageDemo;
import com.xt.util.ShengchanUtil;

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

	// 打开生产派工单(yl)
	@RequestMapping("/openscpgd")
	@ResponseBody
	public String openscpgd(HttpServletRequest request, HttpSession session) {
		String product_id = request.getParameter("product_id");// 产品id
		String product_describe = request.getParameter("product_describe");// 物料的描述
		String product_name = request.getParameter("product_name");// 产品名字
		String amount = request.getParameter("amount");// 产品的数量
		SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		session.setAttribute("sctime", formate.format(new Date()));// 登记的时间
		session.setAttribute("scproduct_id", product_id);
		session.setAttribute("scproduct_describe", product_describe);
		session.setAttribute("scproduct_name", product_name);
		session.setAttribute("scamount", amount);
		// 根据产品id拿到产品所需的工序
		List<MDesignProcedureDetails> list = service.getProcedureByProduct_id(product_id);
		session.removeAttribute("scProcedureDetails");
		session.setAttribute("scProcedureDetails", list);
		//拿到产品所需工序的总成本
		String procedureSumMoney = service.getProcedureSumMoney(product_id);
		session.removeAttribute("procedureSumMoney");
		session.setAttribute("procedureSumMoney", procedureSumMoney);
		return "成功";
	}
	@RequestMapping("/openscpgd1")
	@ResponseBody
	public String openscpgd1(HttpServletRequest request, HttpSession session) {
		String product_id = (String)session.getAttribute("scproduct_id");//产品的编号
		String product_describe = (String)session.getAttribute("scproduct_describe");// 物料的描述
		String product_name = (String)session.getAttribute("scproduct_name");// 产品名字
		String amount = (String)session.getAttribute("scamount");// 产品的数量
		String sctime = (String)session.getAttribute("sctime");
		session.removeAttribute("sctime");
		session.setAttribute("sctime", sctime);// 登记的时间
		session.removeAttribute("scproduct_id");
		session.setAttribute("scproduct_id", product_id);
		session.removeAttribute("scproduct_describe");
		session.setAttribute("scproduct_describe", product_describe);
		session.removeAttribute("scproduct_name");
		session.setAttribute("scproduct_name", product_name);
		session.removeAttribute("scamount");
		session.setAttribute("scamount", amount);
		// 根据产品id拿到产品所需的工序
		List<MDesignProcedureDetails> list = service.getProcedureByProduct_id(product_id);
		session.removeAttribute("scProcedureDetails");
		session.setAttribute("scProcedureDetails", list);
		return "成功";
	}
	// 根据id拿到每道工序需要的物料(yl)
	@RequestMapping("/getMaterialByID")
	public String getMaterialByID(HttpServletRequest request, Model model,HttpSession session) {
		String id = request.getParameter("id");
		String procedurename = request.getParameter("procedurename");//工序名称
		List<MDesignProcedureModule> list = service.getMaterialByID(id);
		model.addAttribute("scdanhao",ShengchanUtil.getscpgd());
		model.addAttribute("procedurename", procedurename);
		model.addAttribute("lookProcedureModule", list);
		session.setAttribute("manufacture_id", ShengchanUtil.getscpgd());//派工单编号
		//拿到产品所需物料的总成本
		String marterialSumMoney = service.getMarterialSumMoney(id);
		session.setAttribute("marterialSumMoney", marterialSumMoney);//物料总成本
		return "lookProceduremodule.html";
	}
	@RequestMapping("/getMaterialByID1")
	public String getMaterialByID1(HttpServletRequest request, Model model,HttpSession session) {
		String id = request.getParameter("id");
		String procedurename = request.getParameter("procedurename");//工序名称
		List<MDesignProcedureModule> list = service.getMaterialByID(id);
		model.addAttribute("scdanhao",ShengchanUtil.getscpgd());
		model.addAttribute("procedurename", procedurename);
		model.addAttribute("lookProcedureModule", list);
		session.setAttribute("manufacture_id", ShengchanUtil.getscpgd());//派工单编号
		//拿到产品所需物料的总成本
		String marterialSumMoney = service.getMarterialSumMoney(id);
		session.setAttribute("marterialSumMoney", marterialSumMoney);//物料总成本
		return "lookProceduremodule1.html";
	}
	//保存生产派工单单(yl)
	@RequestMapping("/saveScpgd")
	public String saveScpgd(HttpServletRequest request, HttpSession session) {
		String manufacture_id =(String)session.getAttribute("manufacture_id");//派工单编号
		String product_id = (String)session.getAttribute("scproduct_id");//产品的编号
		String product_describe = (String)session.getAttribute("scproduct_describe");// 物料的描述
		String product_name = (String)session.getAttribute("scproduct_name");// 产品名字
		String amount = (String)session.getAttribute("scamount");// 产品的数量
		String sctime = (String)session.getAttribute("sctime");//登记的时间 
		String designer = request.getParameter("designer");//设计人
		String remark = request.getParameter("remark");//备注
		String procedureSumMoney = (String)session.getAttribute("procedureSumMoney");//工序总成本
		String marterialSumMoney = (String)session.getAttribute("marterialSumMoney");//物料总成本
		String register =(String)session.getAttribute("username");//登记人
		MManufacture mm = new MManufacture(manufacture_id, product_id, product_name, Integer.parseInt(amount), product_describe, 
				Double.parseDouble(marterialSumMoney),Double.parseDouble(procedureSumMoney) , designer, register, sctime, remark);
		service.saveScpgd(mm);
		//保存完后，修改mapply的字段
		service.updateMapply_manufacture_tag(product_id);
		return "load8";
	}
	//根据生产派工单编号拿到详细信息做复核(yl)
	@RequestMapping("/getMManufactureDetailInfo")
	@ResponseBody
	public String getMManufactureDetailInfo(HttpServletRequest request, HttpSession session) {
		String manufacture_id = request.getParameter("manufacture_id");//产派工单编号
		String product_id = request.getParameter("product_id");//产品编号
		// 根据产品id拿到产品所需的工序
		List<MDesignProcedureDetails> list = service.getProcedureByProduct_id(product_id);
		session.removeAttribute("scfuProcedureDetails");
		session.setAttribute("scfuProcedureDetails", list);
		//根据生产派工单编号拿到详细信息做复核
		MManufacture MManufacturelist = service.getMManufactureDetailInfo(manufacture_id);
		session.removeAttribute("fuheMManufacture");
		session.setAttribute("fuheMManufacture", MManufacturelist);
		return "成功";
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
