package cn.y3h2.blog.user.core.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
* @ClassName BaseDO
* @Author kongming
* @Date 2020/11/11 10:18 下午
* @Description 基本数据表DO
*/
@Data
public class BaseDO {

    @TableId
    private Long id;

    /**
     * 创建时间
     */
    @TableField("gmt_create")
    private Date gmtCreate;

    /**
     * 修改时间
     */
    @TableField("gmt_modify")
    private Date gmtModify;

    /**
     * 逻辑删除状态
     */
    @TableField("status")
    private Integer status;

}
