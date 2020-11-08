package cn.y3h2.blog.user.api.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class TestParam implements Serializable {

    private static final long serialVersionUID = -3469488244295924805L;

    /**
     * 这里要有注释，解释这个字段的含义和作用
     * 需要说明是否必填
     */
    private String str;

}
