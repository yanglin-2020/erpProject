package com.xt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.xt.pojo.Supplier;
import com.xt.service.SupplierService;
import com.xt.util.PageDemo;
import com.xt.util.PageUtil;
import com.xt.util.ShengchanUtil;

/**
 * 
 * @崔庆康 供货商管理
 *
 */
@Controller
public class SupplierController {
	

	@Autowired
	SupplierService service;
	
	//供应商添加
	@RequestMapping("addsupplier")
	public String addsupplier(HttpServletResponse response,HttpServletRequest request,HttpSession session) {
		response.setContentType("text/html;charset=utf-8");
		String name=request.getParameter("name");
		String constactPerson=request.getParameter("constactPerson");
		String phone=request.getParameter("phone");
		String khyh=request.getParameter("khyh");
		String remark=request.getParameter("remark");
		String province=request.getParameter("province");
		String city=request.getParameter("city");
		String supplier_ID=ShengchanUtil.getSupplierId();
		String district=request.getParameter("district");
		String address=province+""+city+""+district;
		Supplier supplier=new Supplier();
		supplier.setName(name);
		supplier.setAddress(address);
		supplier.setPhone(phone);
		supplier.setKhyh(khyh);
		supplier.setConstactPerson(constactPerson);
		supplier.setRegister((String)session.getAttribute("username"));
		supplier.setRegister_time(new Date());
		supplier.setRemark(remark);
		supplier.setSupplier_ID(supplier_ID);
		supplier.setCheck_tag("等待审核");
		supplier.setDelstate("未删除");
		service.addsupplier(supplier);
		return "supplierload";
	}
	
	//查询未复核的供应商数据
	@RequestMapping("querysupplier")
	public void querysupplier(HttpServletRequest request,HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		String nowpage = request.getParameter("page");
		String pageSize = request.getParameter("limit");
		Supplier supplier=new Supplier();
		String name=request.getParameter("name");
		if(name!=null && name!="") {
			supplier.setName(name);
		}
		supplier.setCheck_tag("等待审核");
		supplier.setDelstate("未删除");
		PageDemo<Supplier> pd=service.querysupplier(Integer.parseInt(nowpage),Integer.parseInt(pageSize),supplier);
		String str=JSON.toJSONString(pd);
		PrintWriter out=response.getWriter();
		out.print(str);
		out.flush();
		out.close();
	}
	//审核通过
	@RequestMapping("auditsupplier")
	public void auditsupplier(HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		response.setContentType("test/html;charset=utf-8");
		String supplier_ID=request.getParameter("supplier_ID");
		String name=request.getParameter("name");
		String constactPerson=request.getParameter("constactPerson");
		String phone=request.getParameter("phone");
		String khyh=request.getParameter("khyh");
		String remark=request.getParameter("remark");
		String reason=request.getParameter("reason");
		Supplier supplier=new Supplier();
		supplier.setName(name);
		supplier.setPhone(phone);
		supplier.setKhyh(khyh);
		supplier.setConstactPerson(constactPerson);
		supplier.setChecker((String)session.getAttribute("username"));
		supplier.setRemark(remark);
		supplier.setReason(reason);
		supplier.setCheck_time(new Date());
		supplier.setSupplier_ID(supplier_ID);
		supplier.setCheck_tag("审核通过");
		service.auditsupplier(supplier);
	}
	
	//审核不通过
	@RequestMapping("noauditsupplier")
	@ResponseBody
	public int noauditsupplier(HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		response.setContentType("test/html;charset=utf-8");
		String supplier_ID=request.getParameter("supplier_ID");
		String reason=request.getParameter("reason");
		Supplier supplier=new Supplier();
		supplier.setChecker((String)session.getAttribute("username"));
		supplier.setReason(reason);
		supplier.setCheck_tag("审核不通过");
		supplier.setCheck_time(new Date());
		supplier.setSupplier_ID(supplier_ID);
		int row=service.noauditsupplier(supplier);
		return row;
		
	}
	
