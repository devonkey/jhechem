package top.jhechem.user.service.impl;

import cn.devonkey.log.Log;
import cn.devonkey.log.LogFactory;
import cn.devonkey.util.MD5Encoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.jhechem.core.base.BaseSearch;
import top.jhechem.core.util.Assert;
import top.jhechem.core.util.Utils;
import top.jhechem.user.mapper.AdminMapper;
import top.jhechem.user.pojo.Admin;
import top.jhechem.user.service.AdminService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

import static top.jhechem.core.constant.ExceptionResponse.MISS_ARGRUMENTS;

/**
 * 管理员服务
 * Created by wuqiang on 2017/7/23.
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {

    private static final Log LOGGER = LogFactory.getLog(AdminServiceImpl.class);
    private static final String DEFAULT_SALT = "JHHG";
    @Resource
    private AdminMapper mapper;

    @Override
    @Transactional
    public Admin add(Admin admin) {
        Assert.assertNotNull(admin, MISS_ARGRUMENTS);
        Assert.assertNotNull(admin.getUsername(), MISS_ARGRUMENTS);
        Assert.assertNotNull(admin.getRoles(), MISS_ARGRUMENTS);
        //TODO 检验用户名唯一性

        Objects.requireNonNull(admin.getPassword());
        encodePassword(admin);
        //添加管理员
        mapper.add(admin);
        //添加角色
        mapper.addRoles(admin.getId(), admin.getRoles());
        return admin;
    }

    @Override
    @Transactional
    public int update(Admin admin) {
        Assert.assertNotNull(admin, MISS_ARGRUMENTS);
        Assert.assertNotNull(admin.getId(), MISS_ARGRUMENTS);
        encodePassword(admin);
        int res = mapper.update(admin);
        if (!Utils.isEmpty(admin.getRoles())) {
            //删除原有角色
            mapper.deleteAdminRoles(admin.getId());
            //新增角色
            mapper.addRoles(admin.getId(), admin.getRoles());
        }
        return res;
    }

    @Override
    public int delete(int id) {
        LOGGER.info("用户:{} 拥有的角色:{} 删除中...", id, mapper.listRoleId(id));
        mapper.deleteAdminRoles(id);
        Admin admin = new Admin(id, Admin.STATUS_DISABLE);
        return mapper.update(admin);
    }

    @Override
    public Admin getByUsername(String username) {
        Admin admin = mapper.getByUsername(username);
        admin.setRoles(mapper.listRole(admin.getId()));
        return admin;
    }

    @Override
    public Admin get(int id) {
        Admin admin = mapper.get(id);
        admin.setRoles(mapper.listRole(id));
        return admin;
    }

    @Override
    public List<Admin> list(BaseSearch search) {
        search.setKeyword(BaseSearch.likeStr(search.getKeyword()));
        List<Admin> admins = mapper.list(search);
        admins.forEach(admin -> admin.setRoles(mapper.listRole(admin.getId())));
        return admins;
    }

    @Override
    public int count(BaseSearch search) {
        return mapper.count(search);
    }

    private void encodePassword(Admin admin) {
        if (admin.getPassword() == null) return;
        if (admin.getSalt() == null) admin.setSalt(DEFAULT_SALT);
        String password = MD5Encoder.encode(
                admin.getPassword() + admin.getSalt(), DEFAULT_PASSWORD_CHARSET);
        admin.setPassword(password);
    }
}
