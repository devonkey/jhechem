package top.jhechem.web.filter;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import top.jhechem.user.service.AdminFunctionAuthGroupService;
import top.jhechem.web.biz.AuthBiz;
import top.jhechem.web.biz.TaskBiz;
import top.jhechem.web.shiro.AntPathMatcher;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import static top.jhechem.core.constant.ExceptionResponse.NEED_LOGIN;

/**
 * 自定义权限认证
 * Created by wuqiang on 2017/7/23.
 */
public class PermissionsAuthorizationFilter extends AuthorizationFilter {

    @Resource
    private AntPathMatcher pathMatcher;
    @Resource
    private AuthBiz authBiz;
    @Resource
    private TaskBiz taskBiz;
    @Resource
    private AdminFunctionAuthGroupService adminFunctionAuthGroupService;

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        Subject subject = getSubject(request, response);
        //url对应的权限组
        String[] perms = (String[]) mappedValue;

        if (perms == null || perms.length == 0) {
            return true;
        }

        //url在任何一个权限组里，则授权成功
        for (String perm : perms) {
            if (subject.isPermitted(perm)) {
                return true;
            }
        }

        String authGroupIdOfTimeLimitLessPerm = adminFunctionAuthGroupService.getAuthGroupIdOfTimeLimitLess() + "";

        if (!subject.isPermitted(authGroupIdOfTimeLimitLessPerm)
                && !taskBiz.redisAvailable()) {
            authBiz.unauthorized(request, response);
            return false;
        }

        if (subject.getPrincipal() == null) {
            authBiz.redirectToLogin(request, response, NEED_LOGIN);
        } else {
            authBiz.unauthorized(request, response);
        }
        return false;
    }


    @Override
    protected boolean pathsMatch(String pattern, String path) {
        return pathMatcher.matches(pattern, path);
    }
}
