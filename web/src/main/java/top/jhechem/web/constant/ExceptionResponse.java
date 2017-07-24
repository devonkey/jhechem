package top.jhechem.web.constant;

import top.jhechem.web.Response;

/**
 * 异常响应
 * Created by wuqiang on 2017/7/25.
 */
public class ExceptionResponse {

    public static final Response INVALID_PASSWORD = new Response(10, "密码无效~");
    public static final Response NO_USER = new Response(11, "未注册~");
    public static final Response LOGIN_FAILURE = new Response(12, "登录失败~");

}
