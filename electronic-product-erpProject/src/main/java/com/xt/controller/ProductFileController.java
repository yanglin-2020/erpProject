package com.xt.controller;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 产品档案
 * @author yl
 *
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.web.session.HttpServletSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.xt.pojo.D_file;
import com.xt.pojo.Users;
import com.xt.service.ProductFileService;
import com.xt.util.DanhaoUtil;
import com.xt.util.PageDemo;

@Controller
public class ProductFileController {
	@Autowired
	ProductFileService service;
	
	//添加(修改)产品档案信息
	@RequestMapping("/addProductFile")
	public String addProductFile(HttpServletRequest request,HttpServletSession session) {
		String product_name = request.getParameter("product_name");// 产品名称
		String factory_name = request.getParameter("factory_name");// 制造商
		String first_kind_id = request.getParameter("first_kind_id");// 商品类型
		String product_nick = request.getParameter("product_nick");// 产品简称
		String type = request.getParameter("type");// 用途类型
		String product_class = request.getParameter("product_class");// 档次级别
		String personal_unit = request.getParameter("personal_unit");// 计量单位
		String personal_value = request.getParameter("personal_value");// 计量值
		String list_price = request.getParameter("list_price");// 单价
		String cost_price = request.getParameter("cost_price");// 成本单价
		String warranty = request.getParameter("warranty");// 保修期
		String lifecycle = request.getParameter("lifecycle");// 生命周期
		String product_describe = request.getParameter("product_describe");// 产品描述
		String responsible_person = request.getParameter("responsible_person");// 产品经理
		String register = request.getParameter("register");// 登记人
		String id = service.getDanHao();//生成产品单号要用的
		String product_id = DanhaoUtil.getProductDanHao()+id;//产品单号
		String product_id1 = request.getParameter("product_id");//传入id，为空添加操作，不为空修改操作
		
		if(product_id1!=""&&product_id1!=null&&!product_id1.equals("")) {
			//更新操作
			String username=(String)session.getAttribute("username");//变更人
			SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//变更时间
			D_file df1 = new D_file(product_id1, product_name, factory_name, first_kind_id, product_nick, type,
					product_class, personal_unit, personal_value, warranty, lifecycle, Double.parseDouble(list_price),
					Double.parseDouble(cost_price), product_describe, responsible_person, register,username,formate.format(new Date()));
			service.updateProductInfo(df1);
			return "queryd_file";
		}else {
			D_file df = new D_file(product_id, product_name, factory_name, first_kind_id, product_nick, type,
					product_class, personal_unit, personal_value, warranty, lifecycle, Double.parseDouble(list_price),
					Double.parseDouble(cost_price), product_describe, responsible_person, register);
			// 调用添加的方法
			int count = service.addProductInfo(df);
			if (count > 0) {
				return "load";
			} else {
				return "productfile";
			}
		}
	}
	//查询需要复核的产品档案信息
	@RequestMapping("/getD_fileFuHe")
	public void getD_fileFuHe(HttpServletResponse response, HttpServletRequest request) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		String nowpage = request.getParameter("page");
		String pageSize = request.getParameter("limit");
		D_file df = new D_file();
		PageDemo<D_file> pd = service.getD_fileFuHei(Integer.parseInt(nowpage), Integer.parseInt(pageSize), df);
		PrintWriter out = response.getWriter();
		String str = JSONArray.toJSONString(pd);
		out.print(str);
		out.flush();
		out.close();
	}
	//复核前根据产品id查询信息
	@RequestMapping("/getD_fileById")
	@ResponseBody
	public String getD_fileById(HttpServletRequest request,HttpSession session) {
		String product_id = request.getParameter("product_id");//产品id
		D_file list = service.getD_fileById(product_id);
		session.setAttribute("product", list);
		return "成功";
	}
	//复核产品档案(通过)
	@RequestMapping("/fuheProduct")
	public String fuheProduct(HttpServletRequest request, HttpSession session) {
		String product_id = request.getParameter("product_id");//产品id
		D_file df = new D_file();
		df.setProduct_id(product_id);
		String checkerName = (String) session.getAttribute("username");//复核人姓名
		df.setChecker(checkerName);
		df.setCheck_tag("审核通过");
		SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		df.setCheck_time(formate.format(new Date()));//复核的时间
		service.updateD_fileFuHe(df);
		return "load1";
	}
	//复核产品档案(不通过)
	@RequestMapping("/nofuheProduct")
	@ResponseBody
	public String nofuheProduct(HttpServletRequest request, HttpSession session) {
		String product_id = request.getParameter("product_id");//产品id
		D_file df = new D_file();
		df.setProduct_id(product_id);
		String checkerName = (String) session.getAttribute("username");//复核人姓名
		df.setChecker(checkerName);
		df.setCheck_tag("审核不通过");
		SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		df.setCheck_time(formate.format(new Date()));//复核的时间
		service.updateD_fileFuHe(df);
		return "成功";
	}
	//分页查询产品档案的信息
	@RequestMapping("/getD_fileInfo")
	public void getD_fileInfo(HttpServletResponse response, HttpServletRequest request) throws Exception{
		response.setContentType("text/html;charset=utf-8");
		String nowpage = request.getParameter("page");
		String pageSize = request.getParameter("limit");
		String product_name = request.getParameter("name");
		D_file df = new D_file();
		df.setProduct_name(product_name);
		PageDemo<D_file> pd = service.getD_fileInfo(Integer.parseInt(nowpage), Integer.parseInt(pageSize), df);
		PrintWriter out = response.getWriter();
		String str = JSONArray.toJSONString(pd);
		out.print(str);
		out.flush();
		out.close();
	}
	//删除一个产品档案信息
	@RequestMapping("/updateDelProduct")
	@ResponseBody
	public String updateDelProduct(HttpServletRequest request, HttpSession session) {
		String product_id = request.getParameter("product_id");//产品id
		int row = service.updateDelProduct(product_id);
		return row>0?"成功":"失败";
	}
}
