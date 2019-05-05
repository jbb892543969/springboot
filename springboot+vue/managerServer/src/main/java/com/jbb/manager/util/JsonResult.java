package com.jbb.manager.util;

/**
 * @ClassName JsonResult
 * @Author 金斌斌
 * @Description
 * @Date 2018-07-06 11:25
 **/
public class JsonResult {
    //返回code码，200成功，其他统一自定义
    private Integer code;

    private String msg;

    private Object data;

    public JsonResult(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public JsonResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
