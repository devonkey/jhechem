package top.jhechem.user.service;

import cn.idongjia.common.query.BaseSearch;
import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import top.jhechem.user.pojo.Admin;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.nio.charset.Charset;
import java.util.List;

/**
 * 管理员
 * Created by wuqiang on 2017/7/23.
 */
@Produces({ContentType.APPLICATION_JSON_UTF_8})
@Path("admin")
public interface AdminService {

    String DEFAULT_PASSWORD_CHARSET = "UTF-8";

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    Admin add(Admin admin);

    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    int update(Admin admin);

    @DELETE
    @Path("{id:\\d+}")
    int delete(@PathParam("id") long id);

    @GET
    @QueryParam("username")
    Admin getByUsername(@QueryParam("username") String username);

    @GET
    @Path("{id:\\d+}")
    Admin get(@PathParam("id") long id);

    @GET
    @Path("list")
    List<Admin> list(@BeanParam BaseSearch search);
}
