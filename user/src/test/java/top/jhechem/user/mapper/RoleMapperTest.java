package top.jhechem.user.mapper;

import org.junit.Test;
import test.SpringJUnitServiceTest;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * junit
 * Created by wuqiang on 2017/8/12.
 */
public class RoleMapperTest extends SpringJUnitServiceTest{

    @Resource
    RoleMapper mapper;
    @Test
    public void listRole() throws Exception {
        System.out.println(mapper.listRole());
    }

}