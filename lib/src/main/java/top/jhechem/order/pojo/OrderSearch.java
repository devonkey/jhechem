package top.jhechem.order.pojo;

import cn.idongjia.common.query.BaseSearch;
import lombok.Getter;
import lombok.Setter;

import javax.ws.rs.QueryParam;

/**
 * search
 * Created by wuqiang on 2017/7/20.
 */
public class OrderSearch extends BaseSearch {

    @QueryParam("bookid")
    private Long bookid;
    @QueryParam("bookname")
    private String bookname;
    @QueryParam("ywy")
    private String ywy;

    public Long getBookid() {
        return bookid;
    }

    public void setBookid(Long bookid) {
        this.bookid = bookid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getYwy() {
        return ywy;
    }

    public void setYwy(String ywy) {
        this.ywy = ywy;
    }
}
