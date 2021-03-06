package com.example.bootTest.app.db.entity;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class  RoleAuthority {
    @ApiModelProperty(value = "主键id", required = true)
    private Long id;

    @ApiModelProperty(value = "角色id", required = true)
    private Long roleId;

    @ApiModelProperty(value = "权限id", required = true)
    private String authId;

    @ApiModelProperty(value = "创建时间", required = true)
    private Date createTime;

    @ApiModelProperty(value = "更新时间", required = true)
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getAuthId() {
        return authId;
    }

    public void setAuthId(String authId) {
        this.authId = authId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
