package com.xt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.xt.pojo.D_file;
import com.xt.pojo.MApply;
import com.xt.service.M_apply_Service;
import com.xt.util.PageDemo;
/**
 *  生产计划 		Controller
 * @author CQK
 * 
 *
 */

@Controller
public class M_apply_Controller {
	@Autowired
	M_apply_Service service;
	List<D_file> dfile_list=new ArrayList<D_file>();
	
	//查询产品档案
	@RequestMapping("/getAllD_file")
	public void getAllD_file(HttpServletResponse response,HttpServletRequest request) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		String nowpage = request.getParameter("page");
		String pageSize = request.getParameter("limit");
		PageDemo<D_file> pd = service.getAllM_applyInfo(Integer.parseInt(nowpage),Integer.parseInt(pageSize));
		String str = JSONArray.toJSONString(pd);
		PrintWriter out=response.getWriter();
		out.print(str);
		out.flush();
		out.close();
		
	}
	
	//把产品档案的数据增加到临时表中
	@RequestMapping(value = "/addD_file")
	@ResponseBody
	public int addD_file(@RequestBody D_file dfile) {
		int row=service.addD_fileList(dfile);
		return row;
	}
	
	//查询临时表
	@RequestMapping(value = "/getD_file")
	public String getD_files(Model model){
		List<D_file> dfile_list=service.getD_filesList();
		model.addAttribute("list", dfile_list);
		return "m-list1.html";
	}
	
	//增加生产计划
	@RequestMapping(value = "/addMapply")
	@ResponseBody
	public int addMapply(String registrant,String shijian,String planner,String remark) {
		MApply mapply=new MApply();
		mapply.setRegister(registrant);
		mapply.setRegister_time(shijian);
		mapply.setDesigner(planner);
		mapply.setRemark(remark);
		int row=service.addMApply(mapply);
		return row;
	}
	
	//更改数量
	@RequestMapping(value="/alternum")
	@ResponseBody
	public int alterNum(int shuliang,String productid) {
		int row=service.alterNum(shuliang,productid);
		return row;
	}
	
	//删除产品
	@RequestMapping(value="delD_fileList")
	@ResponseBody
	public int delD_fileList(String id) {
		int row=service.delD_fileList(id);
		return row;
	}
	
	//审核生产计划中没有审核的数据
	@RequestMapping(value="getAllMapplyAudit")
	public void getAllMapplyAudit(HttpServletResponse response,HttpServletRequest request) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		String nowpage = request.getParameter("page");
		String pageSize = request.getParameter("limit");
		MApply ma=new MApply();
		PageDemo<MApply> pd = service.getAllMapplyAudit(Integer.parseInt(nowpage),Integer.parseInt(pageSize),ma);
		String str = JSONArray.toJSONString(pd);
		PrintWriter out=response.getWriter();
		out.print(str);
		out.flush();
		out.close();
	}
	
	//根据产品生产计划编号查询生产计划中的数据
	@RequestMapping(value="getMapplyAuditByid")
	@ResponseBody
	public int getMapplyAuditByid(HttpServletRequest request, HttpSession session) {
		String apply_id=request.getParameter("apply_id");
		MApply mapply=service.getMapplyAuditByid(apply_id);
		session.setAttribute("mapply", mapply);
		return 1;
	}
	
	//产品生产计划审核(通过)
	@RequestMapping(value="approveMapply")
	public String approveMapply(HttpServletRequest request, HttpSession session) {
		String apply_id=request.getParameter("apply_id"); //生产计划编号
		String checker=request.getParameter("checker"); //复核人
		String check_suggestion=request.getParameter("check_suggestion"); //审核意见
		MApply mapply=new MApply();
		mapply.setApply_id(apply_id);
		mapply.setChecker(checker);
		mapply.setCheck_suggestion(check_suggestion);
		SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		mapply.setCheck_time(formate.format(new Date()));
		mapply.setCheck_tag("审核通过");
		service.approveMapply(mapply);
		return "load7";
	}
	
	//产品生产计划审核（不通过）
	@RequestMapping(value="noApproveMapply")
	@ResponseBody
	public int noApproveMapply(HttpServletRequest request, HttpSession session) {
		String apply_id=request.getParameter("apply_id");
		String reason=request.getParameter("reason");
		System.out.println(apply_id+"==="+reason);
		MApply mapply=new MApply();
		mapply.setApply_id(apply_id);
		mapply.setCheck_suggestion(reason);
		mapply.setCheck_tag("审核不通过");
		String name=(String)session.getAttribute("username");
		mapply.setChecker(name);
		SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		mapply.setCheck_time(formate.format(new Date()));
		int row=service.noApproveMapply(mapply);
		return row;
	}
	
	//查询生产计划信息(所有)
	@RequestMapping("allMapply")
	public void allMapply(HttpServletResponse response,HttpServletRequest request) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		String nowpage = request.getParameter("page");
		String pageSize = request.getParameter("limit");
		String apply_id = request.getParameter("apply_id"); //获取页面传来的生产计划编号
		String product_name = request.getParameter("product_name"); //获取页面传来的产品编号
		String check_tag = request.getParameter("check_tag"); //获取页面传来的审核标志
		MApply ma=new MApply();
		ma.setApply_id(apply_id);
		ma.setProduct_name(product_name);
		ma.setCheck_tag(check_tag);
		PageDemo<MApply> pd = service.allMapply(Integer.parseInt(nowpage),Integer.parseInt(pageSize),ma);
		String str = JSONArray.toJSONString(pd);
		PrintWriter out=response.getWriter();
		out.print(str);
		out.flush();
		out.close();
	}
	
	//根据生产计划编号修改审核标志
	@RequestMapping("examination")
	@ResponseBody
	public int examination(HttpServletResponse response,HttpServletRequest request){
		String apply_id=request.getParameter("apply_id");
		MApply mapply=new MApply();
		mapply.setApply_id(apply_id);
		mapply.setCheck_tag("等待审核");
		mapply.setChecker("");
		mapply.setCheck_suggestion("");
		mapply.setCheck_time("");
		int row=service.examination(mapply);
		return row;
	}
	
	//修改生产计划单
	@RequestMapping("updateMapply")
	public String updateMapply(HttpServletResponse response,HttpServletRequest request) {
		String apply_id=request.getParameter("apply_id");
		String amount=request.getParameter("amount");
		String designer=request.getParameter("designer");
		String remark=request.getParameter("remark");
		MApply mapply=new MApply();
		mapply.setApply_id(apply_id);
		mapply.setAmount(amount);
		mapply.setDesigner(designer);
		mapply.setRemark(remark);
		service.updateMapply(mapply);
		return "m_applyall";
	}
	
}
