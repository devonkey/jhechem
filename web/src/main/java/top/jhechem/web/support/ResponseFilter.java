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
        o.setCjsl(null);
        o.setZsh(null);
        o.setLirun(null);
        o.setHuokuan(null);
        return o;
    }

    @SuppressWarnings("unchecked")
    public <T> T doFilterPrice(T t, int adminId) {
        if (t instanceof List) {
            List list = (List) t;
            List newList = new ArrayList();
            list.forEach(l -> newList.add(doFilterPrice(l, adminId)));
            return (T) newList;
        }
        Order order = (Order) t;
        if (adminId != order.getAdminId()) {
            order.setLirun(null);
            order.setZsh(null);
            order.setPrice1(null);
            order.setPrice2(null);
            order.setHuokuan(null);
        }
        return (T) order;
    }

    public <T> T doFilterFinacial(T t, int adminId) {
        if (t instanceof List) {
            List list = (List) t;
            List newList = new ArrayList();
            list.forEach(l -> newList.add(doFilterFinacial(l, adminId)));
            return (T) newList;
        }
        Order order = (Order) t;
        Order res = new Order();
        if (adminId != order.getAdminId()) {
            res.setBookid(order.getBookid());
            res.setCasno(order.getCasno());
            res.setOrdernum(order.getOrdernum());
            res.setZsh(order.getZsh());
            res.setBookname(order.getBookname());
            res.setEnbookname(order.getEnbookname());
            res.setAdminName(order.getAdminName());
            res.setAdminId(order.getAdminId());
            res.setHuokuan(order.getHuokuan());
            res.setGyscontact(order.getGyscontact());
            res.setGysname(order.getGysname());
            res.setIsdh(order.getIsdh());
            res.setIsfh(order.getIsfh());
            res.setIsjs(order.getIsjs());
            res.setIssh(order.getIssh());
            res.setIssh(order.getIssh());
            res.setDate1(order.getDate1());
            res.setDate2(order.getDate2());
            res.setContent(order.getContent());
            res.setCjsl(order.getCjsl());
        }
        return (T) res;
    }

    public <T> T doFilterHumanResources(T t, int adminId) {
        if (t instanceof List) {
            List list = (List) t;
            List newList = new ArrayList();
            list.forEach(l -> newList.add(doFilterHumanResources(l, adminId)));
            return (T) newList;
        }
        Order order = (Order) t;
        if (adminId != order.getAdminId()) {
            order.setZsh(null);
            order.setLirun(null);
        }
        return (T) order;
    }

}
