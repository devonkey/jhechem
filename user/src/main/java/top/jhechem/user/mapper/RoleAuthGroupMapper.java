package top.jhechem.user.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色授权组mapper
 * Created by wuqiang on 2017/7/23.
 */
public interface RoleAuthGroupMapper {

    List<Integer> listGroupIdByRoleIds(@Param("roleIds") List<Integer> roleIds);

    int getAuthGroupIdByName(String name);

}
