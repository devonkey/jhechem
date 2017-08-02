package top.jhechem.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.jhechem.core.Response;
import top.jhechem.core.base.Pagination;
import top.jhechem.core.constant.ExceptionResponse;
import top.jhechem.core.util.Assert;
import top.jhechem.order.pojo.Order;
import top.jhechem.order.pojo.OrderSearch;
import top.jhechem.order.service.OrderService;
import top.jhechem.web.BaseController;

import javax.annotation.Resource;

/**
 * 订单控制器
 * Created by wuqiang on 2017/7/24.
 */
@Controller
@RequestMapping("order")
@ResponseBody
public class OrderController extends BaseController {

    @Resource
    private OrderService orderService;

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public Response test() {
        return Response.ok();
    }

    @RequestMapping(value = "{bookid:\\d+}", method = RequestMethod.GET)
    public Response<Order> get(@PathVariable("bookid") long bookid) {
        return Response.ok(orderService.get(bookid));
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public Response<Pagination<Order>> list(OrderSearch search) {

        return Response.paginate(orderService.list(search), orderService.count(search));
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public Response add(Order order) {
        Assert.assertNotNull(order, ExceptionResponse.MISS_ARGRUMENTS);
        Order res = orderService.add(order);
        return Response.ok(res);
    }

    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public Response update(Order order) {
        Assert.assertNotNull(order, ExceptionResponse.MISS_ARGRUMENTS);
        Assert.assertNotNull(order.getBookid(), ExceptionResponse.MISS_ARGRUMENTS);
        int res = orderService.update(order);
        return Response.ok(res);
    }

    @RequestMapping(value = "delete/{bookid:\\d+}", method = RequestMethod.DELETE)
    public Response delete(@PathVariable("bookid") long bookid) {
        int res = orderService.delete(bookid);
        return Response.ok(res);
    }
}
