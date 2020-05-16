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
import com.xt.pojo.Buygoods;
import com.xt.pojo.Buygoods_detail;
import com.xt.pojo.Invoice;
import com.xt.pojo.Invoice_detail;
import com.xt.service.InvoiceService;
import com.xt.util.OrderNo;
import com.xt.util.PageDemo;

@Controller
public class InvoiceController {
	@Autowired
	InvoiceService service;
	/**
	 * 查询采购
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping("/buyAll")
	@ResponseBody
	public String buyAll(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int limit){
		PageDemo<Buygoods> pd = service.listbuy(page, limit);
		String str = JSONArray.toJSONString(pd);
		return str;
	}
	
	@RequestMapping("/buydateAll")
	@ResponseBody
	public String buydateAll(String des_id){
		List<Buygoods_detail> list = service.buydate(des_id);
		PageDemo<Buygoods_detail> pd = new PageDemo<Buygoods_detail>();
		pd.setCode(0);
		pd.setCount(0);
		pd.setMsg("");
		pd.setData(list);
		String str = JSONArray.toJSONString(pd);
		return str;
	}
	
	
	/**
	 * 查询发票详情
	 * @param page
	 * @param limit
	 * @param name
	 * @param des_id
	 * @return
	 */
	@RequestMapping("/InvoiceAll")
	@ResponseBody
	public String InvoiceAll(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int limit,String name,String des_id){
		Invoice_detail md = new Invoice_detail();
		md.setProduct_name(name);
		md.setDes_id(des_id);
		PageDemo<Invoice_detail> pd = service.listInvo(page, limit, md);
		String str = JSONArray.toJSONString(pd);
		return str;
	}
	
	/**
	 *  发票申请
	 * @param id
	 * @param bh
	 * @param reason
	 * @param session
	 * @return
	 */
	@RequestMapping("/Invoiceshenhe")
	@ResponseBody
	public String Invoiceshenhe(String id,String bh,@RequestParam(defaultValue = " ") String reason,HttpSession session,String buy_id){
		if(bh.equals("未通过")) {
			Buygoods ind = new Buygoods();
			ind.setBuy_id(buy_id);
			ind.setStore_tag("未开");
			int count = service.updateBuy(ind);
		}
		Invoice md = new Invoice();	
		md.setId(id);
		md.setStatus(bh);
		md.setYijian(reason);
		SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		md.setTime(formate.format(new Date()));
		String name =(String) session.getAttribute("username");
		md.setChanr(name);
		int count = service.updateInvoce(md);
		String str = JSONArray.toJSONString(count);
		return str;
	}
	
	/**
	 * 查询发票
	 * @param page
	 * @param limit
	 * @param name
	 * @param des_id
	 * @return
	 */
	@RequestMapping("/Invoice")
	@ResponseBody
	public String Invoice(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int limit,String name,String status){
		Invoice in = new Invoice();
		in.setLiyou(name);
		in.setStatus(status);
		PageDemo<Invoice> pd = service.getAllinvoice(page, limit, in);
		String str = JSONArray.toJSONString(pd);
		return str;
	}
	
	
	/**
	 * 添加发票
	 * @param invo
	 * @param reason
	 * @param session
	 * @return
	 */
	@RequestMapping("/Inboiveadd")
	@ResponseBody
	public String Inboiveadd(@ModelAttribute  Buygoods ind,String reason,HttpSession session){
		List<Buygoods_detail> list = service.buydate(ind.getBuy_id());
		Invoice in = new Invoice();
		Invoice_detail indt = new Invoice_detail();
		in.setId(OrderNo.NextOrderNo());
		if(reason==null||reason=="") {
			return "理由不能为空";
		}
		in.setNum(0.0);
		SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (Buygoods_detail buy : list) {
			in.setNum(in.getNum()+Double.parseDouble(buy.getGoods_price())*Integer.parseInt(buy.getGoods_num()));
			indt.setDes_id(in.getId());
			indt.setCost_num(Integer.parseInt(buy.getGoods_num()));
			indt.setProduct_name(buy.getGoods_name());
			indt.setCost_price(Double.parseDouble(buy.getGoods_price()));
			indt.setSubtotal(indt.getCost_num()*indt.getCost_price());
			indt.setCost_time(formate.format(new Date()));
			service.addInDeatail(indt);
		}
		ind.setStore_tag("已开");
		int count = service.updateBuy(ind);
		in.setSupplier_name(ind.getSupplier_name());
		in.setSupplier_ID(ind.getSupplier_ID());
		in.setBuy_id(ind.getBuy_id());
		in.setLiyou(reason);
		String name =(String) session.getAttribute("username");
		in.setRegister(name);
		in.setRegister_time(formate.format(new Date()));
		in.setStatus("等待审核");
		int pd = service.addInvoce(in);
		String str = JSONArray.toJSONString(pd);
		return str;
	}
	
	/**
	 * 发票详情修改
	 * @param ind
	 * @return
	 */
	@RequestMapping("/Invoicedateupdate")
	@ResponseBody
	public String Invoicedateupdate(@ModelAttribute  Invoice_detail ind){
		if(ind.getCost_num()==0) {
			return "商品数量不能为0";
		}
		if(ind.getCost_price()==0.0) {
			return "商品价格不能为0";
		}
		ind.setSubtotal(ind.getCost_num()*ind.getCost_price());
		int pd = service.updateDeatail(ind);
		String str = JSONArray.toJSONString(pd);
		return str;
	}
	
	
	
	/**
	 * 删除发票详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/delInvoice")
	@ResponseBody
	public String delInvoice(String id){
		int pd = service.delInDetail(id);
		String str = JSONArray.toJSONString(pd);
		return str;
	}
	
}
