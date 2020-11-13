package cn.y3h2.blog.user.core.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @ClassName UsrRoleDO
 * @Author kongming
 * @Date 2020/11/13 11:01 下午
 * @Description 用户角色DO
 */
@Data
@TableName("usr_role")
public class UsrRoleDO extends BaseDO {

    /**
     * 角色名称
     */
    @TableField("name")
    private String name;

    /**
     * 角色编码
     */
    @TableField("code")
    private String code;

    /**
     * 角色描述
     */
    @TableField("reason")
    private String reason;

}
