package com.xt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.soap.AddressingFeature.Responses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.xt.pojo.MDesignProcedureDetails;
import com.xt.pojo.MDesignProcedureModule;
import com.xt.pojo.MManufacture;
import com.xt.pojo.MProcedure;
import com.xt.pojo.SGather;
import com.xt.pojo.SGatherDetails;
import com.xt.service.MManufactureService;
import com.xt.service.ProductionRegisterService;
import com.xt.service.SgatherService;
import com.xt.util.DanhaoUtil;
import com.xt.util.PageDemo;
import com.xt.util.ShengchanUtil;

/**
 * 
 * @CQK Administrator 生产登记Controller
 *
 */
@Controller
public class ProductionRegisterController {

	@Autowired
	ProductionRegisterService service;
	@Autowired
	MManufactureService service1;
	@Autowired
	SgatherService service2;

	// 获取生产总表已审核的数据
	@RequestMapping(value = "getManufacture")
	public void getManufacture(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		String product_name = request.getParameter("product_name");
		String nowpage = request.getParameter("page");
		String pageSize = request.getParameter("limit");
		MManufacture manufacture = new MManufacture();
		manufacture.setProduct_name(product_name);
		manufacture.setCheck_tag("审核通过");
		manufacture.setManufacture_procedure_tag("未完工");
		PageDemo<MManufacture> pd = service.getManufacture(Integer.parseInt(nowpage), Integer.parseInt(pageSize),
				manufacture);
		String str = JSONArray.toJSONString(pd);
		PrintWriter out = response.getWriter();
		out.print(str);
		out.flush();
		out.close();
	}

	// 获取Manufacture_id
	@RequestMapping("addManufacture_id")
	@ResponseBody
	public int addManufacture_id(HttpServletRequest request, HttpServletResponse response) {
		String manufacture_id = request.getParameter("manufacture_id");
		String product_idcqk = request.getParameter("product_id");
		MManufacture manufacture = new MManufacture();
		manufacture.setManufacture_id(manufacture_id);
		HttpSession session = request.getSession();
		session.removeAttribute("manufacture_idccqk");
		session.setAttribute("manufacture_idccqk", manufacture_id);
		session.removeAttribute("manufacture");
		session.setAttribute("manufacture", manufacture);
		session.removeAttribute("product_idcqk");
		session.setAttribute("product_idcqk", product_idcqk);
		return 1;
	}

	// 根据派工单编号查询生产总表
	@RequestMapping("getManufactureByid")
	public String getManufactureByid(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		MManufacture manufacture = (MManufacture) session.getAttribute("manufacture");
		MManufacture mManufacture = service.getManufactureByid(manufacture);
		session.removeAttribute("mManufacture");
		session.setAttribute("mManufacture", mManufacture);
		// 根据工单制定人查询生产工序表
		String product_id = (String) session.getAttribute("product_idcqk");
		List<MDesignProcedureDetails> list = service1.getProcedureByProduct_id(product_id);
		session.removeAttribute("mprocedure");
		session.setAttribute("mprocedure", list);
		return "productionRegisterDetailed";
	}

	@RequestMapping("getManufactureByid2")
	public String getManufactureByid2(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		MManufacture manufacture = (MManufacture) session.getAttribute("manufacture");
		MManufacture mManufacture = service.getManufactureByid(manufacture);
		session.removeAttribute("mManufacture");
		session.setAttribute("mManufacture", mManufacture);
		// 根据工单制定人查询生产工序表
		String product_id = (String) session.getAttribute("product_idcqk");
		List<MDesignProcedureDetails> list = service1.getProcedureByProduct_id(product_id);
		session.removeAttribute("mprocedure");
		session.setAttribute("mprocedure", list);
		return "productionRegisterDetailed2";
	}

	// 根据id拿到每道工序需要的物料进行一个登记(yl)
	@RequestMapping("/getMaterialByIDscdj")
	public String getMaterialByID(HttpServletRequest request, Model model, HttpSession session) {
		String id = request.getParameter("id");
		String parent_id = request.getParameter("parent_id");
		String procedurename = request.getParameter("procedurename");// 工序名称
		List<MDesignProcedureModule> list = service1.getMaterialByID(id);
		model.addAttribute("scdanhao", ShengchanUtil.getscpgd());
		model.addAttribute("procedurename", procedurename);
		model.addAttribute("lookProcedureModule", list);
		// session.setAttribute("manufacture_id", ShengchanUtil.getscpgd());// 派工单编号
		// 拿到产品所需物料的总成本
		String marterialSumMoney = service1.getMarterialSumMoney(id);
		session.setAttribute("marterialSumMoney", marterialSumMoney);// 物料总成本
		session.removeAttribute("idyl");
		session.setAttribute("idyl", parent_id);
		session.removeAttribute("procedurenameyl");
		session.setAttribute("procedurenameyl", procedurename);
		return "shengchandengji.html";
	}

	@RequestMapping("/getMaterialByIDscdj2")
	public String getMaterialByID2(HttpServletRequest request, Model model, HttpSession session) {
		String id = request.getParameter("id");
		String parent_id = request.getParameter("parent_id");
		String procedurename = request.getParameter("procedurename");// 工序名称
		List<MDesignProcedureModule> list = service1.getMaterialByID(id);
		model.addAttribute("scdanhao", ShengchanUtil.getscpgd());
		model.addAttribute("procedurename", procedurename);
		model.addAttribute("lookProcedureModule", list);
		// session.setAttribute("manufacture_id", ShengchanUtil.getscpgd());// 派工单编号
		// 拿到产品所需物料的总成本
		String marterialSumMoney = service1.getMarterialSumMoney(id);
		session.setAttribute("marterialSumMoney", marterialSumMoney);// 物料总成本
		session.removeAttribute("idyl");
		session.setAttribute("idyl", parent_id);
		session.removeAttribute("procedurenameyl");
		session.setAttribute("procedurenameyl", procedurename);
		return "shengchanfuhedetail";
	}

