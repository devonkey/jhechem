package top.jhechem.web.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import top.jhechem.core.util.Utils;
import top.jhechem.user.pojo.Admin;
import top.jhechem.user.service.AdminFunctionAuthGroupService;
import top.jhechem.user.service.AdminService;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 获取认证和授权信息
 * Created by wuqiang on 2017/7/25.
 */
public class ShiroRealm extends AuthorizingRealm {

    @Resource
    private AdminService adminService;
    @Resource
    private AdminFunctionAuthGroupService adminFunctionAuthGroupService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        Admin admin = (Admin) principals.getPrimaryPrincipal();
        Admin adminInfo = adminService.getByUsername(admin.getUsername());
        if (adminInfo == null) return null;
        List<Integer> authGroupIds =
                adminFunctionAuthGroupService.listAdminAuthGroups(adminInfo.getId());

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        Set<String> perms = new HashSet<>();
        authGroupIds.forEach(authGroupId -> perms.add(authGroupId.toString()));
        authorizationInfo.setStringPermissions(perms);

        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        if (token == null) return null;
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String username = usernamePasswordToken.getUsername();
        char[] password = usernamePasswordToken.getPassword();
        if (Utils.isEmpty(username) || password == null || password.length == 0) {
            return null;
        }
        Admin admin = adminService.getByUsername(username);
        if (admin == null) return null;

        List<Integer> authGroupIds =
                adminFunctionAuthGroupService.listAdminAuthGroups(admin.getId());
        admin.setAuthGroups(authGroupIds);

        SimpleAuthenticationInfo simpleAuthenticationInfo =
                new SimpleAuthenticationInfo(admin, admin.getPassword(), admin.getRealName());
        simpleAuthenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(admin.getSalt()));

        return simpleAuthenticationInfo;
    }
}
