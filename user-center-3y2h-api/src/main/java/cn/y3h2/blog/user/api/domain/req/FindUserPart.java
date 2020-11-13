package cn.y3h2.blog.user.api.domain.req;

import lombok.Data;

import java.io.Serializable;

/**
* @ClassName FindUserPart
* @Author kongming
* @Date 2020/11/14 12:06 上午
* @Description 查询用户信息所需部件
*/
@Data
public class FindUserPart implements Serializable {
    private static final long serialVersionUID = -9129638945529085467L;

    /**
     * 是否需要角色信息
     */
    private Boolean needRole;

    /**
     * 是否需要权限信息，若该值为true则needRole自动为true
     */
    private Boolean needPermission;
}
