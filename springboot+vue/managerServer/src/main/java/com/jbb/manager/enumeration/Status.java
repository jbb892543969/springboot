package com.jbb.manager.enumeration;

public enum Status {
    NORMAL(1), LOCKED(0);
    private Integer code;


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    private Status(Integer code) {
        this.code = code;
    }

    private Status() {
    }

}