	// 修改工序表状态
	@RequestMapping("/updateGongXuStatus")
	public String updateGongXuStatus(HttpSession session) {
		String id = (String) session.getAttribute("idyl");
		String procedurename = (String) session.getAttribute("procedurenameyl");
		String manufacture_id = (String) session.getAttribute("manufacture_idccqk");
		service.updateGongXuStatus(id, procedurename);
		service.updatesczbStatus(manufacture_id);
		return "redirect:/getManufactureByid";
	}

	// 获取生产总表已审核的数据但是status没有审核的数据
	@RequestMapping(value = "getManufacturefuhe")
	public void getManufacturefuhe(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		String product_name = request.getParameter("product_name");
		String nowpage = request.getParameter("page");
		String pageSize = request.getParameter("limit");
		MManufacture manufacture = new MManufacture();
		manufacture.setProduct_name(product_name);
		PageDemo<MManufacture> pd = service.getManufacturefuhe(Integer.parseInt(nowpage), Integer.parseInt(pageSize),
				manufacture);
		String str = JSONArray.toJSONString(pd);
		PrintWriter out = response.getWriter();
		out.print(str);
		out.flush();
		out.close();
	}

	// 修改工序表状态
	@RequestMapping("/updateGongXuStatus2")
	public String updateGongXuStatus2(HttpSession session) {
		String id = (String) session.getAttribute("idyl");
		String procedurename = (String) session.getAttribute("procedurenameyl");
		String manufacture_id = (String) session.getAttribute("manufacture_idccqk");
		service.updateGongXuStatus2(id, procedurename);
		service.updatesczbStatus2(manufacture_id);
		return "shengchanfuhe";
	}

	// 修改工序表状态
	@RequestMapping("/updateGongXuStatus3")
	@ResponseBody
	public int updateGongXuStatus3(HttpSession session, HttpServletRequest request) {
		String jiaonum = request.getParameter("jiaonum");
		session.removeAttribute("jiaonum");
		session.setAttribute("jiaonum", jiaonum);
		String id = (String) session.getAttribute("idyl");
		String procedurename = request.getParameter("procedurename");
		String manufacture_id = (String) session.getAttribute("manufacture_idccqk");
		service.updateGongXuStatus3(id, procedurename);
		service.updatesczbStatus3(manufacture_id);
		return 1;
	}

	// 修改工序表状态
	@RequestMapping("/updateGongXuStatus4")
	@ResponseBody
	public int updateGongXuStatus4(HttpSession session, HttpServletRequest request) {
		String id = (String) session.getAttribute("idyl");
		String procedurename = request.getParameter("procedurename");
		String manufacture_id = (String) session.getAttribute("manufacture_idccqk");
		service.updateGongXuStatus4(id, procedurename);
		service.updatesczbStatus4(manufacture_id);
		return 1;
	}

	// 修改生产总表的字段，表示这个产品已经完工
	@RequestMapping("/updatesczbIswg")
	@ResponseBody
	public int updatesczbIswg(HttpServletRequest request, HttpSession session) {
		String remark = request.getParameter("remark");// 备注
		String manufacture_id = request.getParameter("manufacture_id");
		String checkerName = (String) session.getAttribute("username");// 复核人姓名
		SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = formate.format(new Date());// 复核的时间
		MManufacture mm = new MManufacture();
		mm.setRemark(remark);
		mm.setCheck_time(time);
		mm.setChecker(checkerName);
		mm.setManufacture_id(manufacture_id);
		int row = service.updatesczbIswg(mm);
		//产品完工，入库调度
		MManufacture m = service.queryManufactureInfo(manufacture_id);
		String rukuDanHao = DanhaoUtil.getRuKuDanHao() + service2.getId();// 入库单编号 
		SGather s = new SGather(rukuDanHao, m.getAmount(),(m.getModule_cost_price_sum()+m.getLabour_cost_price_sum()), m.getRemark(),
				m.getRegister(), m.getRegister(), m.getRegister_time());
		service.insertmmRukuDan(s);
		SGatherDetails sg =new SGatherDetails(rukuDanHao, m.getProduct_id(), m.getProduct_name(), 
				m.getProduct_describe(), m.getAmount(), (m.getModule_cost_price_sum()+m.getLabour_cost_price_sum()));
		service.insertmmDetailRuKuDan(sg);
		return row > 0 ? 1 : 0;
	}

	// 获取生产总表已审核的数据
	@RequestMapping(value = "getManufacturesuccess")
	public void getManufacturesuccess(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		String product_name = request.getParameter("product_name");
		String nowpage = request.getParameter("page");
		String pageSize = request.getParameter("limit");
		MManufacture manufacture = new MManufacture();
		manufacture.setProduct_name(product_name);
		manufacture.setCheck_tag("审核通过");
		manufacture.setManufacture_procedure_tag("已完工");
		PageDemo<MManufacture> pd = service.getManufacture(Integer.parseInt(nowpage), Integer.parseInt(pageSize),
				manufacture);
		String str = JSONArray.toJSONString(pd);
		PrintWriter out = response.getWriter();
		out.print(str);
		out.flush();
		out.close();
	}
}
