package top.jhechem.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.jhechem.user.pojo.Admin;
import top.jhechem.user.service.AdminService;
import top.jhechem.web.BaseController;
import top.jhechem.core.Response;

import javax.annotation.Resource;

/**
 * 管理员控制器
 * Created by wuqiang on 2017/7/29.
 */
@Controller
@RequestMapping("admin")
public class AdminController extends BaseController {

    @Resource
    private AdminService adminService;

    @RequestMapping(value = "test", method = RequestMethod.GET)
    @ResponseBody
    public Response test() {
        return Response.ok();
    }

    @RequestMapping(value = "{id:\\d+}", method = RequestMethod.GET)
    @ResponseBody
    public Response<Admin> get(@PathVariable("id") long id) {
        return Response.ok(adminService.get(id));
    }
}
