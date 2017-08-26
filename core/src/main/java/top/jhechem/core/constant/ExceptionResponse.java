package top.jhechem.core.constant;

import top.jhechem.core.Response;

/**
 * 异常响应
 * Created by wuqiang on 2017/7/25.
 */
public class ExceptionResponse {

    public static final Response MISS_ARGRUMENTS = new Response(400, "参数错误~");

    public static final Response INVALID_PASSWORD = new Response(401, "密码无效~");
    public static final Response NO_USER = new Response(401, "未注册~");
    public static final Response LOGIN_FAILURE = new Response(401, "登录失败~");
    public static final Response NEED_LOGIN = new Response(401, "请登录~");
    public static final Response NO_RESOURCE = new Response(401, "无权限资源~");
    public static final Response LOGOUT_SUCCESS = new Response(401, "登出成功~");

    public static final Response UNAUTHORIZED = new Response(403, "未授权~");

    public static final int DEFAULT_ERROR_CODE = 500;

    public static Response response(String msg) {
        return new Response(DEFAULT_ERROR_CODE, msg);
    }
}
