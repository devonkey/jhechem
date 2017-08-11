package top.jhechem.user.pojo;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import top.jhechem.core.base.Base;

import java.util.List;

/**
 * 角色
 * Created by wuqiang on 2017/7/23.
 */
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Role extends Base {

    private Integer id;
    private String name;
    private String alias;

    private Integer status;

    private List<Admin> admins;

}
