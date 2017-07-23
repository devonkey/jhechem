package top.jhechem.user.mapper;

import top.jhechem.user.pojo.Admin;

import java.util.List;

/**
 * 管理员mapper
 * Created by wuqiang on 2017/7/23.
 */
public interface AdminMapper {

    int add(Admin admin);

    List<Integer> listRoleId(long id);
}
