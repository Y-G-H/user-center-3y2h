package cn.y3h2.blog.user.core.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @ClassName UsrRolePermissionDO
 * @Author kongming
 * @Date 2020/11/13 11:19 下午
 * @Description
 */
@Data
@TableName("usr_role_permission")
public class UsrRolePermissionDO extends BaseDO {

    /**
     * 角色编码
     */
    @TableField("role_code")
    private String roleCode;

    /**
     * 权限编码
     */
    @TableField("permission_code")
    private String permissionCode;


}
