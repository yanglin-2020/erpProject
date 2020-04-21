package com.xt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.xt.pojo.MDesignProcedure;
import com.xt.service.MDesignProcedureService;
import com.xt.util.PageDemo;
/**
 * 产品设计控制类
 * @author asus
 *罗文涛
 */
@Controller
public class MDesignProcedureController {
	@Autowired
	MDesignProcedureService serivce;
	/**
	 * 分页查询产品
	 * @param page
	 * @param limit
	 * @param name
	 * @return
	 */
	@RequestMapping("/mdesignAll")
	@ResponseBody
	public String mdesignAll(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit,String name){
		MDesignProcedure md = new MDesignProcedure();
		md.setProduct_Name(name);
		PageDemo<MDesignProcedure> pd = serivce.getAllMdesign(page, limit, md);
		String str = JSONArray.toJSONString(pd);
		return str;
	}
}
