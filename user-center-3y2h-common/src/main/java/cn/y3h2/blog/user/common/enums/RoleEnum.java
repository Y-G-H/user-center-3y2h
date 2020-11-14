package cn.y3h2.blog.user.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @ClassName RoleEnum
 * @Author kongming
 * @Date 2020/11/14 5:47 下午
 * @Description 角色枚举
 */
@AllArgsConstructor
public enum  RoleEnum {
    ADMIN(0, "USR_ADMIN", "管理员"),
    NORMAL(1, "USR_NORMAL", "普通用户");

    @Getter
    private Integer code;
    @Getter
    private String value;
    @Getter
    private String msg;

}
