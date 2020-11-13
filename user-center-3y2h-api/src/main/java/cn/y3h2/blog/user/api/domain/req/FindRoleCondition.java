package cn.y3h2.blog.user.api.domain.req;

import lombok.Data;

/**
 * @ClassName FindRoleCondition
 * @Author kongming
 * @Date 2020/11/13 11:05 下午
 * @Description 查询角色条件
 */
@Data
public class FindRoleCondition {

    /**
     * 角色编码
     */
    private String code;

}
