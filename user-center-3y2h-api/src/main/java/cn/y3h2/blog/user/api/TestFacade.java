package cn.y3h2.blog.user.api;

import cn.y3h2.blog.user.api.domain.TestParam;
import cn.y3h2.blog.user.common.dto.test.TestDTO;
import cn.y3h2.blog.user.common.model.Response;

public interface TestFacade {

    public Response<TestDTO> test(TestParam param);

}
