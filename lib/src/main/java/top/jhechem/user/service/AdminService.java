package top.jhechem.user.service;

import cn.idongjia.common.query.BaseSearch;
import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import top.jhechem.user.pojo.Admin;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * 管理员
 * Created by wuqiang on 2017/7/23.
 */
@Produces({ContentType.APPLICATION_JSON_UTF_8})
@Path("admin")
public interface AdminService {

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    Admin add(Admin admin);

    int update(Admin admin);

    int delete(long id);

    List<Admin> list(BaseSearch search);
}
