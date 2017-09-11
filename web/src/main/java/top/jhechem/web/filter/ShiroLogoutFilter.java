package top.jhechem.web.filter;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import top.jhechem.core.constant.ExceptionResponse;
import top.jhechem.user.pojo.Admin;
import top.jhechem.web.biz.AuthBiz;
import top.jhechem.web.shiro.SessionDAO;

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
    @Resource
    private SessionDAO sessionDAO;

    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        Subject subject = getSubject(request, response);
        subject.logout();

        Admin admin = (Admin) subject.getPrincipal();
        if (admin != null) {
            sessionDAO.delByAdminId(admin.getId());
        }
        loginBiz.redirectToLogin(request, response, ExceptionResponse.LOGOUT_SUCCESS);
        return false;
    }
}
