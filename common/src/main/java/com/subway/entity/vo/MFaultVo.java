package com.subway.entity.vo;

import java.util.List;

public class MFaultVo {
    private String fault_id;
    private String fault_place;
    private String fault_equipment;
    private String fault_describe;
    private String fault_picture;
    private String fault_inspection_user_id;
    private String fault_control_user_id;
    private String fault_state;
    private String fault_inspection_user_name;
    private String fault_control_user_name;
    private String f_create_time;

    private List<MRepairVo> repairVos;

    public String getFault_id() {
        return fault_id;
    }

    public void setFault_id(String fault_id) {
        this.fault_id = fault_id;
    }

    public String getFault_place() {
        return fault_place;
    }

    public void setFault_place(String fault_place) {
        this.fault_place = fault_place;
    }

    public String getFault_equipment() {
        return fault_equipment;
    }

    public void setFault_equipment(String fault_equipment) {
        this.fault_equipment = fault_equipment;
    }

    public String getFault_describe() {
        return fault_describe;
    }

    public void setFault_describe(String fault_describe) {
        this.fault_describe = fault_describe;
    }

    public String getFault_picture() {
        return fault_picture;
    }

    public void setFault_picture(String fault_picture) {
        this.fault_picture = fault_picture;
    }

    public String getFault_inspection_user_id() {
        return fault_inspection_user_id;
    }

    public void setFault_inspection_user_id(String fault_inspection_user_id) {
        this.fault_inspection_user_id = fault_inspection_user_id;
    }

    public String getFault_control_user_id() {
        return fault_control_user_id;
    }

    public void setFault_control_user_id(String fault_control_user_id) {
        this.fault_control_user_id = fault_control_user_id;
    }

    public String getFault_state() {
        return fault_state;
    }

    public void setFault_state(String fault_state) {
        this.fault_state = fault_state;
    }

    public String getFault_inspection_user_name() {
        return fault_inspection_user_name;
    }

    public void setFault_inspection_user_name(String fault_inspection_user_name) {
        this.fault_inspection_user_name = fault_inspection_user_name;
    }

    public String getFault_control_user_name() {
        return fault_control_user_name;
    }

    public void setFault_control_user_name(String fault_control_user_name) {
        this.fault_control_user_name = fault_control_user_name;
    }

    public String getF_create_time() {
        return f_create_time;
    }

    public void setF_create_time(String f_create_time) {
        this.f_create_time = f_create_time;
    }

    public List<MRepairVo> getRepairVos() {
        return repairVos;
    }

    public void setRepairVos(List<MRepairVo> repairVos) {
        this.repairVos = repairVos;
    }

    @Override
    public String toString() {
        return "MFaultVo{" +
                "fault_id='" + fault_id + '\'' +
                ", fault_place='" + fault_place + '\'' +
                ", fault_equipment='" + fault_equipment + '\'' +
                ", fault_describe='" + fault_describe + '\'' +
                ", fault_picture='" + fault_picture + '\'' +
                ", fault_inspection_user_id='" + fault_inspection_user_id + '\'' +
                ", fault_control_user_id='" + fault_control_user_id + '\'' +
                ", fault_state='" + fault_state + '\'' +
                ", fault_inspection_user_name='" + fault_inspection_user_name + '\'' +
                ", fault_control_user_name='" + fault_control_user_name + '\'' +
                ", f_create_time='" + f_create_time + '\'' +
                ", repairVos=" + repairVos +
                '}';
    }
}
