package cn.y3h2.blog.user.provider.service;

import cn.y3h2.blog.user.api.TestFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TestService implements TestFacade {

    @Override
    public String test(String str) {
        return str;
    }

}
