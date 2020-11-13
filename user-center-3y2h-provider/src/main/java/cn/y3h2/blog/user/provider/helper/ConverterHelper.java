package cn.y3h2.blog.user.provider.helper;


import cn.y3h2.blog.user.common.dto.PermissionInfoDTO;
import cn.y3h2.blog.user.common.dto.RoleInfoDTO;
import cn.y3h2.blog.user.common.dto.UserInfoDTO;
import cn.y3h2.blog.user.core.domain.UsrPermissionDO;
import cn.y3h2.blog.user.core.domain.UsrRoleDO;
import cn.y3h2.blog.user.core.domain.UsrUserDO;

import java.util.List;

/**
 * @ClassName ConverterHelper
 * @Author kongming
 * @Date 2020/11/12 11:04 下午
 * @Description 类型转换器
 */
public class ConverterHelper {

    public static UserInfoDTO toUserInfoDTO(UsrUserDO usrUserDO) {
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setId(usrUserDO.getId());
        userInfoDTO.setPassword(usrUserDO.getPassword());
        userInfoDTO.setRealname(usrUserDO.getRealname());
        userInfoDTO.setRoleCode(usrUserDO.getRoleCode());
        userInfoDTO.setState(usrUserDO.getState());
        userInfoDTO.setUsername(usrUserDO.getUsername());
        return userInfoDTO;
    }

    public static RoleInfoDTO toRoleInfoDTO(UsrRoleDO usrRoleDO, List<PermissionInfoDTO> permissions) {
        RoleInfoDTO roleInfoDTO = new RoleInfoDTO();
        roleInfoDTO.setCode(usrRoleDO.getCode());
        roleInfoDTO.setName(usrRoleDO.getName());
        roleInfoDTO.setReason(usrRoleDO.getReason());
        roleInfoDTO.setPermissions(permissions);
        return roleInfoDTO;
    }

    public static PermissionInfoDTO toPermissionInfoDTO(UsrPermissionDO usrPermissionDO) {
        PermissionInfoDTO permissionInfoDTO = new PermissionInfoDTO();
        permissionInfoDTO.setCode(usrPermissionDO.getCode());
        permissionInfoDTO.setName(usrPermissionDO.getName());
        return permissionInfoDTO;
    }

}
