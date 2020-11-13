package cn.y3h2.blog.user.core.manager;

import cn.y3h2.blog.user.api.domain.req.FindRoleCondition;
import cn.y3h2.blog.user.common.enums.MessageEnums;
import cn.y3h2.blog.user.common.excaption.ExceptionFactory;
import cn.y3h2.blog.user.core.dao.UsrRoleMapper;
import cn.y3h2.blog.user.core.domain.UsrRoleDO;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @ClassName UsrRoleManager
 * @Author kongming
 * @Date 2020/11/13 11:03 下午
 * @Description 角色manager
 */
@Component
public class UsrRoleManager {

    @Autowired
    private UsrRoleMapper usrRoleMapper;

    public UsrRoleDO load(FindRoleCondition condition) {
        try {
            LambdaQueryWrapper<UsrRoleDO> queryWrapper = new LambdaQueryWrapper();
            if (Objects.nonNull(condition.getCode())) queryWrapper.eq(UsrRoleDO::getCode, condition.getCode());

            return usrRoleMapper.selectOne(queryWrapper);
        } catch (Exception e) {
            throw ExceptionFactory.getSqlException(MessageEnums.SQL_ERROR, "查询角色信息错误");
        }
    }

}
