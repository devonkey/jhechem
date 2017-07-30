package top.jhechem.web.shiro;

import cn.idongjia.util.MD5Encoder;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.codec.CodecSupport;

import static top.jhechem.user.service.AdminService.DEFAULT_PASSWORD_CHARSET;

/**
 * 匹配认证
 * Created by wuqiang on 2017/7/25.
 */
public class ShiroCredentialsMatcher extends CodecSupport implements CredentialsMatcher {
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        if (token == null || info == null) return false;

        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        SimpleAuthenticationInfo authenticationInfo = (SimpleAuthenticationInfo) info;

        char[] destCredentials = (char[]) usernamePasswordToken.getCredentials();
        if (destCredentials == null) return false;

        String destPwd = new String(destCredentials);

        Object originPwd = info.getCredentials();
        if (originPwd == null) return false;
        String salt = new String(authenticationInfo.getCredentialsSalt().getBytes());
        String encodeDestPwd = MD5Encoder.encode(destPwd + salt, DEFAULT_PASSWORD_CHARSET);

        if (originPwd.equals(encodeDestPwd)) {
            return true;
        }
        return false;
    }

}
