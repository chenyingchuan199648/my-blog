package com.chuanandhe.firstblog.myblog.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
public class Result<T> implements Serializable {
    private String resultState;  //0表示成功，1表示失败
    private String resulteMessage;
    private T resultData;

    public String getResultState() {
        return resultState;
    }

    public void setResultState(String resultState) {
        this.resultState = resultState;
    }

    public String getResulteMessage() {
        return resulteMessage;
    }

    public void setResulteMessage(String resulteMessage) {
        this.resulteMessage = resulteMessage;
    }

    public T getResultData() {
        return resultData;
    }

    public void setResultData(T resultData) {
        this.resultData = resultData;
    }
}
