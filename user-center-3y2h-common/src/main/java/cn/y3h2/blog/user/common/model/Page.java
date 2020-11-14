package cn.y3h2.blog.user.common.model;

import lombok.Data;

import java.util.List;

/**
* @ClassName Page
* @Author kongming
* @Date 2020/11/14 5:39 下午
* @Description 分页类
*/
@Data
public class Page<T> {

    /**
     * 页长, 不填默认为10
     */
    private Integer pageSize;

    /**
     * 页码, 不填默认为1
     */
    private Integer pageNo;

    /**
     * 页数据
     */
    private List<T> data;

}
