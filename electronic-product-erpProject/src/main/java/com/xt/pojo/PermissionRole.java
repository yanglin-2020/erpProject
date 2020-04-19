package com.xt.pojo;

import java.io.Serializable;

/**
 * 菜单角色实体类
 *
 * @author makejava
 * @since 2020-04-17 10:35:18
 */
public class PermissionRole implements Serializable {
    private static final long serialVersionUID = 189135782510390650L;
    //角色id
    private Integer rid;
    //菜单id
    private Integer pid;


    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

}