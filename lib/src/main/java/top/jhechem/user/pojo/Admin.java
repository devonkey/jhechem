package top.jhechem.user.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import top.jhechem.core.base.Base;

import java.util.List;

/**
 * 管理员pojo
 * Created by wuqiang on 2017/7/23.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Admin extends Base {

    public static final int STATUS_NORMAL = 1, STATUS_DISABLE = 0;

    private Long id;

    private String username;

    private String mobile;

    private String realName;

    private String salt;

    private String password;

    private String department;

    private Integer status;

    private Long createTime;

    private Long updateTime;

    private List<Integer> authGroups;

    public Admin() {
    }

    public Admin(Long id, Integer status) {
        this.id = id;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public List<Integer> getAuthGroups() {
        return authGroups;
    }

    public void setAuthGroups(List<Integer> authGroups) {
        this.authGroups = authGroups;
    }
}
