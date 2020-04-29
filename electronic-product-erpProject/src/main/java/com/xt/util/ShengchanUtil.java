package com.xt.util;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 
 * @author cqk
 *
 */
public class ShengchanUtil {
	// 日期格式化
	public static String formatDateToCommon(Date date) {
		SimpleDateFormat formate = new SimpleDateFormat("yyyyMMddHHmmss");
		return formate.format(date);
	}
	
	// 产品编号
	public static String getProductDanHao() {
		// 获取电脑上的当前时间
		Date d = new Date();
		String danhao = "m" + ShengchanUtil.formatDateToCommon(d);
		return danhao;
	}
	public static void main(String[] args) {
		System.out.println(getProductDanHao());
	}

}
