package top.jhechem.user.service.impl;

import cn.idongjia.common.query.BaseSearch;
import cn.idongjia.util.MD5Encoder;
import org.springframework.stereotype.Service;
import top.jhechem.user.mapper.AdminMapper;
import top.jhechem.user.pojo.Admin;
import top.jhechem.user.service.AdminService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * 管理员服务
 * Created by wuqiang on 2017/7/23.
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {

    private static final String DEFAULT_SALT = "JHHG";
    @Resource
    private AdminMapper mapper;

    @Override
    public Admin add(Admin admin) {
        Objects.requireNonNull(admin);

        Objects.requireNonNull(admin.getUsername());

        //TODO 检验用户名唯一性

        Objects.requireNonNull(admin.getPassword());
        if (admin.getSalt() == null) {
            admin.setSalt(DEFAULT_SALT);
        }
        String password = MD5Encoder.encode(admin.getPassword() + admin.getSalt(), DEFAULT_PASSWORD_CHARSET);
        admin.setPassword(password);
        mapper.add(admin);
        return admin;
    }

    @Override
    public int update(Admin admin) {
        return 0;
    }

    @Override
    public int delete(long id) {
        return 0;
    }

    @Override
    public Admin getByUsername(String username) {
        return mapper.getByUsername(username);
    }

    @Override
    public Admin get(long id) {
        return mapper.get(id);
    }

    @Override
    public List<Admin> list(BaseSearch search) {
        return null;
    }
}
