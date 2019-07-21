package top.jhechem.user.service;

import top.jhechem.user.pojo.Role;

import java.util.List;

/**
 * 角色服务
 * Created by wuqiang on 2017/7/23.
 */
public interface RoleService {

    String TIME_LIMITLESS_NAME = "时间无限";

    List<Role> listRole();

    int add(Role role);

    int update(Role role);

    int addAdmin(int roleId, List<Integer> adminIds);

    int removeAdmin(int roleId, List<Integer> adminIds);

    int getRoleIdOfTimeLimitLess();

}
