package top.jhechem.order.pojo;

import cn.idongjia.common.query.BaseSearch;
import lombok.Getter;
import lombok.Setter;

import javax.ws.rs.QueryParam;

/**
 * search
 * Created by wuqiang on 2017/7/20.
 */
@Getter
@Setter
public class OrderSearch extends BaseSearch {

    @QueryParam("bookid")
    private Long bookid;
    @QueryParam("bookname")
    private String bookname;
    @QueryParam("ywy")
    private String ywy;
}
