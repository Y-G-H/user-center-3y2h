package cn.y3h2.blog.user.common.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName PermissionInfoDTO
 * @Author kongming
 * @Date 2020/11/13 11:50 下午
 * @Description 权限信息DTO
 */
@Data
public class PermissionInfoDTO implements Serializable {

    private static final long serialVersionUID = 1841337596022951918L;
    /**
     * 权限编码
     */
    private String code;

    /**
     * 权限名称
     */
    private String name;

    /**
     * 菜单类型
     */
    @TableField("type")
    private Integer type;

    /**
     * 父级菜单，为空则为顶级
     */
    @TableField("parent_id")
    private Long parentId;

    /**
     * 菜单url
     */
    @TableField("url")
    private String url;

    /**
     * 图标
     */
    @TableField("icon")
    private String icon;

    /**
     * 菜单顺序
     */
    @TableField("sort_num")
    private Integer sortNum;

}
