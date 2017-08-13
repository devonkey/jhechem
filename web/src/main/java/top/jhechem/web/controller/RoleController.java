package top.jhechem.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.jhechem.core.Response;
import top.jhechem.core.constant.ExceptionResponse;
import top.jhechem.core.util.Assert;
import top.jhechem.user.pojo.Role;
import top.jhechem.user.service.RoleService;
import top.jhechem.web.BaseController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 角色控制
 * Created by wuqiang on 2017/7/31.
 */
@Controller
@RequestMapping("role")
@ResponseBody
public class RoleController extends BaseController {

    @Resource
    private RoleService roleService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public Response<List<Role>> list() {
        return Response.ok(roleService.listRole());
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public Response add(@RequestBody Role role) {
        roleService.add(role);
        return Response.ok();
    }

    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public Response update(@RequestBody Role role) {
        Assert.assertNotNull(role, ExceptionResponse.MISS_ARGRUMENTS);
        Assert.assertNotNull(role.getId(), ExceptionResponse.MISS_ARGRUMENTS);
        roleService.update(role);
        return Response.ok();
    }

    @RequestMapping(value = "add_admin/{roleId:\\d+}", method = RequestMethod.POST)
    public Response addAdmin(@PathVariable("roleId") int roleId, @RequestBody List<Integer> adminIds) {
        Assert.assertNotNull(adminIds, ExceptionResponse.MISS_ARGRUMENTS);
        roleService.addAdmin(roleId, adminIds);
        return Response.ok();
    }

    @RequestMapping(value = "remove_admin/{roleId:\\d+}", method = RequestMethod.POST)
    public Response removeAdmin(int roleId, List<Integer> adminIds) {
        Assert.assertNotNull(adminIds, ExceptionResponse.MISS_ARGRUMENTS);
        roleService.removeAdmin(roleId, adminIds);
        return Response.ok();
    }

}
