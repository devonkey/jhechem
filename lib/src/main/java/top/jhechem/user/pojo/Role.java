package top.jhechem.user.pojo;

import cn.idongjia.common.base.Base;

import java.util.List;

/**
 * 角色
 * Created by wuqiang on 2017/7/23.
 */
public class Role extends Base {

    private Integer id;
    private String name;
    private String alias;

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

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public List<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(List<Admin> admins) {
        this.admins = admins;
    }
}
