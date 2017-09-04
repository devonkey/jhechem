package top.jhechem.web.support;

import cn.idongjia.util.Utils;
import org.springframework.stereotype.Component;
import top.jhechem.order.pojo.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * 过滤响应数据
 * Created by wuqiang on 2017/8/12.
 */
@Component
public class ResponseFilter {


    @SuppressWarnings("unchecked")
    public <T> T doFilter(T t, Integer loginAdminId) {

        if (t instanceof Order) {
            return (T) filterOrder((Order) t, loginAdminId);
        } else if (t instanceof List) {
            List list = (List) t;
            if (Utils.isEmpty(list)) {
                return t;
            }
            Object object = list.get(0);
            if (object instanceof Order) {
                List newList = new ArrayList();
                for (Object o : list) {
                    o = filterOrder((Order) o, loginAdminId);
                    newList.add(o);
                }
                return (T) newList;
            }
        }
        return t;
    }


    private Order filterOrder(Order o, Integer adminId) {
        if (adminId != null && adminId.equals(o.getAdminId())) {
            return o;
        }
        Order order = new Order();
        order.setBookid(o.getBookid());
        order.setGysname(o.getGysname());
        order.setGyscontact(o.getGyscontact());
        order.setAdminName(o.getAdminName());
        order.setDate1(o.getDate1());
        return order;
    }

    @SuppressWarnings("unchecked")
    public <T> T doFilterPrice(T t) {
        if (t instanceof List) {
            List list = (List) t;
            List newList = new ArrayList();
            list.forEach(l -> newList.add(doFilterPrice(l)));
            return (T) newList;
        }
        Order order = (Order) t;
        order.setLirun(null);
        order.setZsh(null);
        order.setPrice1(null);
        order.setPrice2(null);
        order.setHuokuan(null);
        return (T) order;
    }

}
