package com.subway.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;


/**
 * <p>
 * 
 * </p>
 *
 * @author 张小岚
 * @since 2021-04-09
 */

@ApiModel(value="User对象", description="")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "openid")
    @TableId(value = "user_openid", type = IdType.INPUT)
    private String userOpenid;

    @ApiModelProperty(value = "名字")
    private String userName;

    @ApiModelProperty(value = "性别")
    private String userSex;

    @ApiModelProperty(value = "生日")
    private Date userBirthday;

    @ApiModelProperty(value = "电话")
    private String userTel;

    @ApiModelProperty(value = "头像")
    private String userAvatar;

    @ApiModelProperty(value = "所属部门")
    private String userDepartmentId;

    @ApiModelProperty(value = "等级")
    private String userLevel;

    private String userPassword;

    @ApiModelProperty(value = "逻辑删除 0表示未删除，1表示已删除")
    @TableLogic
    private Boolean isDelete;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    public User(String userOpenid, String userName, String userSex, Date userBirthday, String userTel, String userAvatar, String userDepartmentId, String userLevel) {
        this.userOpenid = userOpenid;
        this.userName = userName;
        this.userSex = userSex;
        this.userBirthday = userBirthday;
        this.userTel = userTel;
        this.userAvatar = userAvatar;
        this.userDepartmentId = userDepartmentId;
        this.userLevel = userLevel;
    }

    public User() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUserOpenid() {
        return userOpenid;
    }

    public void setUserOpenid(String userOpenid) {
        this.userOpenid = userOpenid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public String getUserDepartmentId() {
        return userDepartmentId;
    }

    public void setUserDepartmentId(String userDepartmentId) {
        this.userDepartmentId = userDepartmentId;
    }

    public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
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

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