	//查询
	@RequestMapping("querysupplier1")
	public void querysupplier1(HttpServletRequest request,HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		String nowpage = request.getParameter("page");
		String pageSize = request.getParameter("limit");
		Supplier supplier=new Supplier();
		supplier.setDelstate("未删除");
		String name=request.getParameter("name");
		if(name!=null && name!="") {
			supplier.setName(name);
		}
		String check_tag=request.getParameter("check_tag");
		if(check_tag==null) {
			supplier.setCheck_tag("审核通过");
		}
		else {
			supplier.setCheck_tag(check_tag);
		}
		PageDemo<Supplier> pd=service.querysupplier(Integer.parseInt(nowpage),Integer.parseInt(pageSize),supplier);
		String str=JSON.toJSONString(pd);
		PrintWriter out=response.getWriter();
		out.print(str);
		out.flush();
		out.close();
	}
	//修改删除状态
	@RequestMapping("updatedelsupplier")
	@ResponseBody
	public int updatedelsupplier(HttpServletRequest request,HttpServletResponse response) {
		response.setContentType("text/html;charset=utf-8");
		String supplier_ID=request.getParameter("supplier_ID");
		Supplier supplier=new Supplier();
		supplier.setSupplier_ID(supplier_ID);
		supplier.setDelstate("已删除");
		int row=service.updatedelsupplier(supplier);
		return row;
	}
	//修改供应商
	@RequestMapping("updatesupplier")
	public void updatesupplier(HttpServletRequest request,HttpServletResponse response) {
		response.setContentType("test/html;charset=utf-8");
		String supplier_ID=request.getParameter("supplier_ID");
		String name=request.getParameter("name");
		String constactPerson=request.getParameter("constactPerson");
		String phone=request.getParameter("phone");
		String khyh=request.getParameter("khyh");
		String remark=request.getParameter("remark");
		String province=request.getParameter("province");
		String city=request.getParameter("city");
		String district=request.getParameter("district");
		Supplier supplier=new Supplier();
		if(province!=null && province!="" || city!=null && city!="" || district!=null || district!="") {
			String address=province+""+city+""+district;
			supplier.setAddress(address);
		}
		if(province==null || province=="") {
			supplier.setAddress(request.getParameter("address"));
		}
		supplier.setName(name);
		supplier.setPhone(phone);
		supplier.setKhyh(khyh);
		supplier.setConstactPerson(constactPerson);
		supplier.setRemark(remark);
		supplier.setSupplier_ID(supplier_ID);
		supplier.setCheck_tag("等待审核");
		supplier.setChecker(null);
		supplier.setCheck_time(null);
		supplier.setReason(null);
		service.updatesupplier(supplier);
	}
	//查询已删除的数据
	@RequestMapping("querydelsupplier")
	public void querydelsupplier(HttpServletRequest request,HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		String nowpage = request.getParameter("page");
		String pageSize = request.getParameter("limit");
		Supplier supplier=new Supplier();
		String name=request.getParameter("name");
		String check_tag=request.getParameter("check_tag");
		if(name!=null && name!="") {
			supplier.setName(name);
		}
		if(check_tag!=null && check_tag!="") {
			supplier.setCheck_tag(check_tag);
		}
		supplier.setDelstate("已删除");
		PageDemo<Supplier> pd=service.querysupplier(Integer.parseInt(nowpage),Integer.parseInt(pageSize),supplier);
		String str=JSON.toJSONString(pd);
		PrintWriter out=response.getWriter();
		out.print(str);
		out.flush();
		out.close();
	}
	//恢复数据
	@RequestMapping("huifu")
	@ResponseBody
	public int huifu(HttpServletRequest request,HttpServletResponse response) {
		String supplier_ID=request.getParameter("supplier_ID");
		Supplier supplier=new Supplier();
		supplier.setSupplier_ID(supplier_ID);
		supplier.setDelstate("未删除");
		return service.updatedelsupplier(supplier);
	}
	//彻底删除
	@RequestMapping("Shift_Delete")
	@ResponseBody
	public int Shift_Delete(HttpServletRequest request,HttpServletResponse response) {
		String supplier_ID=request.getParameter("supplier_ID");
		Supplier supplier=new Supplier();
		supplier.setSupplier_ID(supplier_ID);
		return service.delSupplier(supplier);
	}
	
}
