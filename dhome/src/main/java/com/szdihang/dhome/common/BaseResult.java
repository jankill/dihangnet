package com.szdihang.dhome.common;

import java.io.Serializable;

/**
 * @author glory
 * @version V1.0
 * @Title: BaseResult
 * @Package: com.szdihang.dhome.model
 * @Description: TODO
 * @date 2019/4/3 15:04
 **/
public class BaseResult implements Serializable {
    private String resultCode;
    private String resultMessage;
    public BaseResult() {

    }

    public BaseResult(StatusCode statusCode) {
        this.resultCode = statusCode.getCode();
        this.resultMessage = statusCode.getDesc();
    }

    public BaseResult(StatusCode statusCode,String msg) {
        this.resultCode = statusCode.getCode();
        this.resultMessage = msg;
    }

    public void setStatusCode(StatusCode statusCode) {
        this.resultCode = statusCode.getCode();
        this.resultMessage = statusCode.getDesc();
    }

    public void setStatusCode(StatusCode statusCode,String msg) {
        this.resultCode = statusCode.getCode();
        this.resultMessage = msg;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }
}
