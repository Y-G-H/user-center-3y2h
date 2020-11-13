package cn.y3h2.blog.user.common.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName PermissionInfoDTO
 * @Author kongming
 * @Date 2020/11/13 11:50 下午
 * @Description 权限信息DTO
 */
@Data
public class PermissionInfoDTO implements Serializable {

    private static final long serialVersionUID = 1841337596022951918L;
    /**
     * 权限编码
     */
    private String code;

    /**
     * 权限名称
     */
    private String name;

}
