package top.jhechem.order.pojo;

import cn.idongjia.common.base.Base;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

/**
 * 订单
 * Created by wuqiang on 2017/7/20.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class Order extends Base {

    private Long bookid;
    private Integer paixu;
    private String casno;
    private String bookname;
    private String enbookname;
    private String ordernum;
    private String fapiaonum;
    private String krname;
    private Long date1;
    private String date2;
    private String cjsl;
    private String style;
    private String price1;
    private String price2;
    private String ysfs;
    private String ysfy;
    private String hl;
    private String zsh;
    private String huokuan;
    private String lirun;
    private String yundan;
    private String date3;
    private Integer cpgg;
    private String baozhuang;
    private String isyp;
    private String gyscontact;
    private String gysname;
    private String iskucun;
    private String kucun;
    private String fj1;
    private String fj2;
    private String ywy;
    private Boolean isjs;
    private Boolean isdh;
    private Boolean isfh;
    private Boolean isfp;
    private Boolean isfxbg;
    private String zhfrom;
    private Boolean ists;
    private String date4;
    private Boolean issh;
    private Boolean iskp;
    private Boolean isgcfp;
    private Integer mylx;
    private Boolean ishx;
    private Long date5;
    private Boolean iswcts;
    private Boolean ishkqf;
    private String qgchk;
    private String krqk;
    private Boolean isok;
    private String krkpdz;
    private String krfhdz;
    private String content;

}
