package cn.y3h2.blog.user.provider.service;

import cn.y3h2.blog.user.api.UserFacade;
import cn.y3h2.blog.user.api.domain.req.FindUserCondition;
import cn.y3h2.blog.user.api.domain.rsp.UserInfoDTO;
import cn.y3h2.blog.user.common.model.Response;
import cn.y3h2.blog.user.core.domain.UsrUserDO;
import cn.y3h2.blog.user.core.manager.UsrUserManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserService
 * @Author kongming
 * @Date 2020/11/11 11:53 下午
 * @Description 用户信息service接口实现
 */
@Service
@Slf4j
public class UserService implements UserFacade {

    @Autowired
    private UsrUserManager usrUserManager;

    public Response<List<UserInfoDTO>> loadUser(FindUserCondition condition) {
        List<UsrUserDO> load = usrUserManager.load(condition);
        return Response.ok(load);
    }

}
