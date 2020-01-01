package top.jhechem.user.service;

import org.apache.dubbo.rpc.protocol.rest.support.ContentType;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

/**
 * 管理员权限权限组关系
 * Created by wuqiang on 2017/7/23.
 */
@Produces({ContentType.APPLICATION_JSON_UTF_8})
@Path("admin_function_auth_group")
public interface AdminFunctionAuthGroupService {

    String TIME_LIMIT_LESS_AUTH_NAME = "系统无限使用时间";

    /**
     * 查询所有授权组
     * @param adminId 管理员id
     * @return 管理员授权组
     */
    @GET
    @Path("list/{adminId:\\d+}")
    List<Integer> listAdminAuthGroups(@PathParam("adminId") int adminId);

    @GET
    @Path("auth_group/time_less")
    int getAuthGroupIdOfTimeLimitLess();
}
