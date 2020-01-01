package top.jhechem.web.shiro;

import cn.devonkey.Const;
import cn.devonkey.log.Log;
import cn.devonkey.log.LogFactory;
import lombok.Getter;
import lombok.Setter;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.SimpleSession;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import top.jhechem.core.ApiException;
import top.jhechem.core.util.SerializeUtils;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static top.jhechem.core.constant.ExceptionResponse.SYSTEM_ERROR;

/**
 * session实现
 * Created by wuqiang on 2017/8/9.
 */
@Setter
@Getter
public class SessionDAOImpl extends AbstractSessionDAO implements SessionDAO {

    private static final String SESSION_PREFIX = "SimpleSession_";
    private static final String SESSION_ADMIN_REL_PREFIX = "admin_sessionId_";

    private static final Log LOGGER = LogFactory.getLog(SessionDAOImpl.class);

    private JedisPool pool;

    @Override
    protected Serializable doCreate(Session session) {
        if (!(session instanceof SimpleSession)) {
            LOGGER.error("session 不是PbSimpleSession的实例.");
            throw new ApiException(SYSTEM_ERROR);
        }
        SimpleSession s = (SimpleSession) session;
        Serializable sessionId = generateSessionId(session);
        s.setId(sessionId);
        save(s);
        return s.getId();
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        return read(sessionId);
    }

    @Override
    public void update(Session session) throws UnknownSessionException {
        save((SimpleSession) session);
    }

    @Override
    public void delete(Session session) {
        del(session.getId());
    }

    @Override
    public Collection<Session> getActiveSessions() {
        Collection<byte[]> valuess = new HashSet<>();
        try (Jedis jedis = pool.getResource()) {
            Set<byte[]> keys = jedis.keys(SESSION_PREFIX.getBytes());
            keys.forEach(key -> valuess.add(jedis.get(key)));
        }
        Collection<Session> sessions = new HashSet<>();
        valuess.forEach(values -> {
            if (values == null && values.length == 0) {
                return;
            }
            SimpleSession session = SerializeUtils.deserialize(values);
            sessions.add(session);
        });
        return sessions;
    }

    private void save(SimpleSession session) {
        byte[] bytes = (SESSION_PREFIX + session.getId()).getBytes();
        try (Jedis jedis = pool.getResource()) {
            jedis.set(bytes, SerializeUtils.serialize(session));
            jedis.expire(bytes, (int) (session.getTimeout() / Const.MILLISECOND_RATIO));
        }
    }

    @Override
    public SimpleSession read(Serializable id) {
        byte[] bytes = (SESSION_PREFIX + id).getBytes();
        byte[] values;
        try (Jedis jedis = pool.getResource()) {
            values = jedis.get(bytes);
        }
        if (values == null || values.length == 0) {
            return null;
        }
        return SerializeUtils.deserialize(values);
    }

    @Override
    public void del(Serializable id) {
        byte[] bytes = (SESSION_PREFIX + id).getBytes();
        try (Jedis jedis = pool.getResource()) {
            jedis.del(bytes);
        }
    }

    @Override
    public SimpleSession readByAdminId(long adminId) {
        String sessionId = getSessionId(adminId);
        if (sessionId == null) return null;
        return read(sessionId);
    }

    @Override
    public void delByAdminId(long adminId) {
        LOGGER.info("删除用户:{}登录状态", adminId);
        String sessionId = getSessionId(adminId);
        if (sessionId == null) return;
        del(sessionId);
    }

    @Override
    public void writeSessionId(long adminId, Session session) {
        String key = SESSION_ADMIN_REL_PREFIX + adminId;
        try (Jedis jedis = pool.getResource()) {
            jedis.set(key, (String) session.getId());
            jedis.expire(key, (int) (session.getTimeout() / Const.MILLISECOND_RATIO));
        }
    }

    private String getSessionId(long adminId) {
        String key = SESSION_ADMIN_REL_PREFIX + adminId;
        try (Jedis jedis = pool.getResource()) {
            return jedis.get(key);
        }
    }
}
