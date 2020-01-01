package top.jhechem.user.service;

import org.apache.dubbo.rpc.protocol.rest.support.ContentType;
import top.jhechem.core.base.BaseSearch;
import top.jhechem.user.pojo.Admin;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
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
    int delete(@PathParam("id") int id);

    @GET
    @QueryParam("username")
    Admin getByUsername(@QueryParam("username") String username);

    @GET
    @Path("{id:\\d+}")
    Admin get(@PathParam("id") int id);

    @GET
    @Path("list")
    List<Admin> list(@BeanParam BaseSearch search);

    @GET
    @Path("count")
    int count(@BeanParam BaseSearch search);

}
