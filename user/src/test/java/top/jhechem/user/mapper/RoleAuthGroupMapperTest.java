package top.jhechem.user.mapper;

import com.google.common.collect.Lists;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import test.SpringJUnitServiceTest;

import java.util.List;

public class RoleAuthGroupMapperTest extends SpringJUnitServiceTest {

    @Autowired
    private RoleAuthGroupMapper mapper;

    @Test
    public void listGroupIdByRoleIds() {
        List<Integer> integers = mapper.listGroupIdByRoleIds(Lists.newArrayList(10000, 10007));
        System.out.println(integers);
    }
}