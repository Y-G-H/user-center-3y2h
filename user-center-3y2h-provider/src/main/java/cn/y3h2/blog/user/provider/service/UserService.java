package cn.y3h2.blog.user.provider.service;

import cn.y3h2.blog.user.api.UserFacade;
import cn.y3h2.blog.user.api.domain.req.FindPermissionCondition;
import cn.y3h2.blog.user.api.domain.req.FindRoleCondition;
import cn.y3h2.blog.user.api.domain.req.FindUserCondition;
import cn.y3h2.blog.user.api.domain.req.FindUserPart;
import cn.y3h2.blog.user.common.dto.PermissionInfoDTO;
import cn.y3h2.blog.user.common.dto.RoleInfoDTO;
import cn.y3h2.blog.user.common.dto.UserInfoDTO;
import cn.y3h2.blog.user.common.model.Response;
import cn.y3h2.blog.user.core.domain.UsrPermissionDO;
import cn.y3h2.blog.user.core.domain.UsrRoleDO;
import cn.y3h2.blog.user.core.domain.UsrUserDO;
import cn.y3h2.blog.user.core.manager.UsrPermissionManager;
import cn.y3h2.blog.user.core.manager.UsrRoleManager;
import cn.y3h2.blog.user.core.manager.UsrUserManager;
import cn.y3h2.blog.user.provider.helper.ConverterHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Autowired
    private UsrPermissionManager usrPermissionManager;

    @Autowired
    private UsrRoleManager usrRoleManager;

    public Response<List<UserInfoDTO>> loadUser(FindUserCondition condition, FindUserPart part) {
        Boolean needPermission = part.getNeedPermission();
        Boolean needRole = part.getNeedRole();
        List<UsrUserDO> UsrUserDOs = usrUserManager.load(condition);
        List<UserInfoDTO> userInfoDTOs = UsrUserDOs.stream().map(ConverterHelper::toUserInfoDTO).collect(Collectors.toList());
        for (UserInfoDTO userInfo : userInfoDTOs) {
            RoleInfoDTO roleInfoDTO = null;
            List<PermissionInfoDTO> permissions = null;

            // 是否需要权限数据
            if (needPermission) {
                FindPermissionCondition permissionCondition = new FindPermissionCondition();
                permissionCondition.setRoleCode(userInfo.getRoleCode());
                permissions = usrPermissionManager.loadPermissionsByRole(permissionCondition)
                        .stream().map(ConverterHelper::toPermissionInfoDTO).collect(Collectors.toList());
            }
            // 是否需要角色数据
            if (needPermission || needRole) {
                FindRoleCondition roleCondition = new FindRoleCondition();
                roleCondition.setCode(userInfo.getRoleCode());
                UsrRoleDO role = usrRoleManager.load(roleCondition);
                ConverterHelper.toRoleInfoDTO(role, permissions);
            }
            userInfo.setRole(roleInfoDTO);
        }

        return Response.ok(userInfoDTOs);
    }

}
