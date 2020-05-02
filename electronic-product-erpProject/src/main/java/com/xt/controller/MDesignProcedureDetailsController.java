package com.xt.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.xt.pojo.DModuleDetails;
import com.xt.pojo.MDesignProcedureDetails;
import com.xt.pojo.MDesignProcedureModule;
import com.xt.service.MDesignProcedureDetailsService;
import com.xt.service.MDesignProcedureModuleService;
import com.xt.util.PageDemo;

/**
 * 产品设计详情控制类
 * @author asus
 *罗文涛
 */
@Controller
public class MDesignProcedureDetailsController {
	@Autowired
	MDesignProcedureDetailsService serivce;
	@Autowired
	MDesignProcedureModuleService mdpmservice;
	/**
	 * 查询产品
	 * @param page
	 * @param limit
	 * @param name
	 * @return
	 */
	@RequestMapping("/mdesignDetailsAll")
	@ResponseBody
	public String mdesignDetailsAll(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int limit,String id,String name){
		MDesignProcedureDetails md = new MDesignProcedureDetails();
		md.setParent_Id(Integer.valueOf(id).intValue());
		md.setProcedure_Name(name);
		PageDemo<MDesignProcedureDetails> pd = serivce.getAllMdesign(page, limit, md);
		String str = JSONArray.toJSONString(pd);
		
		return str;
	}
	/**
	 * 分页查询产品设计详情
	 * @param page
	 * @param limit
	 * @param id
	 * @param name
	 * @return
	 */
	@RequestMapping("/MdesignmoduleAll")
	@ResponseBody
	public String MdesignmoduleAll(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int limit,String id,String name){
		DModuleDetails md = new DModuleDetails();
		md.setParent_id(id);
		md.setProduct_name(name);
		PageDemo<DModuleDetails> pd = serivce.getAllDModuleDetails(page, limit, md);
		String str = JSONArray.toJSONString(pd);
		
		return str;
	}
	/**
	 * 查询物料
	 * @param page
	 * @param limit
	 * @param id
	 * @param name
	 * @return
	 */
	@RequestMapping("/MDESIGNPROCEDUREMODULElist")
	@ResponseBody
	public String MDESIGNPROCEDUREMODULElist(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int limit,String id,String name){
		MDesignProcedureModule md = new MDesignProcedureModule();
		md.setParent_Id(Integer.parseInt(id));
		md.setProduct_Name(name);
		PageDemo<MDesignProcedureModule> pd = mdpmservice.getAllMdesign(page, limit, md);
		String str = JSONArray.toJSONString(pd);
		return str;
	}
	
