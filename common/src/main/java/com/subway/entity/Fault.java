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
@ApiModel(value="Fault对象", description="")
public class Fault implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "故障id")
    @TableId(value = "fault_id", type = IdType.ID_WORKER_STR)
    private String faultId;

    @ApiModelProperty(value = "故障地点")
    private String faultPlace;

    @ApiModelProperty(value = "故障设备")
    private String faultEquipment;

    @ApiModelProperty(value = "故障描述")
    private String faultDescribe;

    @ApiModelProperty(value = "图片")
    private String faultPicture;

    @ApiModelProperty(value = "上报人信息")
    private String faultInspectionUserId;

    @ApiModelProperty(value = "调度员信息")
    private String faultControlUserId;

    @ApiModelProperty(value = "修理人信息")
    private String faultRepairUserId;

    @ApiModelProperty(value = "故障状态 0表示未处理，1表示处理中，2表示处理完成")
    private Integer faultState;


    @ApiModelProperty(value = "逻辑删除 0表示未删除，1表示已删除")
    @TableLogic
    private Boolean isDelete;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getFaultId() {
        return faultId;
    }

    public void setFaultId(String faultId) {
        this.faultId = faultId;
    }

    public String getFaultPlace() {
        return faultPlace;
    }

    public void setFaultPlace(String faultPlace) {
        this.faultPlace = faultPlace;
    }

    public String getFaultEquipment() {
        return faultEquipment;
    }

    public void setFaultEquipment(String faultEquipment) {
        this.faultEquipment = faultEquipment;
    }

    public String getFaultDescribe() {
        return faultDescribe;
    }

    public void setFaultDescribe(String faultDescribe) {
        this.faultDescribe = faultDescribe;
    }

    public String getFaultPicture() {
        return faultPicture;
    }

    public void setFaultPicture(String faultPicture) {
        this.faultPicture = faultPicture;
    }

    public Integer getFaultState() {
        return faultState;
    }

    public void setFaultState(Integer faultState) {
        this.faultState = faultState;
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

}
