package com.example.mylibrary.exception;

public class ApiException extends Throwable{
    String mesg;
    int code;

    public ApiException(String mesg, int code) {
        this.mesg = mesg;
        this.code = code;
    }

    public String getMesg() {
        return mesg;
    }

    public void setMesg(String mesg) {
        this.mesg = mesg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
