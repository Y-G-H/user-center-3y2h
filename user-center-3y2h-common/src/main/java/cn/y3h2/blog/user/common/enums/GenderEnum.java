package cn.y3h2.blog.user.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @ClassName GenderEnum
 * @Author kongming
 * @Date 2020/11/11 10:24 下午
 * @Description 用户性别枚举
 */
@AllArgsConstructor
public enum GenderEnum {
    MAN(1, "man", "男性"),
    WOMAN(0, "woman", "女性");

    @Getter
    private Integer code;
    @Getter
    private String value;
    @Getter
    private String msg;

}
