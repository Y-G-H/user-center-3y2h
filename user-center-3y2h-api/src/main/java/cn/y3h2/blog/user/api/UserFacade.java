package cn.y3h2.blog.user.api;

import cn.y3h2.blog.user.api.domain.req.FindUserCondition;
import cn.y3h2.blog.user.api.domain.req.FindUserPart;
import cn.y3h2.blog.user.common.dto.UserInfoDTO;
import cn.y3h2.blog.user.common.model.Response;
import com.baomidou.mybatisplus.core.metadata.IPage;

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
     * @param condition 仅username可用
     * @param part
     * @return
     */
    Response<UserInfoDTO> loadUserByUsername(FindUserCondition condition, FindUserPart part);

    /**
     * 分页查询用户信息
     *
     * @param condition 查询条件
     * @param part      结果所需的信息部件
     * @return
     */
    Response<IPage<UserInfoDTO>> pageUser(FindUserCondition condition, FindUserPart part);

    /**
     * 添加用户信息
     *
     * @param userInfoDTO 被添加的用户信息
     * @return
     */
    Response<Boolean> addUser(UserInfoDTO userInfoDTO);
}
