package com.subway.entity.vo;


import java.util.Date;

public class DispatchVo {
    private String dispatchId;

    private String dispatchFaultId;

    private String dispatchFromUserId;

    private String dispatchToUserId;

    private String fromUserName;

    private String toUserName;

    private String dispatchState;

    private Date createTime;

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

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getDispatchState() {
        return dispatchState;
    }

    public void setDispatchState(String dispatchState) {
        this.dispatchState = dispatchState;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
