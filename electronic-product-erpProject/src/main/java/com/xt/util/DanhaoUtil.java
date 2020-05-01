package com.xt.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
/**
 * 各种单号生成工具类
 */
import java.text.SimpleDateFormat;
import java.util.Date;

public class DanhaoUtil {
	// 日期格式化
	public static String formatDateToCommon(Date date) {
		SimpleDateFormat formate = new SimpleDateFormat("yyyyMMdd");
		return formate.format(date);
	}

	// 产品编号
	public static String getProductDanHao() {
		// 获取电脑上的当前时间
		Date d = new Date();
		String danhao = "p" + DanhaoUtil.formatDateToCommon(d);
		return danhao;
	}

	// 设计编号
	public static String getDesignDanHao() {
		// 获取电脑上的当前时间
		Date d = new Date();
		String danhao = "d" + DanhaoUtil.formatDateToCommon(d);
		return danhao;
	}

	/**
	 * 生成库存编号
	 * 
	 * @return
	 */
	public static String getKcBianhao() {
		SimpleDateFormat formate = new SimpleDateFormat("yyyyMMddhhmmss");
		Date date = new Date();
		String danhao = "kc" + formate.format(date);
		return danhao;
	}

	public static String getLocalAddress() {
		String ip = "";
		try {
			ip = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) { 
			e.printStackTrace();
		}
		return ip;
	}
}
