package top.jhechem.core.base;

import cn.idongjia.common.base.Base;

import java.util.List;

/**
 * 分页对象封装
 * Created by wuqiang on 2017/7/31.
 */
public class Pagination<T> extends Base {

    private List<T> items;
    private int total;

    public Pagination() {
    }

    public Pagination(List<T> items, int total) {
        this.items = items;
        this.total = total;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