	/**
	 * 添加详情
	 * @param mp
	 * @param session
	 * @return
	 */
	@RequestMapping("/addMdesiogn")
	@ResponseBody
	public String addMdesiogn(@ModelAttribute MDesignProcedureDetails mp,HttpSession session){
		List<MDesignProcedureDetails> list = serivce.findList(mp.getParent_Id()+"");
		for (MDesignProcedureDetails md : list) {
			if(mp.getParent_Id().equals(md.getParent_Id())&&mp.getProcedure_Id().equals(md.getProcedure_Id())) {
				String str = JSONArray.toJSONString("已有");
				return str;
			}
		}
		SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		mp.setRegister_Time(formate.format(new Date()));//登记时间
		String name =(String) session.getAttribute("username");
		mp.setDesign_Module_Change_Tag("未变更");
		mp.setDesign_Module_Tag("未设计");
		mp.setRegister(name);//登记人
		int count = serivce.addmdesignDetails(mp);
		String str = JSONArray.toJSONString(count);
		return str;
	}
	
	
	/**
	 * 修改物料
	 * @param dm
	 * @param id
	 * @param session
	 * @return
	 */
	@RequestMapping("/updateDModuleDetailslist")
	@ResponseBody
	public String updateDModuleDetailslist(String dm,String id,HttpSession session){
		List<DModuleDetails> list = JSON.parseArray(dm,DModuleDetails.class);
		MDesignProcedureModule mm = new MDesignProcedureModule();
		mm.setParent_Id(Integer.parseInt(id));
		PageDemo<MDesignProcedureModule> listmd = mdpmservice.getAllMdesign(0, 9999, mm);
		int num = 0;
		for (DModuleDetails dd : list) {
			if(dd.getShuliang()>0) {
				int s = 0;
				for (MDesignProcedureModule dmd : listmd.getData()) {
					if(dmd.getProduct_Id().equals(dd.getProduct_id())) {//两边的物料id相等
						if(dd.getShuliang()<dmd.getAmount()) {//当物料的数量大于输入的数量
							num += (int) (dd.getShuliang()*dd.getCost_price());
							dd.setResidual_amount((Integer)dmd.getAmount()-dd.getShuliang());
							serivce.upd_moule(dd);
							dmd.setAmount(dd.getShuliang());
							mdpmservice.mdesignUpdate(dmd);//修改数量
						}else if(dmd.getAmount()==dd.getShuliang()) {
							if(dd.getResidual_amount()>=dd.getShuliang()) {
								dd.setResidual_amount(dd.getResidual_amount()-dd.getShuliang());
								dmd.setAmount(dd.getAmount()-dd.getResidual_amount());
								serivce.upd_moule(dd);
								num += dmd.getAmount()*dd.getCost_price();
								mdpmservice.mdesignUpdate(dmd);//修改数量
							}
						}else if(dd.getResidual_amount()!=0&&dd.getResidual_amount()>=dd.getShuliang()){
							dd.setResidual_amount(dd.getResidual_amount()-dd.getShuliang());
							serivce.upd_moule(dd);
							dmd.setAmount((int)dmd.getAmount()+dd.getShuliang());
							num +=  (int)dmd.getAmount()*dd.getCost_price();
							mdpmservice.mdesignUpdate(dmd);//修改数量
						}else {
							return "您输入的超过了物料数";
						}
						s = 1;
						break;
					}else {
						s = 0;
					}
				}
				if(s==0) {
					MDesignProcedureModule md = new MDesignProcedureModule();
					int cou = dd.getAmount()-dd.getResidual_amount();
					num += (int) (cou*dd.getCost_price());
					md.setAmount(dd.getShuliang());//本工序数量
					md.setProduct_Name(dd.getProduct_name());//物料名称
					md.setParent_Id(Integer.parseInt(id));//父级序号
					md.setDetails_Number(Integer.parseInt(dd.getDetails_number()));//工序物料序号
					md.setProduct_Id(dd.getProduct_id());//物料编号
					md.setType(dd.getType());
					md.setProduct_Describe(dd.getProduct_describe());
					md.setAmount_Unit(dd.getAmount_unit());
					md.setCost_Price(dd.getCost_price());
					mdpmservice.mdesignadd(md);
				}
			}
		}
		MDesignProcedureDetails md = new MDesignProcedureDetails();
		md.setId(Integer.parseInt(id));
		md.setDesign_Module_Change_Tag("已变更");
		md.setModule_Subtotal(num);
		int count = serivce.updatemdesignDetails(md);
		String str = JSONArray.toJSONString(count);
		return str;
	}
	
	
	/**
	 * 添加物料
	 * @param dm
	 * @param id
	 * @param session
	 * @return
	 */
	@RequestMapping("/addDModuleDetailslist")
	@ResponseBody
	public String addDModuleDetailslist(String dm,String id,HttpSession session){
		List<DModuleDetails> list = JSON.parseArray(dm,DModuleDetails.class);
		for (DModuleDetails dd : list) {
			if(dd.getShuliang()>0) {
				if(dd.getShuliang()>dd.getResidual_amount()) {
					return "您ID为"+dd.getId()+"的可用数量不足";
				}
			}
		}
		MDesignProcedureModule mm = new MDesignProcedureModule();
		mm.setParent_Id(Integer.parseInt(id));
		PageDemo<MDesignProcedureModule> listmd = mdpmservice.getAllMdesign(0, 9999, mm);
		int num = 0;
		for (DModuleDetails dd : list) {
			if(dd.getShuliang()>0) {
				int s = 0;
				MDesignProcedureModule md = new MDesignProcedureModule();
				for (MDesignProcedureModule mdd : listmd.getData()) {
					if(mdd.getProduct_Id().equals(dd.getProduct_id())) {//两边的物料id相等
						md.setId(mdd.getId());
						md.setAmount(md.getAmount()+dd.getShuliang());
						num +=(int) md.getAmount()*(int)dd.getCost_price();
						md.setSubtotal((int) md.getAmount()*(int)dd.getCost_price());
						mdpmservice.mdesignUpdate(md);
						s=1;
					}
				}
				dd.setResidual_amount(dd.getResidual_amount()-dd.getShuliang());
				int cou = dd.getAmount()-dd.getResidual_amount();
				if(s==0) {
					num += (int) (cou*dd.getCost_price());
					md.setAmount(dd.getShuliang());//本工序数量
					md.setProduct_Name(dd.getProduct_name());//物料名称
					md.setParent_Id(Integer.parseInt(id));//父级序号
					md.setDetails_Number(Integer.parseInt(dd.getDetails_number()));//工序物料序号
					md.setProduct_Id(dd.getProduct_id());//物料编号
					md.setType(dd.getType());
					md.setProduct_Describe(dd.getProduct_describe());
					md.setAmount_Unit(dd.getAmount_unit());
					md.setCost_Price(dd.getCost_price());
					md.setSubtotal((int) md.getAmount()*(int)dd.getCost_price());
					mdpmservice.mdesignadd(md);
				}
				serivce.upd_moule(dd);
			}
		}
		MDesignProcedureDetails md = new MDesignProcedureDetails();
		md.setId(Integer.parseInt(id));
		md.setDesign_Module_Tag("已设计");
		md.setModule_Subtotal(num);
		int count = serivce.updatemdesignDetails(md);
		String str = JSONArray.toJSONString(count);
		return str;
	}
	@RequestMapping("/delMdesigndetails")
	@ResponseBody
	public String delMdesigndetails(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int limit,String name){
		System.out.println(name);
		MDesignProcedureDetails md = new MDesignProcedureDetails();
		md.setParent_Id(Integer.valueOf(name).intValue());
		PageDemo<MDesignProcedureDetails> pd = serivce.getAllMdesign(page, limit, md);
		String str = JSONArray.toJSONString(pd);
		
		return str;
	}
}
