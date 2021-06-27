package com.subway.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * <p>
 * 
 * </p>
 *
 * @author 张小岚
 * @since 2021-04-25
 */
@ApiModel(value="Repair对象", description="")
public class Repair implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "repair_id", type = IdType.ID_WORKER_STR)
    private String repairId;

    @ApiModelProperty(value = "故障id")
    private String repairFaultId;

    @ApiModelProperty(value = "修理工id")
    private String repairUserId;

    @ApiModelProperty(value = "修理日志")
    private String repairDescribe;

    private String repairPicture;

    private Integer repairLevel;

    @ApiModelProperty(value = "逻辑删除")
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

    public String getRepairId() {
        return repairId;
    }

    public void setRepairId(String repairId) {
        this.repairId = repairId;
    }

    public String getRepairFaultId() {
        return repairFaultId;
    }

    public void setRepairFaultId(String repairFaultId) {
        this.repairFaultId = repairFaultId;
    }

    public String getRepairUserId() {
        return repairUserId;
    }

    public void setRepairUserId(String repairUserId) {
        this.repairUserId = repairUserId;
    }

    public String getRepairDescribe() {
        return repairDescribe;
    }

    public void setRepairDescribe(String repairDescribe) {
        this.repairDescribe = repairDescribe;
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

    public String getRepairPicture() {
        return repairPicture;
    }

    public void setRepairPicture(String repairPicture) {
        this.repairPicture = repairPicture;
    }

    public Integer getRepairLevel() {
        return repairLevel;
    }

    public void setRepairLevel(Integer repairLevel) {
        this.repairLevel = repairLevel;
    }
}
