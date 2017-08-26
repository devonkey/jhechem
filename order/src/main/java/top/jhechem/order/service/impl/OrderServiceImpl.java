package top.jhechem.order.service.impl;

import cn.idongjia.log.Log;
import cn.idongjia.log.LogFactory;
import org.springframework.stereotype.Service;
import top.jhechem.core.base.BaseSearch;
import top.jhechem.order.mapper.OrderMapper;
import top.jhechem.order.pojo.Order;
import top.jhechem.order.pojo.OrderSearch;
import top.jhechem.order.pojo.OrderStatistic;
import top.jhechem.order.service.OrderService;

import javax.annotation.Resource;
import javax.ws.rs.BeanParam;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * impl
 * <p>
 * Created by wuqiang on 2017/7/20.
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {

    private static final Log LOGGER = LogFactory.getLog(OrderServiceImpl.class);

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
    public int delete(List<Long> bookids) {
        return mapper.delete(bookids);
    }

    @Override
    public Order get(long bookid) {
        return mapper.get(bookid);
    }

    @Override
    public List<Order> list(@BeanParam OrderSearch search) {
        search.setDefaultOrderBy("bookid desc");
        search.setBookname(BaseSearch.likeStr(search.getBookname()));
        search.setYwy(BaseSearch.likeStr(search.getYwy()));
        search.setEnbookname(BaseSearch.likeStr(search.getEnbookname()));
        search.setGysname(BaseSearch.likeStr(search.getGysname()));
        search.setGyscontact(BaseSearch.likeStr(search.getGyscontact()));
        search.setKeyword(BaseSearch.likeStr(search.getKeyword()));
        return mapper.list(search);
    }

    @Override
    public int count(@BeanParam OrderSearch search) {
        return mapper.count(search);
    }


    private String nextGrain(String grain, SimpleDateFormat dateFormat){
        try {
            long time = dateFormat.parse(grain).getTime();
            long nextTime = time + 24 * 60 * 60 * 1000;
            return dateFormat.format(new Date(nextTime));
        } catch (ParseException e) {
            LOGGER.error(e);
            return null;
        }
    }

    @Override
    public List<OrderStatistic> getOrderStatistic(OrderSearch search) {

        List<OrderStatistic> statistics = mapper.getOrderStatistics(search);
        List<OrderStatistic> res = new ArrayList<>();
        if (statistics == null || statistics.size() == 0) {return res;}
        OrderStatistic statistic0 = statistics.get(0);
        res.add(statistic0);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 1; i < statistics.size(); i++) {
            OrderStatistic statistic = statistics.get(i);
            while (true){
                String nextGrain = nextGrain(statistic0.getGrain(),format);
                if (nextGrain.equals(statistic.getGrain())){
                    res.add(statistic);
                    statistic0 = statistic;
                    break;
                } else {
                    statistic0 = new OrderStatistic(nextGrain);
                    res.add(statistic0);
                }
            }
        }
        return res;
    }


}
