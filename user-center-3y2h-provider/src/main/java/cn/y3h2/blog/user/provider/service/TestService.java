package cn.y3h2.blog.user.provider.service;

import cn.y3h2.blog.user.api.TestFacade;
import cn.y3h2.blog.user.api.domain.TestParam;
import cn.y3h2.blog.user.common.dto.test.TestDTO;
import cn.y3h2.blog.user.common.model.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TestService implements TestFacade {

    @Override
    public Response<TestDTO> test(TestParam param) {
        TestDTO testDTO = new TestDTO();
        testDTO.setStr(param.getStr());
        return Response.ok(testDTO);
    }

}
