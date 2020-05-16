package com.xt.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @Copyright (C), 2015-2019, XXX有限公司
 * @ClassName: Config
 * @Author: 作者杨林
 * @E-mail: 邮箱
 * @Date: 2019/10/28 20:58
 * @Version: V1.0
 * @Description: 对该类的描述
 */
public class Config {
	private static final String QUERY_PATH = "https://api.miaodiyun.com/20150822/industrySMS/sendSMS";
    private static final String ACCOUNT_SID = "6dcb089ea7e65623a7cf5ed313fe8445";
    private static final String AUTH_TOKEN = "69cfa6d5be4d88ba7ee5eca0fa1ecfac";
    private static final String RESP_DATA_TYPE = "JSON";
    public static String random;//创建验证码，用于60秒后失效
    
    
    //设置多少秒后过期
    public static void countDown(int limitSec) throws InterruptedException {
		while(limitSec > 0){
			TimeUnit.SECONDS.sleep(1);
		}
	}
    // 创建验证码
    public static String smsCode() {
        random = (int) ((Math.random() * 9 + 1) * 100000) + "";
        return random;
    }
    public static String createCommonParam(String sid,String token) {
        // 时间戳
        long timestamp = System.currentTimeMillis();
        // 签名
        String sig = DigestUtils.md5Hex(sid + token + timestamp);

        return "&timestamp=" + timestamp + "&sig=" + sig + "&respDataType=" + Config.RESP_DATA_TYPE;
    }

    /**
     * post请求
     *
     * @param url
     *            功能和操作
     * @param body
     *            要post的数据
     * @return
     */
    public static String post(String url, String body) {
        System.out.println("body:" + System.lineSeparator() + body);

        String result = "";
        try {
            OutputStreamWriter out = null;
            BufferedReader in = null;
            URL realUrl = new URL(url);
            URLConnection conn = realUrl.openConnection();

            // 设置连接参数
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(20000);
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            // 提交数据
            out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
            out.write(body);
            out.flush();

            // 读取返回数据
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line = "";
            boolean firstLine = true; // 读第一行不加换行符
            while ((line = in.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                } else {
                    result += System.lineSeparator();
                }
                result += line;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public static String getCode(String phone) throws Exception {

        String rod = smsCode();
        StringBuilder sb = new StringBuilder();
        sb.append("accountSid").append("=").append(Config.ACCOUNT_SID);
        sb.append("&to").append("=").append(phone);
        sb.append("&param").append("=").append(URLEncoder.encode("","UTF-8"));


        //注意templateid(模板id) 和 smsContent(模板内容) 两者选其中之一就行，或者

        //sb.append("&templateid").append("=").append("1251");
        sb.append("&smsContent").append("=").append( URLEncoder.encode("【义乌市冠志武术馆】您的验证码为"+rod+"，该验证码1分钟内有效。请勿泄漏于他人。","UTF-8"));
        

        String body = sb.toString() + Config.createCommonParam(Config.ACCOUNT_SID, Config.AUTH_TOKEN);
        String result = Config.post(Config.QUERY_PATH, body);
        System.out.println(result);
        return rod;
    }

    /*
    public static void main(String[] args) throws Exception {
        String phone = "17674579134";
        getCode(phone);
        countDown(10);
        Config.smsCode();
        System.out.println(random);
    }*/
}
