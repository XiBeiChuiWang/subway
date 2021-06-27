package com.subway.entity.vo;

import java.util.List;

public class MRepairVo {
    private String repair_id;
    private String repair_user_id;
    private String r_user_name;
    private String repair_describe;
    private String r_create_time;

    public String getRepair_id() {
        return repair_id;
    }

    public void setRepair_id(String repair_id) {
        this.repair_id = repair_id;
    }

    public String getRepair_user_id() {
        return repair_user_id;
    }

    public void setRepair_user_id(String repair_user_id) {
        this.repair_user_id = repair_user_id;
    }

    public String getR_user_name() {
        return r_user_name;
    }

    public void setR_user_name(String r_user_name) {
        this.r_user_name = r_user_name;
    }

    public String getRepair_describe() {
        return repair_describe;
    }

    public void setRepair_describe(String repair_describe) {
        this.repair_describe = repair_describe;
    }

    public String getR_create_time() {
        return r_create_time;
    }

    public void setR_create_time(String r_create_time) {
        this.r_create_time = r_create_time;
    }

    @Override
    public String toString() {
        return "MRepairVo{" +
                "repair_id='" + repair_id + '\'' +
                ", repair_user_id='" + repair_user_id + '\'' +
                ", r_user_name='" + r_user_name + '\'' +
                ", repair_describe='" + repair_describe + '\'' +
                ", r_create_time='" + r_create_time + '\'' +
                '}';
    }
}
