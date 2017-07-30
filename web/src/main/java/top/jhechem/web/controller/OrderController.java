package top.jhechem.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.jhechem.core.Response;
import top.jhechem.order.pojo.Order;
import top.jhechem.order.pojo.OrderSearch;
import top.jhechem.order.service.OrderService;
import top.jhechem.web.BaseController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 订单控制器
 * Created by wuqiang on 2017/7/24.
 */
@Controller
@RequestMapping("order")
public class OrderController extends BaseController {

    @Resource
    private OrderService orderService;

    @RequestMapping(value = "test", method = RequestMethod.GET)
    @ResponseBody
    public Response test() {
        return Response.ok();
    }

    @RequestMapping(value = "{bookid:\\d+}", method = RequestMethod.GET)
    @ResponseBody
    public Response<Order> get(@PathVariable("bookid") long bookid) {
        return Response.ok(orderService.get(bookid));
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseBody
    public Response<List<Order>> list(OrderSearch search) {

        return Response.ok(orderService.list(search));
    }
}
