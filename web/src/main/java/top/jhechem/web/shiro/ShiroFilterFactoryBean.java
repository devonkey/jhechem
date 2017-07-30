package top.jhechem.web.shiro;

import cn.idongjia.log.Log;
import cn.idongjia.log.LogFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.web.filter.mgt.FilterChainManager;
import org.apache.shiro.web.mgt.WebSecurityManager;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.springframework.beans.factory.BeanInitializationException;

import javax.annotation.Resource;

/**
 * 重写ShiroFilterFactoryBean 重新注入PathMatchingFilterChainResolver
 * Created by wuqiang on 2017/7/30.
 */
public class ShiroFilterFactoryBean extends org.apache.shiro.spring.web.ShiroFilterFactoryBean {

    private static final Log LOGGER = LogFactory.getLog(ShiroFilterFactoryBean.class);

    @Resource
    private PathMatchingFilterChainResolver chainResolver;

    /**
     * This implementation:
     * <ol>
     * <li>Ensures the required {@link #setSecurityManager(org.apache.shiro.mgt.SecurityManager) securityManager}
     * property has been set</li>
     * <li>{@link #createFilterChainManager() Creates} a {@link FilterChainManager} instance that reflects the
     * configured {@link #setFilters(java.util.Map) filters} and
     * {@link #setFilterChainDefinitionMap(java.util.Map) filter chain definitions}</li>
     * <li>Wraps the FilterChainManager with a suitable
     * {@link org.apache.shiro.web.filter.mgt.FilterChainResolver FilterChainResolver} since the Shiro Filter
     * implementations do not know of {@code FilterChainManager}s</li>
     * <li>Sets both the {@code SecurityManager} and {@code FilterChainResolver} instances on a new Shiro Filter
     * instance and returns that filter instance.</li>
     * </ol>
     *
     * @return a new Shiro Filter reflecting any configured filters and filter chain definitions.
     * @throws Exception if there is a problem creating the AbstractShiroFilter instance.
     */
    @Override
    protected AbstractShiroFilter createInstance() throws Exception {

        LOGGER.debug("Creating Shiro Filter instance.");

        SecurityManager securityManager = getSecurityManager();
        if (securityManager == null) {
            String msg = "SecurityManager property must be set.";
            throw new BeanInitializationException(msg);
        }

        if (!(securityManager instanceof WebSecurityManager)) {
            String msg = "The security manager does not implement the WebSecurityManager interface.";
            throw new BeanInitializationException(msg);
        }

        FilterChainManager manager = createFilterChainManager();

        //Expose the constructed FilterChainManager by first wrapping it in a
        // FilterChainResolver implementation. The AbstractShiroFilter implementations
        // do not know about FilterChainManagers - only resolvers:
        chainResolver.setFilterChainManager(manager);

        //Now create a concrete ShiroFilter instance and apply the acquired SecurityManager and built
        //FilterChainResolver.  It doesn't matter that the instance is an anonymous inner class
        //here - we're just using it because it is a concrete AbstractShiroFilter instance that accepts
        //injection of the SecurityManager and FilterChainResolver:
        return new AbstractShiroFilter() {
            {
                setSecurityManager((WebSecurityManager) securityManager);
                setFilterChainResolver(chainResolver);
            }
        };
    }

}
