package top.jhechem.user.mapper;

import org.apache.ibatis.annotations.Param;
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

    int deleteAdminRoles(int id);

    int addRoles(int id, @Param("roles") List<Role> roles);

    Admin getByUsername(String username);

    Admin get(int id);

    List<Integer> listRoleId(int id);

    List<Role> listRole(int id);

    List<Admin> list(BaseSearch search);

    int count(BaseSearch search);
}
