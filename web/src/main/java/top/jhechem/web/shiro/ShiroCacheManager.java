package top.jhechem.web.shiro;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;

public class ShiroCacheManager<Integer, AuthorizationInfo> implements CacheManager {
    @Override
    public <Integer, AuthorizationInfo> Cache<Integer, AuthorizationInfo> getCache(String name) throws CacheException {
        return null;
    }
}
