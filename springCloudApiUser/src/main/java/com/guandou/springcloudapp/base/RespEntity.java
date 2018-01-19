package com.guandou.springcloudapp.base;

public class RespEntity {
    private int code;
    private String msg;
    private Object data;
    public void setCode(int code) {
        this.code = code;
    }
    public void setRespCode(RespCode respCode) {
        this.code = respCode.getCode();
        this.msg=respCode.getMsg();
    }

    public int getCode() {
        return code;
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
