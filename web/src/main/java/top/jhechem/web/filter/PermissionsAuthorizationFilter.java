package top.jhechem.web.filter;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 自定义权限认证
 * Created by wuqiang on 2017/7/23.
 */
public class PermissionsAuthorizationFilter extends AuthorizationFilter {
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
        return false;
    }
}
