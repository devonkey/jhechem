package top.jhechem.user.mapper;

import top.jhechem.user.pojo.FunctionAuth;

import java.util.List;
import java.util.Set;

/**
 * 功能权限mapper
 * Created by wuqiang on 2017/7/23.
 */
public interface  FunctionAuthMapper{

    List<FunctionAuth> list();

    List<Integer> listGroupAuthId(int functionAuthId);

    /**
     * 根据管理员和权限路径，查询授权范围
     * @param path 授权路径
     * @param adminId 管理员id
     * @return 所有角色对应的授权范围
     */
    Set<Integer> getRanges(String path, long adminId);
}
