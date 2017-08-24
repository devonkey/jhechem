package top.jhechem.order.service;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import top.jhechem.order.pojo.Order;
import top.jhechem.order.pojo.OrderSearch;
import top.jhechem.order.pojo.OrderStatistic;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * orderService
 * Created by wuqiang on 2017/7/20.
 */
@Produces({ContentType.APPLICATION_JSON_UTF_8})
@Path("order")
public interface OrderService {

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    Order add(Order order);

    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    int update(Order order);

    @DELETE
    int delete(@QueryParam("bookid") List<Long> bookids);

    @GET
    @Path("{bookid:\\d+}")
    Order get(@PathParam("bookid") long bookid);

    @GET
    @Path("list")
    List<Order> list(@BeanParam OrderSearch search);

    @GET
    @Path("count")
    int count(@BeanParam OrderSearch search);

    List<OrderStatistic> getOrderStatistic(OrderSearch search);

}
