package top.jhechem.order.service;

import org.apache.dubbo.rpc.protocol.rest.support.ContentType;
import top.jhechem.order.pojo.Order;
import top.jhechem.order.pojo.OrderSearch;
import top.jhechem.order.pojo.OrderStatistic;

import javax.ws.rs.*;
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
