package top.jhechem.web.biz;

import cn.idongjia.log.Log;
import cn.idongjia.log.LogFactory;
import org.apache.shiro.config.Ini;
import org.apache.shiro.web.config.IniFilterChainResolverFactory;
import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import top.jhechem.user.pojo.FunctionAuth;
import top.jhechem.user.service.FunctionAuthService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 动态加载权限所在权限组
 * Created by wuqiang on 2017/7/25.
 */
public class ShiroDynamicLoadDefinitionImpl implements ShiroDynamicLoadDefinition, InitializingBean {

    private static final Log LOGGER = LogFactory.getLog(ShiroDynamicLoadDefinitionImpl.class);

    @Autowired
    @Qualifier("shiroFilter")
    private AbstractShiroFilter shiroFilter;
    @Autowired
    private FunctionAuthService functionAuthService;

    private String filterChainDefinitions;

    @Override
    public synchronized void reloadPermission() {
        LOGGER.debug("reload资源权限配置开始！");
        try {
            Map<String, String> urlDefinitionMap = generateSection();
            DefaultFilterChainManager manager = getFilterChainManager();
            manager.getFilterChains().clear();
            addToChain(manager, urlDefinitionMap);
        } catch (Exception e) {
            LOGGER.error("reload资源权限配置发生错误！", e);
            throw new RuntimeException(e);
        }
        LOGGER.debug("reload资源权限配置结束！");
    }


    private Ini.Section generateSection() {
        Ini ini = new Ini();
        ini.load(filterChainDefinitions); // 加载资源文件节点串定义的初始化权限信息
        Ini.Section section = ini.getSection(IniFilterChainResolverFactory.URLS); // 使用默认节点
        if (section == null || section.isEmpty()) {
            section = ini.getSection(Ini.DEFAULT_SECTION_NAME);//如不存在默认节点切割,则使用空字符转换
        }
        List<FunctionAuth> auths = functionAuthService.listFunctionAuth();
        Map<String, String> authsMap = new HashMap<>();
        auths.forEach(auth ->
                authsMap.put(auth.getUrl(), "perms" + auth.getAuthGroups().toString()));
        LOGGER.info("authsMap:{}", authsMap);
        section.putAll(authsMap);
        section.put("/**", "authc");
        return section;
    }

    private DefaultFilterChainManager getFilterChainManager() throws Exception {
        PathMatchingFilterChainResolver filterChainResolver =
                (PathMatchingFilterChainResolver) shiroFilter.getFilterChainResolver();
        DefaultFilterChainManager manager =
                (DefaultFilterChainManager) filterChainResolver.getFilterChainManager();
        return manager;
    }

    private void addToChain(DefaultFilterChainManager manager, Map<String, String> definitions) throws Exception {
        if (definitions == null || definitions.isEmpty()) {
            return;
        }
        //移除/**的过滤器链，防止新加的权限不起作用。
        manager.getFilterChains().remove("/**");
        for (Map.Entry<String, String> entry : definitions.entrySet()) {
            String url = entry.getKey();
            String chainDefinition = entry.getValue().trim().replace(" ", "");
            manager.createChain(url, chainDefinition);
        }
    }

    public String getFilterChainDefinitions() {
        return filterChainDefinitions;
    }

    public void setFilterChainDefinitions(String filterChainDefinitions) {
        this.filterChainDefinitions = filterChainDefinitions;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        reloadPermission();
    }
}