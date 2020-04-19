package com.xt.pojo;

import java.io.Serializable;

/**
 * 用户角色实体类
 *
 * @author makejava
 * @since 2020-04-17 10:35:18
 */
public class UserRole implements Serializable {
    private static final long serialVersionUID = 926639589913512322L;
    //用户id
    private Integer uId;
    //角色id
    private Integer rId;


    public Integer getUId() {
        return uId;
    }

    public void setUId(Integer uId) {
        this.uId = uId;
    }

    public Integer getRId() {
        return rId;
    }

    public void setRId(Integer rId) {
        this.rId = rId;
    }

}