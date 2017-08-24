package top.jhechem.order.mapper;

import org.apache.ibatis.annotations.Param;
import top.jhechem.order.pojo.Order;
import top.jhechem.order.pojo.OrderSearch;
import top.jhechem.order.pojo.OrderStatistic;

import java.util.List;

/**
 * mapper
 * Created by wuqiang on 2017/7/20.
 */
public interface OrderMapper {

    int add(Order order);

    int update(Order order);

    int delete(@Param("bookids") List<Long> bookids);

    Order get(long bookid);

    List<Order> list(OrderSearch search);

    int count(OrderSearch search);

    List<OrderStatistic> getOrderStatistics(OrderSearch search);
}
