package top.jhechem.user.mapper;

import cn.idongjia.util.MD5Encoder;
import org.junit.Test;
import test.SpringJUnitServiceTest;
import top.jhechem.user.pojo.Admin;

import javax.annotation.Resource;

/**
 * junit
 * Created by wuqiang on 2017/7/23.
 */
public class AdminMapperTest extends SpringJUnitServiceTest{

    @Resource
    private AdminMapper mapper;

    private Admin admin;

    {
        admin = new Admin();
        admin.setId(20000);
        admin.setUsername("小赵");
        admin.setRealName("赵又廷");
        admin.setSalt("1234");
        admin.setPassword(MD5Encoder.encode("123456" + admin.getSalt(), "utf-8"));
    }
    @Test
    public void add() throws Exception {
        mapper.add(admin);
        System.out.println("admin:" + admin);
    }

    @Test
    public void listRoleId() throws Exception {
        System.out.println(mapper.listRoleId(admin.getId()));
    }

    @Test
    public void listRole() throws Exception {
        System.out.println(mapper.listRole(admin.getId()));
    }

}