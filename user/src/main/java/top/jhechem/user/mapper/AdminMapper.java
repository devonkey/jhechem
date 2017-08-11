package top.jhechem.user.mapper;

import top.jhechem.core.base.BaseSearch;
import top.jhechem.user.pojo.Admin;
import top.jhechem.user.pojo.Role;

import java.util.List;

/**
 * 管理员mapper
 * Created by wuqiang on 2017/7/23.
 */
public interface AdminMapper {

    int add(Admin admin);

    int update(Admin admin);

    int deleteAdminRoles(long id);

    Admin getByUsername(String username);

    Admin get(long id);

    List<Integer> listRoleId(long id);

    List<Role> listRole(long id);

    List<Admin> list(BaseSearch search);

    int count(BaseSearch search);
}
