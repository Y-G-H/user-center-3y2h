package cn.y3h2.blog.user.api.domain.req;

import cn.y3h2.blog.user.common.model.Page;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName FindUserCondition
 * @Author kongming
 * @Date 2020/11/11 11:27 下午
 * @Description 查询用户条件
 */
@Data
public class FindUserCondition extends Page implements Serializable {

    private static final long serialVersionUID = -8498598226943327574L;
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

    /**
     * 解冻日期
     */
    private Data freeze2Date;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 角色编码
     */
    private String roleCode;


}
