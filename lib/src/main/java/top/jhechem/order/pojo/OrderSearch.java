package top.jhechem.order.pojo;

import lombok.Getter;
import lombok.Setter;
import top.jhechem.core.base.BaseSearch;

import javax.ws.rs.QueryParam;

/**
 * search
 * Created by wuqiang on 2017/7/20.
 */
@Setter
@Getter
public class OrderSearch extends BaseSearch {


    @QueryParam("bookid")
    private Long bookid;
    @QueryParam("bookname")
    private String bookname;
    @QueryParam("ywy")
    private String ywy;

    private Integer adminId;

    private String adminName;

    private String casno;

    private String enbookname;

    private String ordernum;

    private String huokuan;

    private String gysname;

    private String gyscontact;

    private String lirun;

    private String style;

    private String yundan;

    private Boolean isfh;       //是否发货

    private Boolean isdh;       //是否到货

    private Boolean issh;       //是否收汇

}
