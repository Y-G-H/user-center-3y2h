package cn.y3h2.blog.user.api.domain.rsp;

import lombok.Data;

/**
 * @ClassName UserInfoDTO
 * @Author kongming
 * @Date 2020/11/11 11:54 下午
 * @Description 用户信息dto
 */
@Data
public class UserInfoDTO {

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
    private String state;

}
