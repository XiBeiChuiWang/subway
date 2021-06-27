package com.subway.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class Dispatch {
    @TableId(value = "dispatch_id",type = IdType.INPUT)
    private String dispatchId;

    private String dispatchFaultId;

    private String dispatchFromUserId;

    private String dispatchToUserId;

    private String dispatchState;

    private String refused;

    @ApiModelProperty(value = "逻辑删除 0表示未删除，1表示已删除")
    @TableLogic
    private Boolean isDelete;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    public String getDispatchId() {
        return dispatchId;
    }

    public void setDispatchId(String dispatchId) {
        this.dispatchId = dispatchId;
    }

    public String getDispatchFaultId() {
        return dispatchFaultId;
    }

    public void setDispatchFaultId(String dispatchFaultId) {
        this.dispatchFaultId = dispatchFaultId;
    }

    public String getDispatchFromUserId() {
        return dispatchFromUserId;
    }

    public void setDispatchFromUserId(String dispatchFromUserId) {
        this.dispatchFromUserId = dispatchFromUserId;
    }

    public String getDispatchToUserId() {
        return dispatchToUserId;
    }

    public void setDispatchToUserId(String dispatchToUserId) {
        this.dispatchToUserId = dispatchToUserId;
    }

    public String getDispatchState() {
        return dispatchState;
    }

    public void setDispatchState(String dispatchState) {
        this.dispatchState = dispatchState;
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

    public String getRefused() {
        return refused;
    }

    public void setRefused(String refused) {
        this.refused = refused;
    }
}
