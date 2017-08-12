package top.jhechem.user.service;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;

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

    @GET
    @Path("list/{adminId:\\d+}")
    List<Integer> listAdminAuthGroups(@PathParam("adminId") int adminId);
}
