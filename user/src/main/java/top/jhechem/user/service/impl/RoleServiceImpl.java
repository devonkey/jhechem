package top.jhechem.user.service.impl;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import top.jhechem.user.mapper.RoleMapper;
import top.jhechem.user.pojo.Role;
import top.jhechem.user.service.RoleService;

import javax.annotation.Resource;
import java.util.List;

/**
 * 角色服务实现
 * Created by wuqiang on 2017/7/31.
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService, InitializingBean {

    @Resource
    private RoleMapper mapper;

    private Integer ROLE_ID_OF_TIME_LIMITLESS;

    @Override
    public List<Role> listRole() {
        return mapper.listRole();
    }

    @Override
    public int add(Role role) {
        return mapper.add(role);
    }

    @Override
    public int update(Role role) {
        return mapper.update(role);
    }

    @Override
    public int addAdmin(int roleId, List<Integer> adminIds) {
        return mapper.addAdmin(roleId, adminIds);
    }

    @Override
    public int removeAdmin(int roleId, List<Integer> adminIds) {
        return mapper.removeAdmin(roleId, adminIds);
    }

    @Override
    public int getRoleIdOfTimeLimitLess() {
        return ROLE_ID_OF_TIME_LIMITLESS;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        ROLE_ID_OF_TIME_LIMITLESS = mapper.geRoleIdByName(TIME_LIMITLESS_NAME);
    }
}
