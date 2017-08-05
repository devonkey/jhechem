package top.jhechem.order.mapper;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
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
//        get();
//        order.setBookname("大箩筐发龙卷风接口来等级分级");
        Order order = new Gson().fromJson("{\"bookid\":15833,\"casno\":\"24424-99-5\"," +
                "\"bookname\":\"二碳酸二叔丁酯\",\"enbookname\":\"Di-tert-butyl dicarbonate (DIBOC)\",\"ordernum\":\"36184/Phion No. 23226602\",\"fapiaonum\":\"2012031203123\",\"krname\":\"1076\",\"date1\":1499184000,\"date2\":\"5~8天\",\"cjsl\":\"35kg\",\"style\":\"0\",\"price1\":\"2800\",\"price2\":\"USD36.2/kg\",\"ysfs\":\"顺丰快递次日达\",\"ysfy\":\"20\",\"hl\":\"0.75\",\"zsh\":\"1267\",\"huokuan\":\"2800\",\"lirun\":\"3300\",\"yundan\":\"SF123123123\",\"date3\":\"2017-08-29\",\"cpgg\":100,\"baozhuang\":\"测试\",\"isyp\":\"0\",\"gyscontact\":\"15968810223\",\"gysname\":\"昌邑\n" +
                "新星科技\",\"iskucun\":\"0\",\"kucun\":\"10\",\"fj1\":\"\",\"fj2\":\"\"," +
                "\"ywy\":\"郑\",\"isjs\":true,\"isdh\":true,\"isfh\":true,\"isfp\":true," +
                "\"isfxbg\":true,\"zhfrom\":\"介绍\",\"ists\":true,\"date4\":\"20\",\"issh\":true," +
                "\"iskp\":true,\"isgcfp\":true,\"mylx\":0,\"ishx\":true,\"date5\":30," +
                "\"iswcts\":true,\"ishkqf\":true,\"qgchk\":\"20.3\",\"krqk\":\"1\",\"isok\":true," +
                "\"krkpdz\":\"1\",\"krfhdz\":\"1\",\"content\":\"7月5日已付款.\"}", Order.class);
        System.out.println(order);
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
        search.setDefaultOrderBy("bookid DESC");
        System.out.println(mapper.list(search));
    }


    @Test
    public void test() throws Exception {
        update();
        list();
    }

}