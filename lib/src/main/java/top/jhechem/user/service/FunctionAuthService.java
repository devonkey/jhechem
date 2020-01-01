package top.jhechem.user.service;

import org.apache.dubbo.rpc.protocol.rest.support.ContentType;
import top.jhechem.user.pojo.FunctionAuth;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.util.List;
import java.util.Set;

/**
 * 功能权限服务
 * Created by wuqiang on 2017/7/23.
 */
@Produces({ContentType.APPLICATION_JSON_UTF_8})
@Path("function_auth")
public interface FunctionAuthService {

    /**
     * 查询所有权限以及其拥有改权限的权限组
     */
    @GET
    @Path("list")
    List<FunctionAuth> listFunctionAuth();

    @GET
    @Path("ranges")
    Set<Integer> getRanges(@QueryParam("path") String path, @QueryParam("adminId") int adminId);

}
