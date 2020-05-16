package com.xt.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ShengchanUtil {
	// 日期格式化
	public static String formatDateToCommon(Date date) {
		SimpleDateFormat formate = new SimpleDateFormat("yyyyMMdd");
		return formate.format(date);
	}

	public static String formatDateToCommon1(Date date) {
		SimpleDateFormat formate = new SimpleDateFormat("yyyyMMddHHmmss");
		return formate.format(date);
	}

	// 产品编号
	public static String getProductDanHao() {
		// 获取当前时间
		Date d = new Date();
		// 生成唯一的字符串
		String danhao = "m" + ShengchanUtil.formatDateToCommon(d) + RadomUtil.generateNumber();
		return danhao;
	}

	// 产品编号
	public static String getscpgd() {
		// 获取当前时间
		Date d = new Date();
		// 生成唯一的字符串
		String danhao = "sc" + ShengchanUtil.formatDateToCommon1(d);
		return danhao;
	}
	
	//供货商编号生成方法
	public static String getSupplierId() {
		String SupplierId="s"+RadomUtil.generateNumber();
		return SupplierId;
		
	}
}
