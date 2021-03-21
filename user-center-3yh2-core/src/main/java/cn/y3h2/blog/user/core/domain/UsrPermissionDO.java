package cn.y3h2.blog.user.core.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @ClassName UsrPermissionDO
 * @Author kongming
 * @Date 2020/11/13 11:12 下午
 * @Description 用户权限DO
 */
@Data
@TableName("usr_permission")
public class UsrPermissionDO extends BaseDO {

    /**
     * 权限编码
     */
    @TableField("code")
    private String code;

    /**
     * 权限名称
     */
    @TableField("name")
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
