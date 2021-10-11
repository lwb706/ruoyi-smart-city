package com.ruoyi.goods.domain;

//错误码及错误信息包装类
public class ResultMessage {
    public String returnCode;
    public String returnMessage;

    public String getReturnCode () {
        return returnCode;
    }

    public void setReturnCode ( String returnCode ) {
        this.returnCode = returnCode;
    }

    public String getReturnMessage () {
        return returnMessage;
    }

    public void setReturnMessage ( String returnMessage ) {
        this.returnMessage = returnMessage;
    }

    @Override
    public String toString () {
        return "ResultMessage{" +
                "returnCode='" + returnCode + '\'' +
                ", returnMessage='" + returnMessage + '\'' +
                '}';
    }
}
