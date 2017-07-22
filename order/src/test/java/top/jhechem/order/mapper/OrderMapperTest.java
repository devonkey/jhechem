package top.jhechem.order.mapper;

import org.junit.Test;
import test.SpringJUnitServiceTest;
import top.jhechem.order.pojo.Order;
import top.jhechem.order.pojo.OrderSearch;

import javax.annotation.Resource;

/**
 * junit
 * Created by wuqiang on 2017/7/20.
 */
public class OrderMapperTest extends SpringJUnitServiceTest {

    @Resource
    private OrderMapper mapper;
    private Order order;

    {
        order = new Order();
        order.setBaozhuang("dkjflskjfl");
    }
    @Test
    public void add() throws Exception {
        mapper.add(order);
        System.out.println("order:" + order);
    }

    @Test
    public void update() throws Exception {
        get();
        order.setBookname("大箩筐发龙卷风接口来等级分级");
        System.out.println(mapper.update(order));
    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void get() throws Exception {
        order = mapper.get(4754L);
        System.out.println(order);
    }

    @Test
    public void list() throws Exception {
        OrderSearch search = new OrderSearch();
        search.setLimit(5);
        System.out.println(mapper.list(search));
    }


    @Test
    public void test() throws Exception {
        update();
        list();
    }

}