package top.jhechem.core;

import java.io.Serializable;

/**
 * 异常封装
 * Created by wuqiang on 2017/7/30.
 */
public class ApiException extends RuntimeException implements Serializable {

    private Integer code;
    private String msg;

    public ApiException() {
    }

    public ApiException(Response response) {
        this.code = response.getCode();
        this.msg = response.getMsg();
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
}
