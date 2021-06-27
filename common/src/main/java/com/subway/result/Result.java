package com.subway.result;

import io.swagger.annotations.ApiModelProperty;

import java.util.HashMap;
import java.util.Map;

public class Result {

    @ApiModelProperty("是否成功")
    private Boolean isSuccess;

    private Integer code;

    private String message;

    private Map<String,Object> data = new HashMap<>();


    private Result() {
    }

    public static Result ok(){
        Result ok = new Result().setCode(ResultCode.SUCCESS).setMessage("成功").setSuccess(true);
        return ok;
    }

    public static Result error(){

        Result error = new Result().setCode(ResultCode.ERROR).setMessage("失败").setSuccess(false);
        return error;
    }

    public static Result forward(){
        Result forward = new Result().setCode(ResultCode.FORWARD).setMessage("转发").setSuccess(true);
        return forward;
    }

    public static Result flush(){
        Result forward = new Result().setCode(ResultCode.FLUSH).setMessage("刷新").setSuccess(true);
        return forward;
    }

    public static Result agree(){
        Result forward = new Result().setCode(ResultCode.AGREE).setMessage("已成功接单").setSuccess(true);
        return forward;
    }

    public static Result refuse(){
        Result forward = new Result().setCode(ResultCode.REFUSE).setMessage("已拒绝接单").setSuccess(true);
        return forward;
    }

    public Result data(String key,Object object){
        data.put(key,object);
        return this;
    }


    public Boolean getSuccess() {
        return isSuccess;
    }

    public Result setSuccess(Boolean success) {
        isSuccess = success;
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public Result setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Result setMessage(String message) {
        this.message = message;
        return this;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public Result setData(Map<String, Object> data) {
        this.data = new HashMap<>(data);
        return this;
    }

    @Override
    public String toString() {
        return "Result{" +
                "isSuccess=" + isSuccess +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
