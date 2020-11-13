package cn.y3h2.blog.user.api;

import cn.y3h2.blog.user.api.domain.req.FindUserCondition;
import cn.y3h2.blog.user.api.domain.req.FindUserPart;
import cn.y3h2.blog.user.common.dto.UserInfoDTO;
import cn.y3h2.blog.user.common.model.Response;

import java.util.List;

/**
 * @ClassName UserFacade
 * @Author kongming
 * @Date 2020/11/8 5:25 下午
 * @Description 用户信息facade接口定义
 */
public interface UserFacade {

    /**
     * 查询用户信息
     * @param condition 查询条件
     * @param part 结果所需的信息部件
     * @return
     */
    Response<List<UserInfoDTO>> loadUser(FindUserCondition condition, FindUserPart part);

}
