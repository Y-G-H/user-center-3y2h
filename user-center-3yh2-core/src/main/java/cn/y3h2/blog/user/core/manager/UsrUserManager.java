package cn.y3h2.blog.user.core.manager;

import cn.y3h2.blog.user.api.domain.req.FindUserCondition;
import cn.y3h2.blog.user.common.enums.MessageEnums;
import cn.y3h2.blog.user.common.excaption.ExceptionFactory;
import cn.y3h2.blog.user.core.dao.UsrUserMapper;
import cn.y3h2.blog.user.core.domain.UsrUserDO;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

/**
 * @ClassName UsrUserManager
 * @Author kongming
 * @Date 2020/11/11 11:17 下午
 * @Description 用户manager
 */
@Component
public class UsrUserManager {

    @Autowired
    private UsrUserMapper usrUserMapper;

    public List<UsrUserDO> load(FindUserCondition condition) {
        try {
            LambdaQueryWrapper<UsrUserDO> lambdaQueryWrapper = new LambdaQueryWrapper();
            if (Objects.nonNull(condition.getId())) lambdaQueryWrapper.eq(UsrUserDO::getId, condition.getId());
            if (Objects.nonNull(condition.getGender())) lambdaQueryWrapper.eq(UsrUserDO::getGender, condition.getGender());
            if (Objects.nonNull(condition.getRealname())) lambdaQueryWrapper.eq(UsrUserDO::getRealname, condition.getRealname());
            if (Objects.nonNull(condition.getState())) lambdaQueryWrapper.eq(UsrUserDO::getState, condition.getState());
            if (Objects.nonNull(condition.getUsername())) lambdaQueryWrapper.eq(UsrUserDO::getUsername, condition.getUsername());

            List<UsrUserDO> usrUserDOS = usrUserMapper.selectList(lambdaQueryWrapper);
            return usrUserDOS;
        } catch (Exception e) {
            throw ExceptionFactory.getSqlException(MessageEnums.SQL_ERROR, "查询用户信息错误");
        }
    }

}
