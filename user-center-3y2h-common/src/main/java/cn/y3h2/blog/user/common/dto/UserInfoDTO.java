package cn.y3h2.blog.user.common.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName UserInfoDTO
 * @Author kongming
 * @Date 2020/11/11 11:54 下午
 * @Description 用户信息dto
 */
@Data
public class UserInfoDTO implements Serializable {

    private static final long serialVersionUID = -7617685459735885171L;
    /**
     * 用户id
     */
    private Long id;

    /**
     * 用户账户名
     */
    private String username;

    /**
     * 真实姓名
     */
    private String realname;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 解冻至时间
     */
    private Date freeze2Date;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 账户状态
     */
    private Integer state;

    /**
     * 角色编码
     */
    private String roleCode;

    /**
     * 用户角色
     */
    private RoleInfoDTO role;

}
