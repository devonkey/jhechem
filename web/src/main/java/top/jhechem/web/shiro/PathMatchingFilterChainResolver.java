package top.jhechem.web.shiro;

import org.springframework.stereotype.Component;
import top.jhechem.web.shiro.AntPathMatcher;

import javax.annotation.Resource;

/**
 * 重写filter匹配器匹配方法
 * Created by wuqiang on 2017/7/30.
 */
@Component
public class PathMatchingFilterChainResolver
        extends org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver {

    @Resource
    private AntPathMatcher pathMatcher;

    @Override
    protected boolean pathMatches(String pattern, String path) {
        return pathMatcher.matches(pattern, path);
    }
}
