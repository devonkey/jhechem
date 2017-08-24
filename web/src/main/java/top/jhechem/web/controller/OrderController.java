package top.jhechem.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.jhechem.core.ApiException;
import top.jhechem.core.Response;
import top.jhechem.core.base.Pagination;
import top.jhechem.core.constant.ExceptionResponse;
import top.jhechem.core.util.Assert;
import top.jhechem.order.pojo.Order;
import top.jhechem.order.pojo.OrderSearch;
import top.jhechem.order.pojo.OrderStatistic;
import top.jhechem.order.service.OrderService;
import top.jhechem.web.BaseController;
import top.jhechem.web.support.ResponseFilter;

import javax.annotation.Resource;
import java.util.List;

/**
 * 订单控制器
 * Created by wuqiang on 2017/7/24.
 */
@Controller
@RequestMapping("order")
@ResponseBody
public class OrderController extends BaseController {

    private static final int UNLIMITED_ORDER_RANGE = 1;

    @Resource
    private OrderService orderService;
    @Resource
    private ResponseFilter responseFilter;

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public Response test() {
        return Response.ok();
    }

    @RequestMapping(value = "{bookid:\\d+}", method = RequestMethod.GET)
    public Response<Order> get(@PathVariable("bookid") long bookid) {
        Order order = orderService.get(bookid);
        int adminId = getAdminId();
        if (!getRanges(adminId).contains(UNLIMITED_ORDER_RANGE)) {
            order = responseFilter.doFilter(order, adminId);
        }
        return Response.ok(order);
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public Response<Pagination<Order>> list(OrderSearch search) {
        List<Order> orders = orderService.list(search);
        int adminId = getAdminId();
        if (!getRanges(adminId).contains(UNLIMITED_ORDER_RANGE)) {
            orders = responseFilter.doFilter(orders, adminId);
        }
        return Response.paginate(orders, orderService.count(search));
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public Response add(@RequestBody Order order) {
        Assert.assertNotNull(order, ExceptionResponse.MISS_ARGRUMENTS);
        Assert.assertNotNull(order.getAdminId(), ExceptionResponse.MISS_ARGRUMENTS);
        int adminId = getAdminId();
        if (!getRanges(adminId).contains(UNLIMITED_ORDER_RANGE)) {
            if (!order.getAdminId().equals(adminId)) {
                throw new ApiException(ExceptionResponse.UNAUTHORIZED);
            }
        }
        Order res = orderService.add(order);
        return Response.ok(res);
    }

    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public Response update(@RequestBody Order order) {
        Assert.assertNotNull(order, ExceptionResponse.MISS_ARGRUMENTS);
        Assert.assertNotNull(order.getBookid(), ExceptionResponse.MISS_ARGRUMENTS);
        Assert.assertNotNull(order.getAdminId(), ExceptionResponse.MISS_ARGRUMENTS);
        int adminId = getAdminId();
        if (!getRanges(adminId).contains(UNLIMITED_ORDER_RANGE)) {
            if (!order.getAdminId().equals(adminId)) {
                throw new ApiException(ExceptionResponse.UNAUTHORIZED);
            }
        }
        int res = orderService.update(order);
        return Response.ok(res);
    }

    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public Response delete(@RequestBody List<Long> bookids) {
        int res = orderService.delete(bookids);
        return Response.ok(res);
    }

    @RequestMapping(value = "statistic", method = RequestMethod.GET)
    public Response<List<OrderStatistic>> getOrderStatistic(OrderSearch search) {
        Assert.assertNotNull(search.getStart(), ExceptionResponse.MISS_ARGRUMENTS);
        Assert.assertNotNull(search.getEnd(), ExceptionResponse.MISS_ARGRUMENTS);
        return Response.ok(orderService.getOrderStatistic(search));
    }
}
