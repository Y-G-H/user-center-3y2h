package cn.y3h2.blog.user.api.domain.req;

import lombok.Data;

/**
 * @ClassName FindUserCondition
 * @Author kongming
 * @Date 2020/11/11 11:27 下午
 * @Description 查询用户条件
 */
@Data
public class FindUserCondition {

    /**
     * id
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 真实姓名
     */
    private String realname;

    /**
     * 性别
     */
    private String gender;

    /**
     * 账户状态
     */
    private Integer state;


}
