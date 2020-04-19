package com.xt.pojo;

import java.io.Serializable;

/**
 * 基础代码表(SysCodes)实体类
 *
 * @author makejava
 * @since 2020-04-17 10:35:18
 */
public class SysCodes implements Serializable {
    private static final long serialVersionUID = 159045731080714879L;
    /**
    * 序号
    */
    private Integer id;
    /**
    * 父级序号
    */
    private Integer parentId;
    /**
    * 代码编号
    */
    private String codeId;
    /**
    * 代码名称
    */
    private String name;
    /**
    * 状态
    */
    private String status;
    /**
    * 默认值
    */
    private String defValuenot;
    /**
    * 说明
    */
    private String descnnot;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getCodeId() {
        return codeId;
    }

    public void setCodeId(String codeId) {
        this.codeId = codeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDefValuenot() {
        return defValuenot;
    }

    public void setDefValuenot(String defValuenot) {
        this.defValuenot = defValuenot;
    }

    public String getDescnnot() {
        return descnnot;
    }

    public void setDescnnot(String descnnot) {
        this.descnnot = descnnot;
    }

}