package top.jhechem.order.service.impl;

import cn.idongjia.common.query.BaseSearch;
import org.springframework.stereotype.Service;
import top.jhechem.order.mapper.OrderMapper;
import top.jhechem.order.pojo.Order;
import top.jhechem.order.pojo.OrderSearch;
import top.jhechem.order.service.OrderService;

import javax.annotation.Resource;
import javax.ws.rs.BeanParam;
import java.util.List;

/**
 * impl
 * <p>
 * Created by wuqiang on 2017/7/20.
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper mapper;

    @Override
    public Order add(Order order) {
        mapper.add(order);
        return order;
    }

    @Override
    public int update(Order order) {
        return mapper.update(order);
    }

    @Override
    public int delete(long bookid) {
        return mapper.delete(bookid);
    }

    @Override
    public Order get(long bookid) {
        return mapper.get(bookid);
    }

    @Override
    public List<Order> list(@BeanParam OrderSearch search) {
        search.setBookname(BaseSearch.likeStr(search.getBookname()));
        search.setYwy(BaseSearch.likeStr(search.getYwy()));
        return mapper.list(search);
    }

    @Override
    public int count(@BeanParam OrderSearch search) {
        return mapper.count(search);
    }
}
