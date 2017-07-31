package top.jhechem.core;

import cn.idongjia.common.base.Base;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import top.jhechem.core.base.Pagination;

import java.util.List;

/**
 * 响应类
 * Created by wuqiang on 2017/7/24.
 */
@SuppressWarnings("unused")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T> extends Base {

    public static final int SUCCESS_CODE = 0;
    public static final String SUCCESS_MSG = "请求成功", FAIL_MSG = "请求失败";

    private Integer code;
    private String msg;
    private T res;

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

    public T getRes() {
        return res;
    }

    public void setRes(T res) {
        this.res = res;
    }


    public static Response ok() {
        return new Response<>(SUCCESS_CODE, SUCCESS_MSG);
    }

    public static <T> Response<T> ok(T res) {
        return new Response<>(SUCCESS_CODE, SUCCESS_MSG, res);
    }

    public static <T> Response<Pagination<T>> paginate(List<T> items, int total) {
        return new Response<>(SUCCESS_CODE,SUCCESS_MSG, new Pagination<>(items, total));
    }

    public Response() {
    }

    public Response(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Response(Integer code, String msg, T res) {
        this.code = code;
        this.msg = msg;
        this.res = res;
    }
}
