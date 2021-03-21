package cn.y3h2.blog.user.provider.helper;


import cn.y3h2.blog.user.common.dto.PermissionInfoDTO;
import cn.y3h2.blog.user.common.dto.RoleInfoDTO;
import cn.y3h2.blog.user.common.dto.UserInfoDTO;
import cn.y3h2.blog.user.core.domain.UsrPermissionDO;
import cn.y3h2.blog.user.core.domain.UsrRoleDO;
import cn.y3h2.blog.user.core.domain.UsrUserDO;
import org.springframework.beans.BeanUtils;

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
        BeanUtils.copyProperties(usrUserDO, userInfoDTO);
        return userInfoDTO;
    }

    public static RoleInfoDTO toRoleInfoDTO(UsrRoleDO usrRoleDO, List<PermissionInfoDTO> permissions) {
        RoleInfoDTO roleInfoDTO = new RoleInfoDTO();
        BeanUtils.copyProperties(usrRoleDO, roleInfoDTO);
        roleInfoDTO.setPermissions(permissions);
        return roleInfoDTO;
    }

    public static PermissionInfoDTO toPermissionInfoDTO(UsrPermissionDO usrPermissionDO) {
        PermissionInfoDTO permissionInfoDTO = new PermissionInfoDTO();
        BeanUtils.copyProperties(usrPermissionDO, permissionInfoDTO);
        return permissionInfoDTO;
    }

}
