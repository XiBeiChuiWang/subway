package com.subway.entity.vo;

public class DispatchSubmitVo {
    private String faultId;
    private String dispatchId;
    private String RepairUserId;
    private String refused;

    public String getFaultId() {
        return faultId;
    }

    public void setFaultId(String faultId) {
        this.faultId = faultId;
    }

    public String getDispatchId() {
        return dispatchId;
    }

    public void setDispatchId(String dispatchId) {
        this.dispatchId = dispatchId;
    }

    public String getRepairUserId() {
        return RepairUserId;
    }

    public void setRepairUserId(String repairUserId) {
        RepairUserId = repairUserId;
    }

    public String getRefused() {
        return refused;
    }

    public void setRefused(String refused) {
        this.refused = refused;
    }
}
