package com.xt.pojo;

import java.util.Date;
import java.io.Serializable;

/**
 * 角色信息实体类
 *
 * @author makejava
 * @since 2020-04-17 10:35:18
 */
public class Roles implements Serializable {
    private static final long serialVersionUID = -79843625080241189L;
    //角色表主键，1为默认角色
    private Integer id;
    //角色名称
    private String name;
    //角色描述
    private String descinfo;
    //创建角色的时间
    private Date time;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescinfo() {
        return descinfo;
    }

    public void setDescinfo(String descinfo) {
        this.descinfo = descinfo;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

}