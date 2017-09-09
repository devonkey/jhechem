package top.jhechem.web.shiro;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SimpleSession;

import java.io.Serializable;

/**
 * router 业务需要用的session接口
 * Created by wuqiang on 2017/8/17.
 */
public interface SessionDAO {

    SimpleSession read(Serializable id);

    void del(Serializable id);

    SimpleSession readByAdminId(long adminId);

    void delByAdminId(long adminId);

    void writeSessionId(long adminId, Session session);
}
