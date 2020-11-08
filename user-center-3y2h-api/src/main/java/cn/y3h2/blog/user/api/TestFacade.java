package cn.y3h2.blog.user.api;

import cn.y3h2.blog.user.api.domain.TestParam;
import cn.y3h2.blog.user.common.dto.test.TestDTO;
import cn.y3h2.blog.user.common.model.Response;

/**
* @ClassName TestFacade
* @Author kongming
* @Date 2020/11/8 5:25 下午
* @Description 这里需要描述该service的主要业务
*/
public interface TestFacade {

    /**
     * 这里要有注释，解释这个接口的作用
     * @param param
     * @return
     */
    public Response<TestDTO> test(TestParam param);

}
