package com.ft.demo.dto;

public class RestResp<T> {
    private boolean ok;
    private String errMsg;
    private T data;
    public boolean isOk() {
        return ok;
    }
    public void setOk(boolean ok) {
        this.ok = ok;
    }
    public String getErrMsg() {
        return errMsg;
    }
    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }

    public static <R> RestResp<R> ok(R data){
        RestResp<R> res = new RestResp<>();
        res.setOk(true);
        res.setData(data);
        return res;
    }

    public static <R> RestResp<R> fail(String errMsg, R data){
        RestResp<R> res = new RestResp<>();
        res.setOk(false);
        res.setData(data);
        res.setErrMsg(errMsg);
        return res;
    }
}
