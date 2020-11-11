package cn.y3h2.blog.user.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @ClassName UserStateEnum
 * @Author kongming
 * @Date 2020/11/11 10:21 下午
 * @Description 用户账户状态枚举
 */
@AllArgsConstructor
public enum UserStateEnum {
    NORMAL(0, "normal", "正常"),
    BANNED(1, "banned", "封禁"),
    DELETE(-1, "delete", "被删除");

    @Getter
    private Integer code;
    @Getter
    private String value;
    @Getter
    private String msg;

}
