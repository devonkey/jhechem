package top.jhechem.user.service.impl;

import org.springframework.stereotype.Service;
import top.jhechem.user.mapper.AdminMapper;
import top.jhechem.user.mapper.RoleAuthGroupMapper;
import top.jhechem.user.service.AdminFunctionAuthGroupService;

import javax.annotation.Resource;
import java.util.List;

/**
 * impl
 * Created by wuqiang on 2017/7/23.
 */
@Service("adminFunctionAuthGroupService")
public class AdminFunctionAuthGroupServiceImpl implements AdminFunctionAuthGroupService {

    @Resource
    private AdminMapper adminMapper;
    @Resource
    private RoleAuthGroupMapper roleAuthGroupMapper;

    @Override
    public List<Integer> listAdminAuthGroups(long adminId) {
        List<Integer> roleIds = adminMapper.listRoleId(adminId);
        return roleAuthGroupMapper.listGroupIdByRoleIds(roleIds);
    }
}
