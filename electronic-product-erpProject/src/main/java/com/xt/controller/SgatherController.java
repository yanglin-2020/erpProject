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
import com.xt.pojo.MManufacture;
import com.xt.pojo.Permissions;
import com.xt.pojo.SGather;
import com.xt.pojo.SGatherDetails;
import com.xt.pojo.Users;
import com.xt.service.SgatherService;
import com.xt.util.DanhaoUtil;
import com.xt.util.PageDemo;
import com.xt.util.ShengchanUtil;

/**
 * 入库相关操作
 * 
 * @author yx
 *
 */
@Controller
public class SgatherController {
	@Autowired
	SgatherService service;

	// 打开入库申请单
	@RequestMapping("/rukusq")
	public String Openrukusq(HttpSession session) {
		String rukuDanHao = DanhaoUtil.getRuKuDanHao() + service.getId();// 入库单编号
		session.removeAttribute("gather_id");
		session.setAttribute("gather_id", rukuDanHao);
		session.removeAttribute("SumCount");
		session.removeAttribute("SumMoney");
		session.removeAttribute("SGatherDetailsList");
		return "rukusq";
	}

	// 分页查询需要审核的入库申请单
	@RequestMapping("/getAllSgatherInfo")
	public void getAllSgatherInfo(HttpServletResponse response, HttpServletRequest request) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		String nowpage = request.getParameter("page");
		String pageSize = request.getParameter("limit");
		String register = request.getParameter("register");
		String check_tag = request.getParameter("check_tag");
		String reason = request.getParameter("reason");
		SGather sgather = new SGather();
		sgather.setRegister(register);
		sgather.setCheck_tag(check_tag);
		sgather.setReason(reason);
		PageDemo<SGather> pd = service.selectSgather(Integer.parseInt(nowpage), Integer.parseInt(pageSize), sgather);
		PrintWriter out = response.getWriter();
		String str = JSONArray.toJSONString(pd);
		out.print(str);
		out.flush();
		out.close();
	}

	/**
	 * 查询需要入库的物料
	 */
	@RequestMapping("/getMaterialInfo_ywg")
	public void a(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String nowPage = request.getParameter("page");
		String pageSize = request.getParameter("limit");
		String name = request.getParameter("name");
		D_file df = new D_file();
		df.setProduct_name(name);
		PageDemo<D_file> pd = service.getMaterialInfo_ywg(Integer.parseInt(nowPage), Integer.parseInt(pageSize), df);
		PrintWriter out = response.getWriter();
		String str = JSONArray.toJSONString(pd);
		out.print(str);
		out.flush();
		out.close();
	}

	// 添加入库详细表
	@RequestMapping("/addSgatherDetail")
	public void addSgatherDetail(HttpSession session, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=utf-8");
		String num = request.getParameter("num");// 入库的数量
		String product_id = request.getParameter("product_id");// 产品编号
		String product_name = request.getParameter("product_name");// 产品名称
		String product_describe = request.getParameter("product_describe");// 产品描述
		String personal_unit = request.getParameter("personal_unit");// 计量单位
		String cost_price = request.getParameter("cost_price");// 单价
		String gather_id = (String) session.getAttribute("gather_id");// 拿到入库申请单号
		SGatherDetails sd = new SGatherDetails(gather_id, product_id, product_name, product_describe, num,
				personal_unit, cost_price, Integer.parseInt(num) * Double.parseDouble(cost_price));
		// 判断该产品是否已经添加，如果添加则修改数量
		List<SGatherDetails> list = service.queryAllRuKuDetail();
		for (SGatherDetails sg : list) {
			if (product_id.equals(sg.getProduct_id()) && gather_id.equals(sg.getParent_id())) {
				service.updateRuKuDetailNum(gather_id, product_id,
						Integer.parseInt(num) * Double.parseDouble(cost_price), Integer.parseInt(num));
				out.print("1");
				out.flush();
				out.close();
				return;
			}
		}
		service.addSgatherDetail(sd);
		out.print("1");
		out.flush();
		out.close();
	}

	// 返回
	@RequestMapping("/getrukuDetailInfo")
	@ResponseBody
	public String getrukuDetailInfo(HttpSession session, HttpServletRequest request) {
		String gather_id = (String) session.getAttribute("gather_id");// 拿到入库单编号
		// 根据入库单号查询详情
		List<SGatherDetails> list = service.queryRukuDetail(gather_id);
		session.removeAttribute("SGatherDetailsList");
		session.setAttribute("SGatherDetailsList", list);
		// 根据入库单号拿到总数量和总金额
		String SumCount = service.queryRuKuCount(gather_id);
		String SumMoney = service.queryRuKuMoney(gather_id);
		session.removeAttribute("SumCount");
		session.setAttribute("SumCount", SumCount);
		session.removeAttribute("SumMoney");
		session.setAttribute("SumMoney", SumMoney);
		return "成功";
	}

	// 删除入库详细的数据
	@RequestMapping("/delRuCudetail")
	public String delRuCudetail(HttpServletRequest request, HttpSession session, String id) {
		String gather_id = (String) session.getAttribute("gather_id");// 拿到入库单编号
		System.out.println("入库编号:" + gather_id);
		service.delRuCudetail(gather_id, id);// 删除入库详细的数据
		// 根据入库单号查询详情
		List<SGatherDetails> list = service.queryRukuDetail(gather_id);
		session.removeAttribute("SGatherDetailsList");
		session.setAttribute("SGatherDetailsList", list);
		// 根据入库单号拿到总数量和总金额
		String SumCount = service.queryRuKuCount(gather_id);
		String SumMoney = service.queryRuKuMoney(gather_id);
		session.removeAttribute("SumCount");
		session.setAttribute("SumCount", SumCount);
		session.removeAttribute("SumMoney");
		session.setAttribute("SumMoney", SumMoney);
		return "rukusq";
	}

	// 保存入库申请
	@RequestMapping("/saveRuKu")
	@ResponseBody
	public String saveRuKu(HttpServletRequest request, HttpSession session) {
		String gather_id = (String) session.getAttribute("gather_id");// 拿到入库单编号
		String rukuperson = request.getParameter("rukuperson");// 入库人
		String reason = request.getParameter("reason");// 入库理由
		String SumCount = request.getParameter("SumCount");// 总件数
		String SumMoney = request.getParameter("SumMoney");// 总金额
		String remark = request.getParameter("remark");// 备注
		String username = (String) session.getAttribute("username");// 登记人
		SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 登记时间
		SGather sg = new SGather(gather_id, reason, SumCount, SumMoney, remark, rukuperson, username,
				formate.format(new Date()));
		int row = service.saveRuKu(sg);
		return row > 0 ? "1" : "0";
	}

	// 退出
	@RequestMapping("/tuichurk")
	public String tuichu(HttpSession session) {
		session.removeAttribute("SumCount");
		session.removeAttribute("SumMoney");
		session.removeAttribute("SGatherDetailsList");
		return "rukusq";
	}

	// 查询审核的详细信息
	@RequestMapping("/shenheRuKu")
	@ResponseBody
	public String shenheRuKu(HttpServletRequest request, HttpSession session) {
		String gather_id = request.getParameter("gather_id");// 拿到入库单编号
		session.removeAttribute("gather_id");
		session.setAttribute("gather_id", gather_id);
		String rukuperson = request.getParameter("rukuperson");// 入库人
		session.removeAttribute("rukuperson");
		session.setAttribute("rukuperson", rukuperson);
		String reason = request.getParameter("reason");// 入库理由
		session.removeAttribute("reason");
		session.setAttribute("reason", reason);
		String amount_sum = request.getParameter("amount_sum");// 总件数
		session.removeAttribute("amount_sum");
		session.setAttribute("amount_sum", amount_sum);
		String cost_price_sum = request.getParameter("cost_price_sum");// 总金额
		session.removeAttribute("cost_price_sum");
		session.setAttribute("cost_price_sum", cost_price_sum);
		String remark = request.getParameter("remark");// 备注
		session.removeAttribute("remark");
		session.setAttribute("remark", remark);
		String register = request.getParameter("register");// 登记人
		session.removeAttribute("register");
		session.setAttribute("register", register);
		String register_time = request.getParameter("register_time");// 登记时间
		session.removeAttribute("register_time");
		session.setAttribute("register_time", register_time);
		List<SGatherDetails> list = service.queryRukuDetail(gather_id);
		session.removeAttribute("SGatherfuheDetailsList");
		session.setAttribute("SGatherfuheDetailsList", list);
		return "1";
	}

	// 审核通过
	@RequestMapping("/RuKufuheSuccess")
	@ResponseBody
	public String RuKufuheSuccess(HttpServletRequest request) {
		String gather_id = request.getParameter("gather_id");// 拿到入库单编号
		String checker = request.getParameter("checker");// 复核人
		String check_time = request.getParameter("check_time");// 复核时间
		int row =service.RuKufuheSuccess(gather_id, checker, check_time);
		return row>0?"1":"0";
	}

	// 审核不通过
	@RequestMapping("/RuKufuheNoSuccess")
	@ResponseBody
	public String RuKufuheNoSuccess(HttpServletRequest request,HttpSession session) {
		String gather_id = request.getParameter("gather_id");// 拿到入库单编号
		String checker = (String)session.getAttribute("username");// 复核人
		SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 复核时间
		int row = service.RuKufuheNoSuccess(gather_id, checker, formate.format(new Date()));
		return row>0?"1":"0";
	}
	//分页查询入库申请单信息
	@RequestMapping("/getRuKuInfo")
	public void getRuKuInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		String nowpage = request.getParameter("page");
		String pageSize = request.getParameter("limit");
		String gather_id = request.getParameter("name");
		SGather sg = new SGather();
		sg.setGather_id(gather_id);
		PageDemo<SGather> pd = service.getRuKuInfo(Integer.parseInt(nowpage), Integer.parseInt(pageSize), sg);
		PrintWriter out = response.getWriter();
		String str = JSONArray.toJSONString(pd);
		out.print(str);
		out.flush();
		out.close();
	}
}
