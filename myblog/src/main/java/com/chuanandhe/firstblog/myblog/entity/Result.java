package com.chuanandhe.firstblog.myblog.entity;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Result {
    private String resultState;  //0表示成功，1表示失败
    private String resulteMessage;
    private List resultData;

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

    public List getResultData() {
        return resultData;
    }

    public void setResultData(List resultData) {
        this.resultData = resultData;
    }
}
