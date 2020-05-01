package com.xt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.xt.pojo.DModule;
import com.xt.pojo.DModuleDetails;
import com.xt.pojo.D_file;
import com.xt.pojo.KuCun;
import com.xt.pojo.Users;
import com.xt.service.ProductFileService;
import com.xt.util.DanhaoUtil;
import com.xt.util.PageDemo;

@Controller
public class ProductFileController {
	@Autowired
	ProductFileService service;

	// 添加(修改)产品档案信息
	@RequestMapping("/addProductFile")
	public String addProductFile(HttpServletRequest request, HttpSession session) {
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
		String id = service.getDanHao();// 生成产品单号要用的
		String product_id = DanhaoUtil.getProductDanHao() + id;// 产品单号
		String product_id1 = request.getParameter("product_id");// 传入id，为空添加操作，不为空修改操作
		if (product_id1 != "" && product_id1 != null && !product_id1.equals("")) {
			// 更新操作
			String username = (String) session.getAttribute("username");// 变更人
			SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 变更时间
			D_file df1 = new D_file(product_id1, product_name, factory_name, first_kind_id, product_nick, type,
					product_class, personal_unit, personal_value, warranty, lifecycle, Double.parseDouble(list_price),
					Double.parseDouble(cost_price), product_describe, responsible_person, register, username,
					formate.format(new Date()));
			service.updateProductInfo(df1);
			return "queryd_file";
		} else {
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

	// 查询需要复核的产品档案信息
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

	// 复核前根据产品id查询信息
	@RequestMapping("/getD_fileById")
	@ResponseBody
	public String getD_fileById(HttpServletRequest request, HttpSession session) {
		String product_id = request.getParameter("product_id");// 产品id
		D_file list = service.getD_fileById(product_id);
		session.setAttribute("product", list);
		return "成功";
	}

	// 复核产品档案(通过)
	@RequestMapping("/fuheProduct")
	public String fuheProduct(HttpServletRequest request, HttpSession session) {
		String product_id = request.getParameter("product_id");// 产品id
		D_file df = new D_file();
		df.setProduct_id(product_id);
		String checkerName = (String) session.getAttribute("username");// 复核人姓名
		df.setChecker(checkerName);
		df.setCheck_tag("审核通过");
		SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		df.setCheck_time(formate.format(new Date()));// 复核的时间
		service.updateD_fileFuHe(df);
		return "load1";
	}

	// 复核产品档案(不通过)
	@RequestMapping("/nofuheProduct")
	@ResponseBody
	public String nofuheProduct(HttpServletRequest request, HttpSession session) {
		String product_id = request.getParameter("product_id");// 产品id
		String reason = request.getParameter("reason");// 审核不通过的理由
		D_file df = new D_file();
		df.setProduct_id(product_id);
		String checkerName = (String) session.getAttribute("username");// 复核人姓名
		df.setChecker(checkerName);
		df.setCheck_tag("审核不通过");
		df.setReason(reason);
		SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		df.setCheck_time(formate.format(new Date()));// 复核的时间
		service.updateD_fileFuHe(df);
		return "成功";
	}

	// 分页查询产品档案的信息
	@RequestMapping("/getD_fileInfo")
	public void getD_fileInfo(HttpServletResponse response, HttpServletRequest request) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		String nowpage = request.getParameter("page");
		String pageSize = request.getParameter("limit");
		String product_name = request.getParameter("name");// 产品的名称
		String type = request.getParameter("type");// 用途类型
		String product_id = request.getParameter("product_id");// 产品的id
		String check_tag = request.getParameter("check_tag");//审核状态
		D_file df = new D_file();
		df.setProduct_name(product_name);
		df.setProduct_id(product_id);
		df.setType(type);
		if(check_tag==null) {
			df.setCheck_tag("审核通过");
		}else {
			df.setCheck_tag(check_tag);
		}
		PageDemo<D_file> pd = service.getD_fileInfo(Integer.parseInt(nowpage), Integer.parseInt(pageSize), df);
		PrintWriter out = response.getWriter();
		String str = JSONArray.toJSONString(pd);
		out.print(str);
		out.flush();
		out.close();
	}

	// 删除一个产品档案信息
	@RequestMapping("/updateDelProduct")
	@ResponseBody
	public String updateDelProduct(HttpServletRequest request, HttpSession session) {
		String product_id = request.getParameter("product_id");// 产品id
		int row = service.updateDelProduct(product_id);
		return row > 0 ? "成功" : "失败";
	}
	// 分页查询变更后的档案信息
	@RequestMapping("/getUpdateD_fileInfo")
	public void getUpdateD_fileInfo(HttpServletResponse response, HttpServletRequest request) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		String nowpage = request.getParameter("page");
		String pageSize = request.getParameter("limit");
		String product_name = request.getParameter("name");
		D_file df = new D_file();
		df.setProduct_name(product_name);
		PageDemo<D_file> pd = service.getUpdateD_fileInfo(Integer.parseInt(nowpage), Integer.parseInt(pageSize), df);
		PrintWriter out = response.getWriter();
		String str = JSONArray.toJSONString(pd);
		out.print(str);
		out.flush();
		out.close();
	}

