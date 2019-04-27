package com.szxy.spdb.po;

public class WebResult {

    private String retCode;

    private String message;

    private Object value;

    public static final String SUCCESS = "0";

    public static final String FAIL = "1";

    public static final String SUCCESS_MESSAGE = "yes";

    public static final String FAIL_MESSAGE = "no";

    public WebResult() {
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public static WebResult success(){
        WebResult result = new WebResult();
        result.setMessage(SUCCESS_MESSAGE);
        result.setRetCode(SUCCESS);
        result.setValue(null);
        return result;
    }

    public static WebResult success(String message){
        WebResult result = new WebResult();
        result.setRetCode(SUCCESS);
        result.setMessage(message);
        result.setValue(null);
        return result;
    }

    public static WebResult success(Object value){
        WebResult result = new WebResult();
        result.setRetCode(SUCCESS);
        result.setValue(value);
        result.setMessage(SUCCESS_MESSAGE);
        return result;
    }

    public static WebResult success(String message,Object value){
        WebResult result = new WebResult();
        result.setRetCode(SUCCESS);
        result.setMessage(message);
        result.setValue(value);
        return result;
    }

    public static WebResult fail(){
        WebResult result = new WebResult();
        result.setValue(null);
        result.setRetCode(FAIL);
        result.setMessage(FAIL_MESSAGE);
        return result;
    }

    public static WebResult fail(String message){
        WebResult result = new WebResult();
        result.setRetCode(FAIL);
        result.setValue(null);
        result.setMessage(message);
        return result;
    }
}
