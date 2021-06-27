package com.subway.entity.vo;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class FaultVo {


    @ApiModelProperty(value = "故障id")
    private String faultId;

    @ApiModelProperty(value = "故障设备")
    private String faultEquipment;

    @ApiModelProperty(value = "故障地点")
    private String faultPlace;

    @ApiModelProperty(value = "故障描述")
    private String faultDescribe;

    @ApiModelProperty(value = "上报人信息")
    private String faultInspectionUserId;

    @ApiModelProperty(value = "调度员信息")
    private String faultControlUserId;

    @ApiModelProperty(value = "修理人信息")
    private String faultRepairUserId;

    @ApiModelProperty(value = "上报人信息")
    private String inspectionUserName;

    @ApiModelProperty(value = "调度人信息")
    private String controlUserName;

    @ApiModelProperty(value = "修理人信息")
    private String repairUserName;

    @ApiModelProperty(value = "头像")
    private String userAvatar;

    @ApiModelProperty(value = "上报时间")
    private Date createTime;

    public String getFaultId() {
        return faultId;
    }

    public void setFaultId(String faultId) {
        this.faultId = faultId;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public String getFaultEquipment() {
        return faultEquipment;
    }

    public void setFaultEquipment(String faultEquipment) {
        this.faultEquipment = faultEquipment;
    }

    public String getFaultPlace() {
        return faultPlace;
    }

    public void setFaultPlace(String faultPlace) {
        this.faultPlace = faultPlace;
    }

    public String getFaultDescribe() {
        return faultDescribe;
    }

    public void setFaultDescribe(String faultDescribe) {
        this.faultDescribe = faultDescribe;
    }

    public String getInspectionUserName() {
        return inspectionUserName;
    }

    public void setInspectionUserName(String inspectionUserName) {
        this.inspectionUserName = inspectionUserName;
    }

    public String getControlUserName() {
        return controlUserName;
    }

    public void setControlUserName(String controlUserName) {
        this.controlUserName = controlUserName;
    }

    public String getRepairUserName() {
        return repairUserName;
    }

    public void setRepairUserName(String repairUserName) {
        this.repairUserName = repairUserName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getFaultInspectionUserId() {
        return faultInspectionUserId;
    }

    public void setFaultInspectionUserId(String faultInspectionUserId) {
        this.faultInspectionUserId = faultInspectionUserId;
    }

    public String getFaultControlUserId() {
        return faultControlUserId;
    }

    public void setFaultControlUserId(String faultControlUserId) {
        this.faultControlUserId = faultControlUserId;
    }

    public String getFaultRepairUserId() {
        return faultRepairUserId;
    }

    public void setFaultRepairUserId(String faultRepairUserId) {
        this.faultRepairUserId = faultRepairUserId;
    }

    @Override
    public String toString() {
        return "FaultVo{" +
                "faultId='" + faultId + '\'' +
                ", faultEquipment='" + faultEquipment + '\'' +
                ", faultPlace='" + faultPlace + '\'' +
                ", faultDescribe='" + faultDescribe + '\'' +
                ", faultInspectionUserId='" + faultInspectionUserId + '\'' +
                ", faultControlUserId='" + faultControlUserId + '\'' +
                ", faultRepairUserId='" + faultRepairUserId + '\'' +
                ", inspectionUserName='" + inspectionUserName + '\'' +
                ", controlUserName='" + controlUserName + '\'' +
                ", repairUserName='" + repairUserName + '\'' +
                ", userAvatar='" + userAvatar + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
