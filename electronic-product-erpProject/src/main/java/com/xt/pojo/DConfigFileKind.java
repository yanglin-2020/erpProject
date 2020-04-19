package com.xt.pojo;

import java.io.Serializable;

/**
 * 产品分类设置实体类
 *
 * @author makejava
 * @since 2020-04-17 10:35:14
 */
public class DConfigFileKind implements Serializable {
    private static final long serialVersionUID = -96386085685597712L;
    /**
    * 序号
    */
    private Integer id;
    /**
    * 父级序号
    */
    private Integer pId;
    /**
    * 分类编号
    */
    private String kindId;
    /**
    * 分类名称
    */
    private String kindName;
    /**
    * 级别
    */
    private Integer kindLevel;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPId() {
        return pId;
    }

    public void setPId(Integer pId) {
        this.pId = pId;
    }

    public String getKindId() {
        return kindId;
    }

    public void setKindId(String kindId) {
        this.kindId = kindId;
    }

    public String getKindName() {
        return kindName;
    }

    public void setKindName(String kindName) {
        this.kindName = kindName;
    }

    public Integer getKindLevel() {
        return kindLevel;
    }

    public void setKindLevel(Integer kindLevel) {
        this.kindLevel = kindLevel;
    }

}