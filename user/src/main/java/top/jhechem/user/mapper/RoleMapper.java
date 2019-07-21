package top.jhechem.user.mapper;

import org.apache.ibatis.annotations.Param;
import top.jhechem.user.pojo.Role;

import java.util.List;

/**
 * 角色表操作
 * Created by wuqiang on 2017/7/31.
 */
public interface RoleMapper {

    List<Role> listRole();

    int add(Role role);

    int update(Role role);

    int removeAdmin(int roleId, @Param("adminIds") List<Integer> adminIds);

    int addAdmin(int roleId, @Param("adminIds") List<Integer> adminIds);

    int geRoleIdByName(String name);
}
