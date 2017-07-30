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
    @Override
    public boolean matches(String pattern, String source) {
        return super.match(pattern, source);
    }

}
