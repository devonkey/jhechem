package top.jhechem.user.service.impl;

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
public class RoleServiceImpl implements RoleService{

    @Resource
    private RoleMapper mapper;

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

}
