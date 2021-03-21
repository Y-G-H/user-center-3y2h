package cn.y3h2.blog.user.provider.service;

import cn.y3h2.blog.user.api.UserFacade;
import cn.y3h2.blog.user.api.domain.req.FindPermissionCondition;
import cn.y3h2.blog.user.api.domain.req.FindRoleCondition;
import cn.y3h2.blog.user.api.domain.req.FindUserCondition;
import cn.y3h2.blog.user.api.domain.req.FindUserPart;
import cn.y3h2.blog.user.common.dto.PermissionInfoDTO;
import cn.y3h2.blog.user.common.dto.RoleInfoDTO;
import cn.y3h2.blog.user.common.dto.UserInfoDTO;
import cn.y3h2.blog.user.common.enums.MessageEnums;
import cn.y3h2.blog.user.common.enums.RoleEnum;
import cn.y3h2.blog.user.common.enums.UserStateEnum;
import cn.y3h2.blog.user.common.excaption.ExceptionFactory;
import cn.y3h2.blog.user.common.model.Response;
import cn.y3h2.blog.user.core.domain.UsrPermissionDO;
import cn.y3h2.blog.user.core.domain.UsrRoleDO;
import cn.y3h2.blog.user.core.domain.UsrUserDO;
import cn.y3h2.blog.user.core.manager.UsrPermissionManager;
import cn.y3h2.blog.user.core.manager.UsrRoleManager;
import cn.y3h2.blog.user.core.manager.UsrUserManager;
import cn.y3h2.blog.user.provider.helper.ConverterHelper;
import com.alibaba.dubbo.common.utils.StringUtils;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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

    public Response<UserInfoDTO> loadUserByUsername(FindUserCondition condition, FindUserPart part) {
        if (Objects.isNull(condition.getUsername()))
            throw ExceptionFactory.getBusinessException(MessageEnums.PARAM_ERROR, "用户名为空");
        log.info("UserService#loadUserByUsername find user condition is [{}], part is [{}]", condition, part);

        Boolean needPermission = part.getNeedPermission();
        Boolean needRole = part.getNeedRole();

        try {
            UsrUserDO usrUserDO = usrUserManager.loadByUsername(condition.getUsername());
            if (Objects.isNull(usrUserDO)) {
                log.warn("UserService#loadUserByUsername user not found, username is [{}]", condition.getUsername());
                return Response.ok(null);
            }

            // 根据part包装返回结果
            UserInfoDTO userInfo = ConverterHelper.toUserInfoDTO(usrUserDO);
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
                roleInfoDTO = ConverterHelper.toRoleInfoDTO(role, permissions);
            }
            userInfo.setRole(roleInfoDTO);
            return Response.ok(userInfo);
        } catch (Exception e) {
            log.error("UserService#loadUserByUsername load user error: [{}]", e);
            return Response.fail(MessageEnums.SYS_ERROR.getCode(), MessageEnums.SYS_ERROR.getMsg());
        }
    }

    public Response<IPage<UserInfoDTO>> pageUser(FindUserCondition condition, FindUserPart part) {
        if (Objects.isNull(condition.getPageNo())) condition.setPageNo(1);
        if (Objects.isNull(condition.getPageSize())) condition.setPageSize(10);

        Boolean needPermission = part.getNeedPermission();
        Boolean needRole = part.getNeedRole();
        IPage<UsrUserDO> pageData = usrUserManager.loadPage(condition);
        List<UsrUserDO> UsrUserDOs = pageData.getRecords();
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

        return Response.ok(pageData);
    }


    public Response<Boolean> addUser(UserInfoDTO userInfoDTO) {
        if (StringUtils.isBlank(userInfoDTO.getUsername()))
            throw ExceptionFactory.getBusinessException(MessageEnums.PARAM_ERROR, "用户名为空");
        if (StringUtils.isBlank(userInfoDTO.getPassword()))
            throw ExceptionFactory.getBusinessException(MessageEnums.PARAM_ERROR, "用户密码为空");
        if (StringUtils.isBlank(userInfoDTO.getRoleCode())) userInfoDTO.setRoleCode(RoleEnum.NORMAL.getValue());
        if (Objects.isNull(userInfoDTO.getState())) userInfoDTO.setState(UserStateEnum.NORMAL.getCode());

        log.info("UserService#addUser add user params is [{}]", userInfoDTO);
        usrUserManager.add(userInfoDTO);
        return Response.ok(true);
    }

}
