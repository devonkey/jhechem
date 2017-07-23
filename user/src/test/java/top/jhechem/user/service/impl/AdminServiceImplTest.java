package top.jhechem.user.service.impl;

import cn.idongjia.util.MD5Encoder;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import test.SpringJUnitServiceTest;
import top.jhechem.user.pojo.Admin;
import top.jhechem.user.service.AdminService;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * 添加管理员
 * Created by wuqiang on 2017/7/23.
 */
public class AdminServiceImplTest extends SpringJUnitServiceTest{

    @Resource
    private AdminService adminService;

    private Admin admin;

    {
        admin = new Admin();
        admin.setUsername("阿宝");
        admin.setRealName("杨波");
        admin.setSalt("1234");
        admin.setPassword("123456");
    }

    @Test
    @Rollback(false)
    public void add() throws Exception {
        System.out.println(adminService.add(admin));
        admin.setUsername("小赵");
        admin.setRealName("赵又廷");
        System.out.println(adminService.add(admin));

        admin.setUsername("小楼");
        admin.setRealName("楼佳枫");
        System.out.println(adminService.add(admin));

        admin.setUsername("三关");
        admin.setRealName("吴强");
        System.out.println(adminService.add(admin));

        admin.setUsername("空空笑");
        admin.setRealName("任先龙");
        System.out.println(adminService.add(admin));

        admin.setUsername("夏夏");
        admin.setRealName("周贝贝");
        System.out.println(adminService.add(admin));
    }

}