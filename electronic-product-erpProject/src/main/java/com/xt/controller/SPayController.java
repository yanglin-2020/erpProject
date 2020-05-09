package com.xt.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.xt.pojo.D_file;
import com.xt.pojo.SCell;
import com.xt.pojo.SPay;
import com.xt.pojo.SPayDetails;
import com.xt.service.SPayService;
import com.xt.util.PageDemo;
/**
 * 出库控制类
 * @author 罗文涛
 *
 */
@Controller
public class SPayController {
	@Autowired
	SPayService service;
	
	
	/**
	 * 分页查询出库
	 * @param page
	 * @param limit
	 * @param name
	 * @param bh
	 * @param change
	 * @return
	 */
	@RequestMapping("/SpayAll")
	@ResponseBody
	public String SpayAll(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int limit,String name,String bh,String change){
		SPay s = new SPay();
		s.setPay_id(name);//出库编号
		s.setStore_tag(change);//库存标记
		s.setCheck_tag(bh);//审核状态
		PageDemo<SPay> pd = service.getAllUserInfo(page, limit, s);
		String str = JSONArray.toJSONString(pd);
		return str;
	}
	
	
	/**
	 * 分页查询出库详情
	 * @param page
	 * @param limit
	 * @param name
	 * @param bh
	 * @param change
	 * @return
	 */
	@RequestMapping("/SpayDatelisAll")
	@ResponseBody
	public String SpayDatelisAll(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int limit,String name,int id){
		SPayDetails s = new SPayDetails();
		s.setParent_id(id);
		s.setProduct_name(name);
		PageDemo<SPayDetails> pd = service.spayDeilslist(page, limit, s);
		String str = JSONArray.toJSONString(pd);
		return str;
	}
	
	/**
	 * 查询库存
	 * @return
	 */
	@RequestMapping("/SpayDatelistAlls")
	@ResponseBody
	public String SpayDatelistAlls(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int limit,String name){
		SCell s = new SCell();
		s.setProduct_name(name);
		PageDemo<SCell> pd = service.scelllist(page, limit, s);
		String str = JSONArray.toJSONString(pd);
		return str;
	}
	
	
	/**
	 * 审核出库
	 * @param page
	 * @param limit
	 * @param name
	 * @return
	 */
	@RequestMapping("/Spayupdate")
	@ResponseBody
	public String Spayupdate(String id,String bh,String store,@RequestParam(defaultValue = " ") String reason,HttpSession session){
		SPay md = new SPay();
		SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String name =(String) session.getAttribute("username");
		md.setId(Integer.parseInt(id));
		md.setCheck_tag(bh); //审核状态
		md.setRemark(reason);//备注
		md.setStore_tag(store);//库存标志
		md.setChecker(name);//审核人
		md.setCheck_time(formate.format(new Date()));//审核时间
		int count = service.updateSPay(md);
		String str = JSONArray.toJSONString(count);
		return str;
	}
	
	/**
	 * 添加出库申请
	 * @param mdprod
	 * @return
	 */
	@RequestMapping("/SpayDetaaddlist")
	@ResponseBody
	public String SpayDetaaddlist(String dm,String id){
		List<SCell> list = JSON.parseArray(dm,SCell.class);
		int i=0;
		for (SCell s : list) {
			if((int)s.getAmount()==0) {
				return "您选择的"+s.getProduct_name()+"商品已经没有库存了！";
			}
			i=1;
		}
		if(i==0) {
			return "最低选中一个";
		}
		SPayDetails sd = new SPayDetails();
		int pd = 0;
		for (SCell md : list) {
			D_file d = service.DfileIdc(md.getProduct_id());
			sd.setParent_id(Integer.parseInt(id));
			sd.setAmount(0);
			sd.setSubtotal(0);
			sd.setProduct_id(md.getProduct_id());
			sd.setProduct_name(md.getProduct_name());
			System.out.println(d.getReal_cost_price());
			sd.setAmount_unit(d.getAmount_unit());
			sd.setCost_price(""+d.getCost_price());
			
			pd = service.spayDeilsadd(sd);
		}
		String str = JSONArray.toJSONString(pd);
		return str;
	}
	
	/**
	 * 添加出库登记
	 * @param mdprod
	 * @return
	 */
	@RequestMapping("/addSpayshenqing")
	@ResponseBody
	public String addSpayshenqing(String dm,String id,String liyou,String dengji,HttpSession session){
		List<SPayDetails> list = JSON.parseArray(dm,SPayDetails.class);
		SPay mds = new SPay();
		for (SPayDetails md : list) {
			if(md.getAmount()==0) {
				return "请输入出库数量";
			}
		}
		double num = 0;
		int count = 0;
		for (SPayDetails md : list) {
			count+=md.getAmount();
			num+=md.getSubtotal();
			service.spayDeilsUpdate(md);
		}
		SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String name =(String) session.getAttribute("username");
		mds.setCost_price_sum(num);
		mds.setAmount_sum(count); 
		mds.setCheck_tag("等待审核");
		mds.setStore_tag("已登记");
		mds.setStorer(dengji);
		mds.setPay_id(id);
		mds.setReason(liyou);
		mds.setRegister(name);//登记人
		mds.setRegister_time(formate.format(new Date()));//登记时间
		int pd = service.addSPay(mds);
		String str = JSONArray.toJSONString(pd);
		return str;
	}
}
