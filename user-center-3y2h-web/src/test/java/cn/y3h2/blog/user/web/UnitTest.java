package cn.y3h2.blog.user.web;

import cn.y3h2.blog.user.api.domain.req.FindUserCondition;
import cn.y3h2.blog.user.core.domain.UsrUserDO;
import cn.y3h2.blog.user.core.manager.UsrUserManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DubboStarter.class)
public class UnitTest {

    @Autowired
    private UsrUserManager usrUserManager;

    @Test
    public void test() {

    }

}