	// 分页查询删除后的档案信息
	@RequestMapping("/getDelD_fileInfo")
	public void getDelD_fileInfo(HttpServletResponse response, HttpServletRequest request) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		String nowpage = request.getParameter("page");
		String pageSize = request.getParameter("limit");
		String product_name = request.getParameter("name");
		D_file df = new D_file();
		df.setProduct_name(product_name);
		PageDemo<D_file> pd = service.getDelD_fileInfo(Integer.parseInt(nowpage), Integer.parseInt(pageSize), df);
		PrintWriter out = response.getWriter();
		String str = JSONArray.toJSONString(pd);
		out.print(str);
		out.flush();
		out.close();
	}

	// 永久删除产品档案信息
	@RequestMapping("/DelProduct")
	@ResponseBody
	public String DelProduct(HttpServletRequest request) {
		String product_id = request.getParameter("product_id");// 产品id
		int row = service.delProductInfo(product_id);
		return row > 0 ? "成功" : "失败";
	}

	// 恢复已经删除的产品档案信息
	@RequestMapping("/RecoverDelProduct")
	@ResponseBody
	public String RecoverDelProduct(HttpServletRequest request) {
		String product_id = request.getParameter("product_id");// 产品id
		int row = service.RecoverDelProduct(product_id);
		return row > 0 ? "成功" : "失败";
	}

	// 产品物料组成设计(开始)
	// 商品的分页查询
	@RequestMapping("/getProductInfo")
	public void getProductInfo(HttpServletResponse response, HttpServletRequest request) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		String nowpage = request.getParameter("page");
		String pageSize = request.getParameter("limit");
		String name = request.getParameter("name");// 商品的名字
		D_file df = new D_file();
		df.setProduct_name(name);
		PageDemo<D_file> pd = service.getProductInfo(Integer.parseInt(nowpage), Integer.parseInt(pageSize), df);
		PrintWriter out = response.getWriter();
		String str = JSONArray.toJSONString(pd);
		out.print(str);
		out.flush();
		out.close();
	}

	// 打开物料设计单
	@RequestMapping("/openMaterialDesign")
	@ResponseBody
	public String openMaterialDesign(HttpServletRequest request, HttpSession session) {
		String product_id = request.getParameter("product_id");// 产品id
		String product_name = request.getParameter("product_name");// 产品名字
		SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = formate.format(new Date());// 登记的时间
		session.removeAttribute("materialList");
		session.setAttribute("product_id", product_id);
		session.setAttribute("product_name", product_name);
		session.setAttribute("time", time);
		return "成功";
	}

	// 物料的分页查询
	@RequestMapping("/getMaterialInfo")
	public void getMaterialInfo(HttpServletResponse response, HttpServletRequest request) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		String nowpage = request.getParameter("page");
		String pageSize = request.getParameter("limit");
		String name = request.getParameter("name");// 物料的名字
		D_file df = new D_file();
		df.setProduct_name(name);
		PageDemo<D_file> pd = service.getMaterialInfo(Integer.parseInt(nowpage), Integer.parseInt(pageSize), df);
		PrintWriter out = response.getWriter();
		String str = JSONArray.toJSONString(pd);
		out.print(str);
		out.flush();
		out.close();
	}

	// 为某个产品添加所需的物料
	@RequestMapping("/addmaterial")
	public void addmaterial(HttpServletRequest request, HttpSession session, HttpServletResponse response)
			throws Exception {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=utf-8");
		String product_id = request.getParameter("product_id");// 物料编号
		String product_name = request.getParameter("product_name");// 物料名称
		String type = request.getParameter("type");// 代表物料
		String product_describe = request.getParameter("product_describe");// 物料的描述
		String personal_unit = request.getParameter("personal_unit");// 计量单位
		String personal_value = request.getParameter("personal_value");// 需要添加物料的数量
		String cost_price = request.getParameter("cost_price");// 物料的单价
		String goods_id = (String) session.getAttribute("product_id");// 商品的编号
		double subtotal = Integer.parseInt(personal_value) * Double.parseDouble(cost_price);
		DModuleDetails dd = new DModuleDetails(goods_id, product_id, product_name, type, product_describe,
				personal_unit, Integer.parseInt(personal_value), Double.parseDouble(cost_price), subtotal);
		// 判断该物料是否已经添加，如果添加则修改数量
		List<DModuleDetails> dmList = service.getAllDModuleDetails();
		for (DModuleDetails dm : dmList) {
			if (product_id.equals(dm.getProduct_id()) && goods_id.equals(dm.getParent_id())) {
				service.updateMaterialNum(product_id, goods_id, Integer.parseInt(personal_value),
						Double.parseDouble(cost_price) * Integer.parseInt(personal_value));
				// 添加成功后,数量减少
				service.minusMaterialNum(Integer.parseInt(personal_value), product_id);
				List<DModuleDetails> list = service.queryMaterial(goods_id);
				session.removeAttribute("materialList");
				session.setAttribute("materialList", list);
				out.print("成功");
				out.flush();
				out.close();
				return;
			}
		}
		service.addMaterial(dd);
		// 添加成功后,数量减少
		service.minusMaterialNum(Integer.parseInt(personal_value), product_id);
		// 查询商品需要的物料
		List<DModuleDetails> list = service.queryMaterial(goods_id);
		session.setAttribute("materialList", list);
		out.print("成功");
		out.flush();
		out.close();
	}

	@RequestMapping("/addmaterial1")
	public void addmaterial1(HttpServletRequest request, HttpSession session, HttpServletResponse response)
			throws Exception {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=utf-8");
		String design_id = (String) session.getAttribute("design_id");// 设计单号
		String product_id = request.getParameter("product_id");// 物料编号
		String product_name = request.getParameter("product_name");// 物料名称
		String type = request.getParameter("type");// 代表物料
		String product_describe = request.getParameter("product_describe");// 物料的描述
		String personal_unit = request.getParameter("personal_unit");// 计量单位
		String personal_value = request.getParameter("personal_value");// 需要添加物料的数量
		String cost_price = request.getParameter("cost_price");// 物料的单价
		String goods_id1 = (String) session.getAttribute("product_id2");// 商品的编号
		double subtotal = Integer.parseInt(personal_value) * Double.parseDouble(cost_price);
		DModuleDetails dd = new DModuleDetails(goods_id1, product_id, product_name, type, product_describe,
				personal_unit, Integer.parseInt(personal_value), Double.parseDouble(cost_price), subtotal);
		// 判断该物料是否已经添加，如果添加则修改数量
		List<DModuleDetails> dmList = service.getAllDModuleDetails();
		for (DModuleDetails dm : dmList) {
			if (product_id.equals(dm.getProduct_id()) && goods_id1.equals(dm.getParent_id())) {
				service.updateMaterialNum(product_id, goods_id1, Integer.parseInt(personal_value),
						Double.parseDouble(cost_price) * Integer.parseInt(personal_value));
				// 添加成功后,数量减少
				service.minusMaterialNum(Integer.parseInt(personal_value), product_id);
				// 修改好后，物料总成本增加
				// 拿到需要物料的总成本
				double money = service.getMaterialSumMoney(goods_id1);
				service.updateMaterialSumMoneyadd(design_id, money);
				List<DModuleDetails> list = service.queryMaterial(goods_id1);
				session.removeAttribute("materialDetail1");
				session.setAttribute("materialDetail1", list);
				out.print("成功");
				out.flush();
				out.close();
				return;
			}
		}
		service.addMaterial(dd);
		// 拿到需要物料的总成本
		double money = service.getMaterialSumMoney(goods_id1);
		service.updateMaterialSumMoneyadd(design_id, money);
		// 查询商品需要的物料
		List<DModuleDetails> list1 = service.queryMaterial(goods_id1);
		session.removeAttribute("materialDetail1");
		session.setAttribute("materialDetail1", list1);
		// 添加成功后,数量减少
		service.minusMaterialNum(Integer.parseInt(personal_value), product_id);
		out.print("成功");
		out.flush();
		out.close();
	}

	// 删除一个商品需要的物料
	@RequestMapping("/delMaterial")
	public String delMaterial(String id, HttpSession session, String num, String parent_id) {
		int row = service.delMaterial(id, parent_id);
		// 删除过后，物料档案数量增加
		service.addMaterialNum(Integer.parseInt(num), id);
		session.removeAttribute("materialList");
		// 查询商品需要的物料
		String goods_id = (String) session.getAttribute("product_id");// 商品的编号
		List<DModuleDetails> list = service.queryMaterial(goods_id);
		session.setAttribute("materialList", list);
		return row > 0 ? "materialdesign" : "失败";
	}

	// 物料组成设计单完成进行保存
	@RequestMapping("/saveMaterail")
	public String saveMaterail(HttpServletRequest request, HttpSession session) {
		String product_id = (String) session.getAttribute("product_id");// 产品id
		String product_name = (String) session.getAttribute("product_name");// 产品名称
		String designer = request.getParameter("designer");// 设计人
		String checkerName = (String) session.getAttribute("username");// 登记人姓名
		String time = (String) session.getAttribute("time");// 登记时间
		String module_describe = request.getParameter("module_describe");// 设计要求
		String designId = service.getDesignDanHao();
		String design_id = DanhaoUtil.getDesignDanHao() + designId;// 设计单号
		// 拿到需要物料的总成本
		double cost_price_sum = service.getMaterialSumMoney(product_id);
		DModule dm = new DModule(design_id, product_id, product_name, designer, module_describe, checkerName, time,
				cost_price_sum);
		int row = service.saveMaterail(dm);
		// 修改商品的设计状态(已设计)
		service.updateGoodsDesign(product_id);
		return row > 0 ? "load2" : "失败";
	}

	// 拿到需要复核的物料组成设计信息
	@RequestMapping("/getMaterialFuHeInfo")
	public void getMaterialFuHeInfo(HttpServletResponse response, HttpServletRequest request) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		String nowpage = request.getParameter("page");
		String pageSize = request.getParameter("limit");
		String name = request.getParameter("name");// 商品的名字
		DModule dm = new DModule();
		dm.setProduct_name(name);
		PageDemo<DModule> pd = service.getMaterialFuHeInfo(Integer.parseInt(nowpage), Integer.parseInt(pageSize), dm);
		PrintWriter out = response.getWriter();
		String str = JSONArray.toJSONString(pd);
		out.print(str);
		out.flush();
		out.close();
	}

	// 物料组成设计单审核不通过
	@RequestMapping("/nofuheMaterial")
	@ResponseBody
	public String nofuheMaterial(HttpServletRequest request, HttpSession session) {
		String design_id = request.getParameter("design_id");// 设计单号
		String product_id = request.getParameter("product_id");// 产品单号
		String reason = request.getParameter("reason");// 审核不通过的理由
		String checker = (String) session.getAttribute("username");// 复核人姓名
		SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 复核时间
		DModule dm = new DModule();
		dm.setDesign_id(design_id);
		dm.setReason(reason);
		dm.setChecker(checker);
		dm.setCheck_time(formate.format(new Date()));
		dm.setCheck_tag("审核不通过");
		int row = service.updateMaterialFuHeInfo(dm);
		// 审核不通过，删除所需的物料
		service.delMaterialById(product_id);
		return row > 0 ? "成功" : "失败";
	}

	// 复核物料前根据id拿到产品所需物料的详细信息
	@RequestMapping("/getMaterialById")
	@ResponseBody
	public String getMaterialById(HttpServletRequest request, HttpSession session) {
		String product_id = request.getParameter("product_id");// 产品编号
		String product_name = request.getParameter("product_name");// 产品名称
		String design_id = request.getParameter("design_id");// 设计单号
		List<DModuleDetails> dd = service.getMaterialDetail(product_id);
		SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = formate.format(new Date());// 登记的时间
		// 根据设计单号拿信息
		DModule dm = service.getMaterialInfo(design_id);
		session.setAttribute("design_id", design_id);
		session.setAttribute("materialinfo", dm);
		session.setAttribute("product_id1", product_id);
		session.setAttribute("product_name1", product_name);
		session.setAttribute("time1", time);
		session.setAttribute("materialDetail", dd);
		return "成功";
	}

	// 复核物料前根据id拿到产品所需物料的详细信息
	@RequestMapping("/getMaterialById1")
	@ResponseBody
	public String getMaterialById1(HttpServletRequest request, HttpSession session) {
		String product_id = request.getParameter("product_id");// 产品编号
		String product_name = request.getParameter("product_name");// 产品名称
		String design_id = request.getParameter("design_id");// 设计单号
		List<DModuleDetails> dd = service.getMaterialDetail(product_id);
		SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = formate.format(new Date());// 登记的时间
		// 根据设计单号拿信息
		DModule dm = service.getMaterialInfo(design_id);
		session.setAttribute("design_id", design_id);
		session.setAttribute("materialinfo", dm);
		session.setAttribute("product_id2", product_id);
		session.setAttribute("product_name2", product_name);
		session.setAttribute("time2", time);
		session.setAttribute("materialDetail1", dd);
		return "成功";
	}

	@RequestMapping("/delMaterial1")
	public String delMaterial1(String id, HttpSession session, String num, String parent_id) {

		String design_id = (String) session.getAttribute("design_id");
		double money = service.getMaterialMoney(id, parent_id);
		int row = service.delMaterial(id, parent_id);
		// 删除过后，物料档案数量增加
		service.addMaterialNum(Integer.parseInt(num), id);
		session.removeAttribute("materialDetail1");
		// 删除后，总物料成本减少
		service.updateMaterialSumMoney(design_id, money);
		// 查询商品需要的物料
		String goods_id = (String) session.getAttribute("product_id2");// 商品的编号
		List<DModuleDetails> list = service.queryMaterial(goods_id);
		session.setAttribute("materialDetail1", list);
		return row > 0 ? "materialupdatedetail" : "失败";
	}

	// 复核物料通过审核
	@RequestMapping("/fuheMaterialSuccess")
	public String fuheMaterialSuccess(HttpSession session) {
		String design_id = (String) session.getAttribute("design_id");// 设计单号
		String checker = (String) session.getAttribute("username");// 复核人姓名
		SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 复核时间
		DModule dm = new DModule();
		dm.setDesign_id(design_id);
		dm.setChecker(checker);
		dm.setCheck_time(formate.format(new Date()));
		dm.setCheck_tag("审核通过");
		service.updateMaterialFuHeInfo(dm);
		return "load3";
	}

	// 分页查询物料信息(通过)
	@RequestMapping("/getAllModuleInfo")
	@ResponseBody
	public void getAllModuleInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		String nowpage = request.getParameter("page");
		String pageSize = request.getParameter("limit");
		String name = request.getParameter("name");// 物料的名字
		String product_id = request.getParameter("product_id");// 产品的编号
		String check_tag = request.getParameter("check_tag");//审核状态
		DModule dd = new DModule();
		dd.setProduct_name(name);
		dd.setProduct_id(product_id);
		if(check_tag==null) {
			dd.setCheck_tag("审核通过");
		}else {
			dd.setCheck_tag(check_tag);
		}
		PageDemo<DModule> pd = service.getAllModuleInfo(Integer.parseInt(nowpage), Integer.parseInt(pageSize), dd);
		PrintWriter out = response.getWriter();
		String str = JSONArray.toJSONString(pd);
		out.print(str);
		out.flush();
		out.close();
	}

	// 打开物料详细页面
	@RequestMapping("/openmakematerialdetail")
	@ResponseBody
	public String openmakematerialdetail(HttpServletRequest request, HttpSession session) {
		String product_id = request.getParameter("product_id");// 产品编号
		String product_name = request.getParameter("product_name");// 产品编号
		String design_id = request.getParameter("design_id");// 设计单号
		List<DModuleDetails> list = service.getMaterialDetail(product_id);
		session.setAttribute("materialdetail", list);
		session.setAttribute("goods_name", product_name);
		session.setAttribute("design_id", design_id);
		return "成功";
	}

	// 修改产品需要的物料
	@RequestMapping("/updateMaterialSuccess")
	public String updateMaterialSuccess(HttpServletRequest request, HttpSession session) {
		String product_id = request.getParameter("product_id");
		String designer = request.getParameter("designer");// 设计人
		String module_describe = request.getParameter("module_describe");// 设计要求
		String checker = (String) session.getAttribute("username");// 变更人姓名
		SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 变更时间
		DModule dm = new DModule();
		dm.setChanger(checker);
		dm.setChange_time(formate.format(new Date()));
		dm.setChange_tag("已变更");
		dm.setProduct_id(product_id);
		dm.setDesigner(designer);
		dm.setModule_describe(module_describe);
		service.updateMaterialSuccess(dm);
		return "load4";
	}

	// 分页查询变更后的物料组成设计信息
	@RequestMapping("/getMaterialupdateInfo")
	public void getMaterialupdateInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		String nowpage = request.getParameter("page");
		String pageSize = request.getParameter("limit");
		String name = request.getParameter("name");// 物料的名字
		String product_id = request.getParameter("product_id");// 产品的编号
		DModule dd = new DModule();
		dd.setProduct_name(name);
		dd.setProduct_id(product_id);
		PageDemo<DModule> pd = service.getMaterialupdateInfo(Integer.parseInt(nowpage), Integer.parseInt(pageSize), dd);
		PrintWriter out = response.getWriter();
		String str = JSONArray.toJSONString(pd);
		out.print(str);
		out.flush();
		out.close();
	}

	// 批量删除产品信息
	@RequestMapping("/batchdelteproduct")
	@ResponseBody
	public String batchdelteproduct(HttpServletRequest request) {
		String idlist = request.getParameter("idlist");
		List<D_file> list = JSON.parseArray(idlist, D_file.class);
		for (D_file df : list) {
			service.updateDelProduct(df.getProduct_id());
		}
		return "成功";
	}

	// 批量恢复产品信息
	@RequestMapping("/batchhuifuproduct")
	@ResponseBody
	public String batchhuifuproduct(HttpServletRequest request) {
		String idlist = request.getParameter("idlist");
		List<D_file> list = JSON.parseArray(idlist, D_file.class);
		for (D_file df : list) {
			service.RecoverDelProduct(df.getProduct_id());
		}
		return "成功";
	}
	//罗文涛的制定产品生产工序设计单分页查询
	@RequestMapping("/getProductlwtInfo")
	public void getProductlwtInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		String nowpage = request.getParameter("page");
		String pageSize = request.getParameter("limit");
		String name = request.getParameter("name");// 商品的名字
		D_file df = new D_file();
		df.setProduct_name(name);
		PageDemo<D_file> pd = service.getProductlwtInfo(Integer.parseInt(nowpage), Integer.parseInt(pageSize), df);
		PrintWriter out = response.getWriter();
		String str = JSONArray.toJSONString(pd);
		out.print(str);
		out.flush();
		out.close();
	}
	//杨林写的动态库存查询
	@RequestMapping("/getKuCunInfo")
	public void getKuCunInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		String nowpage = request.getParameter("page");
		String pageSize = request.getParameter("limit");
		String store_id = request.getParameter("store_id");//库存编号
		String product_id = request.getParameter("product_id");
		String product_name=request.getParameter("product_name");
		String type = request.getParameter("type");
		String product_class = request.getParameter("product_class");
		KuCun kc =new KuCun(store_id, product_id, product_name, type, product_class);
		PageDemo<KuCun> pd = service.getKuCunInfo(Integer.parseInt(nowpage), Integer.parseInt(pageSize), kc);
		PrintWriter out = response.getWriter();
		String str = JSONArray.toJSONString(pd);
		out.print(str);
		out.flush();
		out.close();
	}
}
