package top.jhechem.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import top.jhechem.core.Response;
import top.jhechem.core.constant.ExceptionResponse;
import top.jhechem.core.util.Assert;
import top.jhechem.user.pojo.Role;
import top.jhechem.user.service.RoleService;
import top.jhechem.web.BaseController;

import javax.annotation.Resource;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import java.util.List;

/**
 * 角色控制
 * Created by wuqiang on 2017/7/31.
 */
@Controller
@Path("role")
@ResponseBody
public class RoleController extends BaseController {

    @Resource
    private RoleService roleService;

    @POST
    @Path("add")
    public Response add(@RequestBody Role role) {
        roleService.add(role);
        return Response.ok();
    }

    @PUT
    @Path("update")
    public Response update(@RequestBody Role role) {
        Assert.assertNotNull(role, ExceptionResponse.MISS_ARGRUMENTS);
        Assert.assertNotNull(role.getId(), ExceptionResponse.MISS_ARGRUMENTS);
        roleService.update(role);
        return Response.ok();
    }

    @POST
    @Path("add_admin/{roleId:\\d+}")
    public Response addAdmin(@PathVariable("roleId") int roleId, @RequestBody List<Long> adminIds) {
        Assert.assertNotNull(adminIds, ExceptionResponse.MISS_ARGRUMENTS);
        roleService.addAdmin(roleId, adminIds);
        return Response.ok();
    }

    @POST
    @Path("remove_admin/{roleId:\\d+}")
    public Response removeAdmin(int roleId, List<Long> adminIds) {
        Assert.assertNotNull(adminIds, ExceptionResponse.MISS_ARGRUMENTS);
        roleService.removeAdmin(roleId, adminIds);
        return Response.ok();
    }

}
