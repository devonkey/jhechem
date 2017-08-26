package top.jhechem.web.filter;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import top.jhechem.core.constant.ExceptionResponse;
import top.jhechem.web.biz.AuthBiz;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 登出过滤
 * Created by wuqiang on 2017/7/25.
 */
public class ShiroLogoutFilter extends LogoutFilter {

    @Resource
    private AuthBiz loginBiz;

    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        Subject subject = getSubject(request, response);
        subject.logout();
        loginBiz.redirectToLogin(request, response, ExceptionResponse.LOGOUT_SUCCESS);
        return false;
    }
}
