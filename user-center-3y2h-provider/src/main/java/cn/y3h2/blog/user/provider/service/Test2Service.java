package cn.y3h2.blog.user.provider.service;

import cn.y3h2.blog.user.api.Test2Facade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Test2Service implements Test2Facade {

    @Override
    public String test(String str) {
        return str;
    }
}
