package top.jhechem.web.controller;

import cn.idongjia.log.Log;
import cn.idongjia.log.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.jhechem.core.Response;
import top.jhechem.core.constant.ExceptionResponse;
import top.jhechem.web.BaseController;
import top.jhechem.web.biz.AuthBiz;

import javax.servlet.http.HttpServletRequest;

/**
 * 登录控制
 * shiro 进行登录和权限控制后，将登录结果转发过来
 * Created by wuqiang on 2017/7/21.
 */
@Controller
@RequestMapping("auth")
@ResponseBody
public class AuthResultController extends BaseController {

    private static final Log LOGGER = LogFactory.getLog(AuthResultController.class);

    @RequestMapping("login/success")
    public Response success() {
        LOGGER.info("login success.");
        return Response.ok(SecurityUtils.getSubject().getPrincipal());
    }

    @RequestMapping("login/failure")
    public Response failure(HttpServletRequest request) {
        return (Response) request.getServletContext().getAttribute(AuthBiz.DISPATCHER_RESULT_KEY);
    }

    @RequestMapping("login/redirect")
    public Response redirect(HttpServletRequest request) {
        Object response = request.getAttribute(AuthBiz.DISPATCHER_RESULT_KEY);
        if (response != null) {
            return (Response) response;
        }
        return ExceptionResponse.NEED_LOGIN;
    }

    @RequestMapping("unauthorized")
    public Response unauthorized() {
        return ExceptionResponse.UNAUTHORIZED;
    }

}
