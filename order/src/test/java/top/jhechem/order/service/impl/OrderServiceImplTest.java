package top.jhechem.order.service.impl;

import org.junit.Test;
import test.SpringJUnitServiceTest;
import top.jhechem.core.util.DateUtil;
import top.jhechem.order.pojo.Order;
import top.jhechem.order.pojo.OrderSearch;
import top.jhechem.order.service.OrderService;

import javax.annotation.Resource;

/**
 * junit
 * Created by wuqiang on 2017/8/26.
 */
public class OrderServiceImplTest extends SpringJUnitServiceTest {

    @Resource
    private OrderService orderService;

    @Test
    public void getOrderStatistic() throws Exception {
        OrderSearch search = new OrderSearch();
        search.setStart(1493716911L);
        search.setEnd(1503716911L);
        System.out.println(orderService.getOrderStatistic(search));
    }

    @Test
    public void add() {
        Order order = new Order();
        order.setIsjs(true);
        order.setDate1(DateUtil.getCurrentSecond());
        order.setAdminId(999);
        order.setIsfh(false);
        System.out.println(orderService.add(order));
    }

}