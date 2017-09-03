package top.jhechem.order.service.impl;

import cn.idongjia.log.Log;
import cn.idongjia.log.LogFactory;
import cn.idongjia.util.Utils;
import org.springframework.stereotype.Service;
import top.jhechem.core.base.BaseSearch;
import top.jhechem.core.constant.Const;
import top.jhechem.order.mapper.OrderMapper;
import top.jhechem.order.pojo.Order;
import top.jhechem.order.pojo.OrderSearch;
import top.jhechem.order.pojo.OrderStatistic;
import top.jhechem.order.service.OrderService;

import javax.annotation.Resource;
import javax.ws.rs.BeanParam;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static top.jhechem.core.constant.Const.NUMBER_SECOND_OF_DAY;

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
        if (order.getDate1() == null) {
            order.setDate1(Utils.getCurrentSecond());
        }
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
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //日期取当天凌晨
        formatDate(search,format);

        search.setDefaultOrderBy("bookid desc");
        plentifulOrderSearch(search);
        return mapper.list(search);
    }

    @Override
    public int count(@BeanParam OrderSearch search) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //日期取当天凌晨
        formatDate(search,format);

        plentifulOrderSearch(search);
        return mapper.count(search);
    }


    private String nextGrain(String grain, DateFormat dateFormat) {
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

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //日期取当天凌晨
        formatDate(search,format);

        plentifulOrderSearch(search);
        List<OrderStatistic> statistics = mapper.getOrderStatistics(search);
        List<OrderStatistic> res = new ArrayList<>();
        if (statistics == null || statistics.size() == 0) {
            return res;
        }
        OrderStatistic statistic0 = statistics.get(0);
        res.add(statistic0);
        for (int i = 1; i < statistics.size(); i++) {
            OrderStatistic statistic = statistics.get(i);
            while (true) {
                String nextGrain = nextGrain(statistic0.getGrain(), format);
                if (nextGrain.equals(statistic.getGrain())) {
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


    private void plentifulOrderSearch(OrderSearch search) {
        if(Utils.isEmpty(search.getKrname())){
            search.setKrname(null);
        }
        search.setBookname(BaseSearch.likeStr(search.getBookname()));
        search.setYwy(BaseSearch.likeStr(search.getYwy()));
        search.setEnbookname(BaseSearch.likeStr(search.getEnbookname()));
        search.setGysname(BaseSearch.likeStr(search.getGysname()));
        search.setGyscontact(BaseSearch.likeStr(search.getGyscontact()));
        search.setKeyword(BaseSearch.likeStr(search.getKeyword()));
    }

    private void formatDate(OrderSearch search, DateFormat format){
        try {
            if (search.getStart() != null) {
                String start = format.format(new Date(search.getStart() * Const.NUMBER_THOUSAND));
                search.setStart(format.parse(start).getTime() / Const.NUMBER_THOUSAND);
            }

            if (search.getEnd() != null) {
                String end = format.format(new Date(search.getEnd() * Const.NUMBER_THOUSAND));
                search.setEnd(format.parse(end).getTime() / Const.NUMBER_THOUSAND + NUMBER_SECOND_OF_DAY);
            }
        } catch (ParseException e) {
            LOGGER.error(e);
        }
    }

}
