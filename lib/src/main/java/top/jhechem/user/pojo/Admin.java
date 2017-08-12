package top.jhechem.user.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import top.jhechem.core.base.Base;

import java.util.List;

/**
 * 管理员pojo
 * Created by wuqiang on 2017/7/23.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Setter
@Getter
public class Admin extends Base {

    public static final int STATUS_NORMAL = 1, STATUS_DISABLE = 0;

    private Integer id;

    private String username;

    private String mobile;

    private String realName;

    private String salt;

    private String password;

    private String department;

    private Integer status;

    private Long createTime;

    private Long updateTime;

    private List<Role> roles;

    private List<Integer> authGroups;

    public Admin() {
    }

    public Admin(Integer id, Integer status) {
        this.id = id;
        this.status = status;
    }

}
