package cn.y3h2.blog.user.api.domain.req;

import lombok.Data;

/**
 * @ClassName FindPermissionCondition
 * @Author kongming
 * @Date 2020/11/13 11:16 下午
 * @Description 查询用户权限条件
 */
@Data
public class FindPermissionCondition {

    /**
     * 角色编码
     */
    private String roleCode;

    /**
     * 权限编码
     */
    private String permissionCode;

}
