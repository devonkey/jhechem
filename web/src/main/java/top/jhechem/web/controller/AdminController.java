package top.jhechem.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.jhechem.core.Response;
import top.jhechem.core.base.BaseSearch;
import top.jhechem.core.base.Pagination;
import top.jhechem.core.constant.ExceptionResponse;
import top.jhechem.core.util.Assert;
import top.jhechem.user.pojo.Admin;
import top.jhechem.user.service.AdminService;
import top.jhechem.web.BaseController;

import javax.annotation.Resource;

/**
 * 管理员控制器
 * Created by wuqiang on 2017/7/29.
 */
@Controller
@RequestMapping("admin")
@ResponseBody
public class AdminController extends BaseController {

    @Resource
    private AdminService adminService;

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public Response test() {
        return Response.ok();
    }

    @RequestMapping(value = "{id:\\d+}", method = RequestMethod.GET)
    public Response<Admin> get(@PathVariable("id") long id) {
        return Response.ok(adminService.get(id));
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public Response<Pagination<Admin>> list(BaseSearch search) {
        return Response.paginate(adminService.list(search), adminService.count(search));
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public Response add(@RequestBody Admin admin) {
        Assert.assertNotNull(admin, ExceptionResponse.MISS_ARGRUMENTS);
        Assert.assertNotNull(admin.getUsername(), ExceptionResponse.MISS_ARGRUMENTS);
        Assert.assertNotNull(admin.getRealName(), ExceptionResponse.MISS_ARGRUMENTS);
        Assert.assertNotNull(admin.getPassword(), ExceptionResponse.MISS_ARGRUMENTS);
        return Response.ok(adminService.add(admin));
    }

    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public Response update(@RequestBody Admin admin) {
        Assert.assertNotNull(admin, ExceptionResponse.MISS_ARGRUMENTS);
        Assert.assertNotNull(admin.getId(), ExceptionResponse.MISS_ARGRUMENTS);
        return Response.ok(adminService.update(admin));
    }
}
