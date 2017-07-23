package top.jhechem.user.service.impl;

import org.junit.Test;
import test.SpringJUnitServiceTest;
import top.jhechem.user.service.FunctionAuthService;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * junit
 * Created by wuqiang on 2017/7/24.
 */
public class FunctionAuthServiceImplTest extends SpringJUnitServiceTest {

    @Resource
    private FunctionAuthService service;
    @Test
    public void listFunctionAuth() throws Exception {
        System.out.println(service.listFunctionAuth());
    }

}