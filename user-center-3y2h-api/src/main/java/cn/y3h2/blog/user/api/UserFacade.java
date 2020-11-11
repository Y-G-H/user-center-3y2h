package cn.y3h2.blog.user.api;

import cn.y3h2.blog.user.api.domain.req.FindUserCondition;
import cn.y3h2.blog.user.api.domain.rsp.UserInfoDTO;
import cn.y3h2.blog.user.common.model.Response;

import java.util.List;

/**
 * @ClassName UserFacade
 * @Author kongming
 * @Date 2020/11/8 5:25 下午
 * @Description 用户信息facade接口定义
 */
public interface UserFacade {

    Response<List<UserInfoDTO>> loadUser(FindUserCondition condition);

}
