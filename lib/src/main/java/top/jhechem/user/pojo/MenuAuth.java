package top.jhechem.user.pojo;


import top.jhechem.core.base.Base;

/**
 * 目录权限
 * Created by wuqiang on 2017/7/23.
 */
public class MenuAuth extends Base {

    private Integer id;
    private String name;
    private String url;
    private Integer parentId;

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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}
