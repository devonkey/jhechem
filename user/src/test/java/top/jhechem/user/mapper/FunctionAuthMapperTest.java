package top.jhechem.user.mapper;

import org.junit.Test;
import test.SpringJUnitServiceTest;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * junit
 * Created by wuqiang on 2017/8/12.
 */
public class FunctionAuthMapperTest extends SpringJUnitServiceTest{

    @Resource
    private FunctionAuthMapper mapper;

    @Test
    public void list() throws Exception {

    }

    @Test
    public void listGroupAuthId() throws Exception {

    }

    @Test
    public void getRanges() throws Exception {
        System.out.println(mapper.getRanges("/order/list",10000));
    }

}