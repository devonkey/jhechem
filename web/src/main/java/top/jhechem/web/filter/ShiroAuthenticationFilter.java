package top.jhechem.web.filter;

import cn.devonkey.log.Log;
import cn.devonkey.log.LogFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import top.jhechem.user.pojo.Admin;
import top.jhechem.web.biz.AuthBiz;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * shiro 认证过滤
 * Created by wuqiang on 2017/7/21.
 */
public class ShiroAuthenticationFilter extends FormAuthenticationFilter {

    private static final Log LOGGER = LogFactory.getLog(ShiroAuthenticationFilter.class);
    @Resource
    private AuthBiz authBiz;

    @Override
    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {

        ObjectMapper mapper = new ObjectMapper();
        try {
            Admin admin = mapper.readValue(request.getInputStream(), Admin.class);
            return createToken(admin.getUsername(),
                    admin.getPassword(), false, request.getRemoteHost());
        } catch (IOException e) {
            LOGGER.error(e);
            throw new AuthenticationException(e);
        }
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        Subject subject = SecurityUtils.getSubject();
        if (isLoginRequest(request, response)) {
            subject.logout();
        }
        return false;
    }

    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        authBiz.loginSuccess(token, subject, request, response);
        return false;
    }

    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
        authBiz.loginFailure(e, request, response);
        return false;
    }

    @Override
    protected void redirectToLogin(ServletRequest request, ServletResponse response) throws IOException {
        authBiz.redirectToLogin(request, response);
    }

}
