package top.jhechem.user.service.impl;

import org.springframework.beans.factory.InitializingBean;
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
public class AdminFunctionAuthGroupServiceImpl implements AdminFunctionAuthGroupService, InitializingBean {

    @Resource
    private AdminMapper adminMapper;
    @Resource
    private RoleAuthGroupMapper roleAuthGroupMapper;

    private Integer AUTH_GROUP_ID;

    @Override
    public List<Integer> listAdminAuthGroups(int adminId) {
        List<Integer> roleIds = adminMapper.listRoleId(adminId);
        return roleAuthGroupMapper.listGroupIdByRoleIds(roleIds);
    }

    @Override
    public int getAuthGroupIdOfTimeLimitLess() {
        return AUTH_GROUP_ID;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        AUTH_GROUP_ID = roleAuthGroupMapper.getAuthGroupIdByName(TIME_LIMIT_LESS_AUTH_NAME);
    }
}
