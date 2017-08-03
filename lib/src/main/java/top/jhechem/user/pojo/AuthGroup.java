package top.jhechem.user.pojo;


import top.jhechem.core.base.Base;

import java.util.List;

/**
 * 管理员授权组
 * Created by wuqiang on 2017/7/23.
 */
public class AuthGroup extends Base {

    private Integer id;
    private String name;
    private Integer type;
    private List<FunctionAuth> functionAuths;
    private List<MenuAuth> menuAuths;

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public List<FunctionAuth> getFunctionAuths() {
        return functionAuths;
    }

    public void setFunctionAuths(List<FunctionAuth> functionAuths) {
        this.functionAuths = functionAuths;
    }

    public List<MenuAuth> getMenuAuths() {
        return menuAuths;
    }

    public void setMenuAuths(List<MenuAuth> menuAuths) {
        this.menuAuths = menuAuths;
    }
}
