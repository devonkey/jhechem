package top.jhechem.user.service;

import top.jhechem.user.pojo.Role;

import java.util.List;

/**
 * 角色服务
 * Created by wuqiang on 2017/7/23.
 */
public interface RoleService {

    int add(Role role);

    int update(Role role);

    int addAdmin(int roleId, List<Long> adminIds);

    int removeAdmin(int roleId, List<Long> adminIds);

}
