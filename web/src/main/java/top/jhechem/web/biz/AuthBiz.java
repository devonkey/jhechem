package top.jhechem.web.biz;

import cn.idongjia.log.Log;
import cn.idongjia.log.LogFactory;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Component;
import top.jhechem.core.Response;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

import static top.jhechem.core.constant.ExceptionResponse.INVALID_PASSWORD;
import static top.jhechem.core.constant.ExceptionResponse.LOGIN_FAILURE;
import static top.jhechem.core.constant.ExceptionResponse.NO_USER;


/**
 * 登路流程业务控制
 * Created by wuqiang on 2017/7/21.
 */
@Component
public class AuthBiz {

    public static final String DISPATCHER_RESULT_KEY = "dispatcher_result";

    private static final String DISPATCHER_SUCCESS_URL = "/auth/login/success";
    private static final String DISPATCHER_FAILURE_URL = "/auth/login/failure";
    private static final String DISPATCHER_REDIRECT_URL = "/auth/login/redirect";

    private static final String DISPATCHER_ACCESS_NOT_ALLOW_URL = "/auth/accesss_not_allow";
    private static final String DISPATCHER_UNAUTHORIZED_URL = "/auth/unauthorized";

    private static final Log LOGGER = LogFactory.getLog(AuthBiz.class);

    /**
     * 写php session
     */
    private void writePhpSession(Subject subject) {
        //TODO impl
    }

    /**
     * 写登录 session
     */
    private void writeSession(AuthenticationToken token) {
        //TODO impl
    }

    /**
     * 登录成功响应
     */
    public void loginSuccess(AuthenticationToken token, Subject subject,
                             ServletRequest request, ServletResponse response) {
        writePhpSession(subject);
        writeSession(token);
        try {
            request.getRequestDispatcher(DISPATCHER_SUCCESS_URL).forward(request, response);
        } catch (ServletException | IOException e1) {
            LOGGER.error(e1);
        }
    }

    /**
     * 登录失败响应封装
     *
     * @param e shiro认证异常
     */
    public void loginFailure(AuthenticationException e
            , ServletRequest request, ServletResponse response) {
        Response result;
        if (e instanceof IncorrectCredentialsException) {
            result = INVALID_PASSWORD;
        } else if (e instanceof UnknownAccountException) {
            result = NO_USER;
        } else {
            result = LOGIN_FAILURE;
        }
        request.getServletContext().setAttribute(DISPATCHER_RESULT_KEY, result);
        try {
            request.getRequestDispatcher(DISPATCHER_FAILURE_URL).forward(request, response);
        } catch (ServletException | IOException e1) {
            LOGGER.error(e1);
        }
    }

    public void redirectToLogin(ServletRequest request, ServletResponse response) {
        try {
            request.getRequestDispatcher(DISPATCHER_REDIRECT_URL).forward(request, response);
        } catch (ServletException | IOException e1) {
            LOGGER.error(e1);
        }
    }

    public void accessNotAllow(ServletRequest request, ServletResponse response) {
        try {
            request.getRequestDispatcher(DISPATCHER_ACCESS_NOT_ALLOW_URL).forward(request, response);
        } catch (ServletException | IOException e1) {
            LOGGER.error(e1);
        }
    }

    public void unauthorized(ServletRequest request, ServletResponse response) {
        try {
            request.getRequestDispatcher(DISPATCHER_UNAUTHORIZED_URL).forward(request, response);
        } catch (ServletException | IOException e1) {
            LOGGER.error(e1);
        }
    }

}
