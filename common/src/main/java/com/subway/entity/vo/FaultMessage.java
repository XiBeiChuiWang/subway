package com.subway.entity.vo;

import java.util.Date;

public class FaultMessage {
    private String faultId;
    private String faultEquipment;
    private String userName;
    private String faultPlace;
    private Date createTime;

    public String getFaultId() {
        return faultId;
    }

    public void setFaultId(String faultId) {
        this.faultId = faultId;
    }

    public String getFaultEquipment() {
        return faultEquipment;
    }

    public void setFaultEquipment(String faultEquipment) {
        this.faultEquipment = faultEquipment;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFaultPlace() {
        return faultPlace;
    }

    public void setFaultPlace(String faultPlace) {
        this.faultPlace = faultPlace;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
