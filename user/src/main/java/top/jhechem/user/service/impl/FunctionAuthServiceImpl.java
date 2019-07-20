package top.jhechem.user.service.impl;

import org.springframework.stereotype.Service;
import top.jhechem.user.mapper.FunctionAuthMapper;
import top.jhechem.user.pojo.FunctionAuth;
import top.jhechem.user.service.FunctionAuthService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * impl
 * Created by wuqiang on 2017/7/23.
 */
@Service("functionAuthService")
public class FunctionAuthServiceImpl implements FunctionAuthService {

    @Resource
    private FunctionAuthMapper mapper;

    @Override
    public List<FunctionAuth> listFunctionAuth() {
        List<FunctionAuth> auths = mapper.list();
        auths.forEach(auth -> auth.setAuthGroups(mapper.listGroupAuthId(auth.getId())));
        return auths;
    }

    @Override
    public Set<Integer> getRanges(String path, int adminId) {
        return mapper.getRanges(path, adminId);
    }
}
