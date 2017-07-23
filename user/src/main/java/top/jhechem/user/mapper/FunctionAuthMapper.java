package top.jhechem.user.mapper;

import top.jhechem.user.pojo.FunctionAuth;

import java.util.List;

/**
 * 功能权限mapper
 * Created by wuqiang on 2017/7/23.
 */
public interface  FunctionAuthMapper{

    List<FunctionAuth> list();

    List<Integer> listGroupAuthId(int functionAuthId);
}
