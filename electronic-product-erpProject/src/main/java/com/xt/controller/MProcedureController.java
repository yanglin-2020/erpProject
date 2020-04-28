package com.xt.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.xt.pojo.MProcedure;
import com.xt.service.MProcedureService;
import com.xt.util.PageDemo;
/**
 * 生产计划
 * @author asus
 *
 */
@Controller
public class MProcedureController {
	@Autowired
	MProcedureService service;
	
	/**
	 * 分页查询产品计划
	 * @param page
	 * @param limit
	 * @param name
	 * @return
	 */
	@RequestMapping("/MprocedureAll")
	@ResponseBody
	public String MprocedureAll(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int limit,String name,String bh,String change){
		MProcedure md = new MProcedure();
		md.setProcedure_Finish_Tag(bh);//审核状态
		md.setProcedure_Name(name);
		md.setProcedure_Transfer_Tag(change);
		PageDemo<MProcedure> pd = service.getAllMapp(page, limit, md);
		String str = JSONArray.toJSONString(pd);
		return str;
	}
	
	/**
	 * 审核产品设计
	 * @param page
	 * @param limit
	 * @param name
	 * @return
	 */
	@RequestMapping("/Mprocedureshenhe")
	@ResponseBody
	public String Mprocedureshenhe(Integer id,String bh,@RequestParam(defaultValue = " ") String reason,HttpSession session){
		MProcedure md = new MProcedure();
		md.setId(id);
		md.setProcedure_Finish_Tag(bh);
		if(bh.equals("已审核")) {
			md.setProcedure_Transfer_Tag("已审核");
		}
		int count = service.mappUpdate(md);
		String str = JSONArray.toJSONString(count);
		return str;
	}
}
