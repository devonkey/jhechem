package top.jhechem.order.mapper;

import top.jhechem.order.pojo.Order;
import top.jhechem.order.pojo.OrderSearch;

import java.util.List;

/**
 * mapper
 * Created by wuqiang on 2017/7/20.
 */
public interface OrderMapper {

    int add(Order order);

    int update(Order order);

    int delete(long bookid);

    Order get(long bookid);

    List<Order> list(OrderSearch search);

    int count(OrderSearch search);
}
