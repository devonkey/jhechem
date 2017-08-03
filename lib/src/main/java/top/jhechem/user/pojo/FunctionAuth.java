package top.jhechem.user.pojo;


import top.jhechem.core.base.Base;

import java.util.List;

/**
 * 功能权限
 * Created by wuqiang on 2017/7/23.
 */
public class FunctionAuth extends Base {

    private Integer id;
    private String name;
    private String url;

    private List<Integer> authGroups;   //拥有该权限的权限组id

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Integer> getAuthGroups() {
        return authGroups;
    }

    public void setAuthGroups(List<Integer> authGroups) {
        this.authGroups = authGroups;
    }
}
