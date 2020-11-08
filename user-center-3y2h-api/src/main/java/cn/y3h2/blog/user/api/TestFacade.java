package cn.y3h2.blog.user.api;

import cn.y3h2.blog.user.api.domain.TestParam;
import cn.y3h2.blog.user.common.dto.test.TestDTO;
import cn.y3h2.blog.user.common.model.Response;

public interface TestFacade {

    /**
     * 这里要有注释，解释这个接口的作用
     * @param param
     * @return
     */
    public Response<TestDTO> test(TestParam param);

}
