package top.jhechem.user.pojo;


import top.jhechem.core.base.Base;

import java.util.List;

/**
 * 角色
 * Created by wuqiang on 2017/7/23.
 */
public class Role extends Base {

    private Integer id;
    private String name;

    private Integer status;

    private List<Admin> admins;

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

    public List<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(List<Admin> admins) {
        this.admins = admins;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
