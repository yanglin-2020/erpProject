package com.xt.util;

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

	// 销售单号生成
	public static String getXsDanHao() {
		// 获取电脑上的当前时间
		Date d = new Date();
		String danhao = "xs" + DanhaoUtil.formatDateToCommon(d);
		return danhao;
	}

	public static void main(String[] args) {
		System.out.println(getXsDanHao());
	}
}
