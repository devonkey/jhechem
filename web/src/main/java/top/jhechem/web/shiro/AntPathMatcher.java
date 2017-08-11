package top.jhechem.web.shiro;

import org.apache.shiro.util.PatternMatcher;
import org.springframework.stereotype.Component;

/**
 * 使用springMVC的路径解析器实现shiro的路径匹配接口
 * Created by wuqiang on 2017/7/30.
 */
@Component
public class AntPathMatcher extends org.springframework.util.AntPathMatcher
        implements PatternMatcher {

    private static ThreadLocal<String> AUTH_PATHES = new ThreadLocal<>();

    @Override
    public boolean matches(String pattern, String source) {
        boolean res = super.match(pattern, source);
        if (res) {
            AUTH_PATHES.set(pattern);
        }
        return res;
    }

    /**
     * 获取当前匹配到的授权url
     */
    public static String getMatchedAuthPath(){
        return AUTH_PATHES.get();
    }

}
