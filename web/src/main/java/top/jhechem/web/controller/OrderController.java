package top.jhechem.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.jhechem.web.support.BaseController;
import top.jhechem.web.support.Response;

/**
 * 订单控制器
 * Created by wuqiang on 2017/7/24.
 */
@Controller
@RequestMapping("order")
public class OrderController extends BaseController {

    @RequestMapping(value = "test", method = RequestMethod.GET)
    @ResponseBody
    public Response test() {
        return Response.ok();
    }
}
