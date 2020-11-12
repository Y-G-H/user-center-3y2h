package cn.y3h2.blog.user.common.dto;

import lombok.Data;

import java.io.Serializable;

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
     * 账户状态
     */
    private Integer state;

}
