package com.xt.pojo;

import java.util.Date;
import java.io.Serializable;

/**
 * 日志信息(SysLogs)实体类
 *
 * @author makejava
 * @since 2020-04-17 10:35:18
 */
public class SysLogs implements Serializable {
    private static final long serialVersionUID = -72584709241863178L;
    /**
    * 序号
    */
    private Integer id;
    /**
    * 用户名称
    */
    private String loginId;
    /**
    * 级别
    */
    private String priority;
    /**
    * 时间
    */
    private Date logDate;
    /**
    * 类名
    */
    /**
    * 方法名
    */
    private String method;
    /**
    * 信息
    */
    private String msg;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }
    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}