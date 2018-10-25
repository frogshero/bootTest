package com.example.bootTest.app.db.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@ApiModel
@Data
public class TestUser {
    @ApiModelProperty(value="主键", example = "1111")
    private Long id;

    @ApiModelProperty(value="组织名称")
    private Long orgId;

    @ApiModelProperty(value="登录名称")
    private String userName;

    @ApiModelProperty(value="真实姓名")
    private String realName;

    @ApiModelProperty(value="密码")
    private String pwd;

    @ApiModelProperty(value="电话")
    private String tel;

    @ApiModelProperty(value="地址")
    private String addr;

    @ApiModelProperty(value="邮箱")
    private String email;

    @ApiModelProperty(value="是否有效")
    private Integer enabled;

    @ApiModelProperty(value="创建时间")
    private Date createTime;

    @ApiModelProperty(value="更新时间")
    private Date updateTime;

}