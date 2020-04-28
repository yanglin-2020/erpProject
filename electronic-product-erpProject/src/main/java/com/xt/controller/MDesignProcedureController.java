package com.xt.controller;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.xt.pojo.MDesignProcedure;
import com.xt.pojo.MDesignProcedureDetails;
import com.xt.pojo.MProcedure;
import com.xt.service.MDesignProcedureDetailsService;
import com.xt.service.MDesignProcedureService;
import com.xt.util.OrderNo;
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
	@Autowired
	MDesignProcedureDetailsService mdserivce;
	/**
	 * 审核标志   S001-0: 等待审核     S001-1: 审核通过    S001-2: 审核不通过 check_Tag
	 * 分页查询产品
	 * @param page
	 * @param limit
	 * @param name
	 * @return
	 */
	@RequestMapping("/mdesignAll")
	@ResponseBody
	public String mdesignAll(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int limit,String name,String bh,String change){
		MDesignProcedure md = new MDesignProcedure();
		md.setChange_Tag(change);//变更状态
		md.setProduct_Name(name);
		md.setCheck_Tag(bh);//审核状态
		PageDemo<MDesignProcedure> pd = serivce.getAllMdesign(page, limit, md);
		String str = JSONArray.toJSONString(pd);
		return str;
	}
	
	/**
	 * 查询物料状态
	 * @param page
	 * @param limit
	 * @param name
	 * @param bh
	 * @param change
	 * @return
	 */
	@RequestMapping("/mdeataslAll")
	@ResponseBody
	public String mdeataslAll(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int limit,String name,String bh,String change){
		MDesignProcedure md = new MDesignProcedure();
		md.setDesign_Module_Change_Tag(change);//变更状态
		md.setProduct_Name(name);
		md.setDesign_Module_Tag(bh);//审核状态
		PageDemo<MDesignProcedure> pd = serivce.getAllMdesign(page, limit, md);
		String str = JSONArray.toJSONString(pd);
		return str;
	}
	
	
	/**
	 * 查询到东西修改
	 * @param id
	 * @param session
	 * @return
	 */
	@RequestMapping("/matrialdesignss")
	public String matrialdesign(String id,HttpSession session) {
		MDesignProcedure md = serivce.findId(id);
		List<MDesignProcedureDetails> pd = mdserivce.findList(id);
		session.setAttribute("md", md);
		session.setAttribute("MdesignProcedure", pd);
		return "Mdesign-list";
	}
	
	@RequestMapping("/bianjiMDesign")
	@ResponseBody
	public String bianji(@ModelAttribute MProcedure mp){
		System.out.println(mp);
		String str = JSONArray.toJSONString(mp);
		return str;
	}
	
	/**
	 * 审核物料设计
	 * @param page
	 * @param limit
	 * @param name
	 * @return
	 */
	@RequestMapping("/mdesignDetailsshenhe")
	@ResponseBody
	public String mdesignDetailsshenhe(String id,String bh,@RequestParam(defaultValue = " ") String reason){
		MDesignProcedure md = new MDesignProcedure();
		md.setId(Integer.parseInt(id));
		md.setDesign_Module_Tag(bh); 
		md.setCheck_Suggestion(reason);
		int count = serivce.mdesUpdate(md);
		String str = JSONArray.toJSONString(count);
		return str;
	}
	
	/**
	 * 审核标志   S001-0: 等待审核     S001-1: 审核通过    S001-2: 审核不通过 check_Tag
	 * 审核产品设计
	 * @param page
	 * @param limit
	 * @param name
	 * @return
	 */
	@RequestMapping("/mdesignshenhe")
	@ResponseBody
	public String mdesignshenhe(String id,String bh,@RequestParam(defaultValue = " ") String reason,HttpSession session){
		MDesignProcedure md = new MDesignProcedure();
		md.setId(Integer.parseInt(id));
		md.setCheck_Tag(bh);
		md.setCheck_Suggestion(reason);
		SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		md.setCheck_Time(formate.format(new Date()));
		String name =(String) session.getAttribute("username");
		md.setChecker(name);
		int count = serivce.mdesUpdate(md);
		String str = JSONArray.toJSONString(count);
		return str;
	}
	/**
	 * 修改物料总计
	 * @param mdprod
	 * @return
	 */
	@RequestMapping("/updateMdesignProcedures")
	@ResponseBody
	public String updateMdesignProcedures(String mdprod,String id){
		List<MDesignProcedureDetails> list = JSON.parseArray(mdprod,MDesignProcedureDetails.class);
		MDesignProcedure mds = new MDesignProcedure();
		for (MDesignProcedureDetails md : list) {
			mds.setModule_Cost_Price_Sum(mds.getModule_Cost_Price_Sum()+(int)md.getModule_Subtotal());
		}
		mds.setDesign_Module_Tag("未审核");//物料审核
		mds.setId(Integer.parseInt(id));
		int pd = serivce.mdesUpdate(mds);
		String str = JSONArray.toJSONString(pd);
		return str;
	}
	
	
	/**
	 * 变更物料总计
	 * @param mdprod
	 * @return
	 */
	@RequestMapping("/updateMdesignProceduresbiangeng")
	@ResponseBody
	public String updateMdesignProceduresbiangeng(String mdprod,String id){
		List<MDesignProcedureDetails> list = JSON.parseArray(mdprod,MDesignProcedureDetails.class);
		MDesignProcedure mds = new MDesignProcedure();
		for (MDesignProcedureDetails md : list) {
			mds.setModule_Cost_Price_Sum(mds.getModule_Cost_Price_Sum()+(int)md.getModule_Subtotal());
		}
		mds.setDesign_Module_Tag("未审核");//物料审核
		mds.setDesign_Module_Change_Tag("更改");
		mds.setId(Integer.parseInt(id));
		int pd = serivce.mdesUpdate(mds);
		String str = JSONArray.toJSONString(pd);
		return str;
	}
	
	/**
	 * 更改产品设计
	 * @param md
	 * @param mdprod
	 * @param session
	 * @return
	 */
	@RequestMapping("/updateMDesign")
	@ResponseBody
	public String updateMDesign(@ModelAttribute MDesignProcedure md,String mdprod,HttpSession session){
		List<MDesignProcedureDetails> mds = JSON.parseArray(mdprod,MDesignProcedureDetails.class);
		for (MDesignProcedureDetails mDesignProcedureDetails : mds) {
			mdserivce.updatemdesignDetails(mDesignProcedureDetails);
			System.out.println(mDesignProcedureDetails);
		}
		SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		md.setChange_Time(formate.format(new Date()));//变更时间
		md.setCheck_Tag("等待审核");//审核状态
		md.setChange_Tag("更改");//变更转态
		String name =(String) session.getAttribute("username");
		md.setChanger(name);//变更人
		int count = serivce.mdesUpdate(md);
		String str = JSONArray.toJSONString(count);
		System.out.println(str);
		return str;
	}
	
	/**
	 * 添加产品设计
	 * @param md
	 * @param mdprod
	 * @param session
	 * @return
	 */
	@RequestMapping("/addMDesignlist")
	@ResponseBody
	public String addMDesignlist(@ModelAttribute MDesignProcedure md,String mdprod,HttpSession session){
		md.setDesign_Id("A"+OrderNo.NextOrderNo());//设计编号
		List<MDesignProcedureDetails> mds = JSON.parseArray(mdprod,MDesignProcedureDetails.class);
		Integer sum = 0;
		for (MDesignProcedureDetails mDesignProcedureDetails : mds) {
			mdserivce.updatemdesignDetails(mDesignProcedureDetails);
			sum+=(Integer)mDesignProcedureDetails.getCost_Price();
			System.out.println(mDesignProcedureDetails);
		}
		SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		md.setRegister_Time(formate.format(new Date()));//登记时间
		md.setCheck_Tag("等待审核");//审核状态
		md.setChange_Tag("未更改");//变更转态
		md.setDesign_Module_Change_Tag("未变更");
		md.setDesign_Module_Tag("未变更");
		md.setModule_Cost_Price_Sum(sum);
		String name =(String) session.getAttribute("username");
		md.setRegister(name);//登记人
		int count = serivce.mdesadd(md);
		String str = JSONArray.toJSONString(count);
		System.out.println(str);
		return str;
	}
	
	/**
	 * 审核标志   S001-0: 等待审核     S001-1: 审核通过    S001-2: 审核不通过 check_Tag
	 * 修改产品设计
	 * @param page
	 * @param limit
	 * @param name
	 * @return
	 */
	@RequestMapping("/updateMdesignProce")
	@ResponseBody
	public String updateMdesignProce(@ModelAttribute MDesignProcedure md,HttpSession session){
		SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		md.setChange_Time(formate.format(new Date()));//变更时间
		md.setCheck_Tag("等待审核");//审核状态
		md.setChange_Tag("更改");//变更转态
		String name =(String) session.getAttribute("username");
		md.setChanger(name);//变更人
		int count = serivce.mdesUpdate(md);
		String str = JSONArray.toJSONString(count);
		System.out.println(str);
		return str;
	}
	
	/**
	 * 添加产品设计
	 * @param md
	 * @param session
	 * @return
	 */
	@RequestMapping("/addMdesignProce")
	@ResponseBody
	public String addMdesignProce(@ModelAttribute MDesignProcedure md,HttpSession session){
		md.setDesign_Id("A"+OrderNo.NextOrderNo());//设计编号
		md.setProduct_Id("C"+OrderNo.NextOrderNo());//产品编号
		md.setCheck_Tag("等待审核");//等待审核
		md.setDesign_Module_Tag("未设计");//工序物料设计标志 
		md.setDesign_Module_Change_Tag("未变更");//工序物料变更标志
		md.setChange_Tag("未变更");//变更标志
		SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		md.setRegister_Time(formate.format(new Date()));
		String name =(String) session.getAttribute("username");
		md.setChecker(name);
		int count = serivce.mdesadd(md);
		String str = JSONArray.toJSONString(count);
		System.out.println(str);
		return str;
	}
	
}
