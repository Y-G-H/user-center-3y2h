package cn.y3h2.blog.user.core.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName UsrUserDO
 * @Author kongming
 * @Date 2020/11/11 10:14 下午
 * @Description 用户表DO
 */
@Data
@TableName("usr_user")
public class UsrUserDO extends BaseDO {

    /**
     * 登录用户名
     */
    @TableField("username")
    private String username;

    /**
     * 真实姓名
     */
    @TableField("realname")
    private String realname;

    /**
     * 手机号
     */
    @TableField("mobile")
    private String mobile;


    /**
     * 头像
     */
    @TableField("avatar")
    private String avatar;

    /**
     * 解冻时间
     */
    @TableField("freeze_to_date")
    private Date freeze2Date;

    /**
     * 角色编码
     */
    @TableField("role_code")
    private String roleCode;

    /**
     * 性别
     */
    @TableField("gender")
    private Integer gender;

    /**
     * 登录密码
     */
    @TableField("password")
    private String password;

    /**
     * 账号状态
     * see
     */
    @TableField("state")
    private Integer state;

}
