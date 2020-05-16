package com.xt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.xt.pojo.Buygoods;
import com.xt.pojo.Buygoods_detail;
import com.xt.pojo.Goods;
import com.xt.pojo.SPay;
import com.xt.pojo.SPayDetails;
import com.xt.pojo.Supplier;
import com.xt.service.Caigou_DiaoduService;
import com.xt.util.DanhaoUtil;
import com.xt.util.PageDemo;

/**
 * 采购调度管理
 * 
 * @author long
 *
 */
@Controller
public class Caigou_DiaoduController {

	@Autowired
	Caigou_DiaoduService service;
	//跳转采购登记页面
	@RequestMapping("/caigoudengji")
	public String caigoudengji(HttpSession session) {
		String b = (String) session.getAttribute("buy_id");
		if (b == null || b.equals("")) {
			String buy_id = DanhaoUtil.getCgBianHao();// 自动生成采购编号
			session.setAttribute("buy_id", buy_id);
		}
		return "buygoods-dengji";
	}

	/**
	 * 查询所有采购信息
	 * 
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/getAllBuygoodszl")
	public void getAllGoods(HttpServletResponse response, HttpServletRequest request) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		String nowpage = request.getParameter("page");
		String pageSize = request.getParameter("limit");
		String buy_id = request.getParameter("buy_id");
		String check_tag = request.getParameter("check_tag");
		Buygoods b = new Buygoods();
		b.setBuy_id(buy_id);
		b.setStatus(check_tag);
		PageDemo<Buygoods> pd = service.getAllBuygoodsInfo(Integer.parseInt(nowpage), Integer.parseInt(pageSize), b);
		PrintWriter out = response.getWriter();
		String str = JSONArray.toJSONString(pd);
		out.print(str);
		out.flush();
		out.close();
	}

	/**
	 * 查询采购详细记录
	 * 
	 * @return
	 */
	@RequestMapping("/getBuygoodsdetails")
	public String getBuygoodsdetails(String buy_id, Model model) {
		List<Buygoods_detail> goods = service.getBuygoodsdetails(buy_id);
		model.addAttribute("list", goods);
		return "buygoods-select-details";
	}

	/**
	 * 查询所有供应商
	 */
	@RequestMapping("/gysSelect")
	@ResponseBody
	public List<Supplier> gysSelect() {
		List<Supplier> list = service.gysSelect();
		return list;
	}

	/**
	 * 根据供应商ID查询商品信息
	 */
	@RequestMapping("/selectGoodsBySupplier_ID")
	public void selectGoodsBySupplier_ID(HttpServletResponse response, HttpServletRequest request, String supplier_ID)
			throws IOException {
		response.setContentType("text/html;charset=utf-8");
		String nowPage = request.getParameter("page");
		String pageSize = request.getParameter("limit");
		String goods_name = request.getParameter("goods_name");
		Goods b = new Goods();
		b.setSupplier_ID(supplier_ID);
		b.setGoods_name(goods_name);
		PageDemo<Goods> pd = service.selectGoodsBySupplier_ID(Integer.parseInt(nowPage), Integer.parseInt(pageSize), b);
		PrintWriter out = response.getWriter();
		String str = JSONArray.toJSONString(pd);
		out.print(str);
		out.flush();
		out.close();
	}

	/**
	 * 添加采购详细
	 */
	@RequestMapping("/addGoodsInfo")
	@ResponseBody
	public int addgoods(Buygoods_detail b, HttpSession session,String supplier_id) {
		session.removeAttribute("supplier_idzl");
		session.setAttribute("supplier_idzl", supplier_id);
		String buy_id = (String) session.getAttribute("buy_id");
		b.setBuy_id(buy_id);
		int result = 0;
		int is_find = service.findBuygoods_detail(b);
		if(is_find>0) {
			result = service.updateBuygoods_detail(b);
		}else {
			result = service.addBuygoods_details(b);
		}
		
		List<Buygoods_detail> list = service.getBuygoodsdetails(buy_id);
		session.setAttribute("Buygoods_detail", list);
		return result;
	}
	
	/**
	 * 删除采购详细
	 */
	@RequestMapping("/delBuygoods_detail")
	public String delBuygoods_detail(HttpSession session, Buygoods_detail b) {
		session.removeAttribute("Buygoods_detail");
		String buy_id = (String)session.getAttribute("buy_id");
		b.setBuy_id(buy_id);
		int result = service.delBuygoods_detail(b);
		//重新加载详细表
		List<Buygoods_detail> list = service.getBuygoodsdetails(buy_id);
		session.setAttribute("Buygoods_detail", list);
		return "buygoods-dengji";
	}

	/**
	 * 采购登记,添加采购单
	 */
	@RequestMapping("/addBuygoods")
	@ResponseBody
	public int addBuygoods(HttpSession session, Buygoods b) {
		session.removeAttribute("buy_id");
		session.removeAttribute("Buygoods_detail");
		//查询总数量
		String  buy_sum = service.selectBuy_sum(b.getBuy_id());
		//查询总金额
		String  buy_price = service.selectBuy_price(b.getBuy_id());
		b.setBuy_sum(buy_sum);
		b.setBuy_price(buy_price);
		//添加采购表
		int result = service.addBuygoods(b);
		return result;
	}
	
	
	/**
	 * 查询等待审核的采购单
	 * 
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/CaigouShenhe")
	public void CaigouShenhe(HttpServletResponse response, HttpServletRequest request) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		String nowPage = request.getParameter("page");
		String pageSize = request.getParameter("limit");
		Buygoods b = new Buygoods();
		b.setStatus("等待审核");
		PageDemo<Buygoods> pd = service.getAllBuygoodsInfo(Integer.parseInt(nowPage), Integer.parseInt(pageSize), b);
		PrintWriter out = response.getWriter();
		String str = JSONArray.toJSONString(pd);
		out.print(str);
		out.flush();
		out.close();
	}
	
	/**
	 * 采购审核跳转页面
	 * @return
	 */
	@RequestMapping("/caigoushenhe")
	public String caigoushenhe(HttpSession session,Model model,String id) {
		//根据父级序号查询出库单详细信息
		List<Buygoods_detail> list = service.getBuygoodsdetails(id);
		model.addAttribute("list",list);
		//获取审核人和审核时间
		String username = (String) session.getAttribute("username");// 登记人名字
		SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = formate.format(new Date());
		model.addAttribute("username", username);
		model.addAttribute("check_time", time);
		return "buygoods-shenhe-details";
	}
	
	/**
	 * 采购单审核
	 * @return
	 */
	@RequestMapping("/caigou_shenhe")
	@ResponseBody
	public int caigou_shenhe(Buygoods b) {
		//采购审核
		int result = service.shenhe(b);
		return result;
	}

}
