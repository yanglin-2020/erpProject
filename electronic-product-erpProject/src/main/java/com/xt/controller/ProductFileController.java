package com.xt.controller;

/**
 * 产品档案
 * @author yl
 *
 */
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.xt.pojo.D_file;
import com.xt.service.ProductFileService;
import com.xt.util.DanhaoUtil;

@Controller
public class ProductFileController {
	@Autowired
	ProductFileService service;

	@RequestMapping("/addProductFile")
	public String addProductFile(HttpServletRequest request) {
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
