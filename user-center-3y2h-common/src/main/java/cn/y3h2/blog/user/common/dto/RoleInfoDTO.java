package cn.y3h2.blog.user.common.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
* @ClassName RoleInfoDTO
* @Author kongming
* @Date 2020/11/13 11:50 下午
* @Description 角色信息DTO
*/
@Data
public class RoleInfoDTO implements Serializable {

    private static final long serialVersionUID = -4040170404966633766L;
    /**
     * 角色编码
     */
    private String code;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色描述
     */
    private String reason;

    /**
     * 权限列表
     */
    private List<PermissionInfoDTO> permissions;

}
