package top.jhechem.user.service.impl;

import org.junit.Test;
import test.SpringJUnitServiceTest;
import top.jhechem.user.service.AdminFunctionAuthGroupService;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * junit
 * Created by wuqiang on 2017/7/24.
 */
public class AdminFunctionAuthGroupServiceImplTest extends SpringJUnitServiceTest {
    @Resource
    private AdminFunctionAuthGroupService service;
    @Test
    public void listAdminAuthGroups() throws Exception {
        System.out.println(service.listAdminAuthGroups(20000));
    }

}