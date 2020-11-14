package cn.y3h2.blog.user.core.manager;

import cn.y3h2.blog.user.api.domain.req.FindUserCondition;
import cn.y3h2.blog.user.common.dto.UserInfoDTO;
import cn.y3h2.blog.user.common.enums.MessageEnums;
import cn.y3h2.blog.user.common.enums.RoleEnum;
import cn.y3h2.blog.user.common.enums.UserStateEnum;
import cn.y3h2.blog.user.common.excaption.ExceptionFactory;
import cn.y3h2.blog.user.core.dao.UsrUserMapper;
import cn.y3h2.blog.user.core.domain.UsrUserDO;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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

    public UsrUserDO loadByUsername(String username) {
        try {
            LambdaQueryWrapper<UsrUserDO> queryWrapper = new LambdaQueryWrapper();
            queryWrapper.eq(UsrUserDO::getUsername, username);

            return usrUserMapper.selectOne(queryWrapper);
        } catch (Exception e) {
            throw ExceptionFactory.getSqlException(MessageEnums.SQL_ERROR, "查询用户信息错误");
        }
    }

    public IPage<UsrUserDO> loadPage(FindUserCondition condition) {
        try {
            LambdaQueryWrapper<UsrUserDO> queryWrapper = new LambdaQueryWrapper();
            if (Objects.nonNull(condition.getId())) queryWrapper.eq(UsrUserDO::getId, condition.getId());
            if (Objects.nonNull(condition.getGender())) queryWrapper.eq(UsrUserDO::getGender, condition.getGender());
            if (Objects.nonNull(condition.getRealname())) queryWrapper.eq(UsrUserDO::getRealname, condition.getRealname());
            if (Objects.nonNull(condition.getState())) queryWrapper.eq(UsrUserDO::getState, condition.getState());
            if (Objects.nonNull(condition.getUsername())) queryWrapper.eq(UsrUserDO::getUsername, condition.getUsername());
            if (Objects.nonNull(condition.getFreeze2Date())) queryWrapper.eq(UsrUserDO::getFreeze2Date, condition.getFreeze2Date());
            if (Objects.nonNull(condition.getMobile())) queryWrapper.eq(UsrUserDO::getMobile, condition.getMobile());
            if (Objects.nonNull(condition.getRoleCode())) queryWrapper.eq(UsrUserDO::getRoleCode, condition.getRoleCode());

            IPage<UsrUserDO> page = new Page<>(condition.getPageNo(), condition.getPageSize());
            return usrUserMapper.selectPage(page, queryWrapper);
        } catch (Exception e) {
            throw ExceptionFactory.getSqlException(MessageEnums.SQL_ERROR, "查询用户信息错误");
        }
    }

    public Boolean add(UserInfoDTO userInfoDTO) {
        try {
            UsrUserDO userDO = new UsrUserDO();
            userDO.setUsername(userInfoDTO.getUsername());
            userDO.setPassword(userInfoDTO.getPassword());
            userDO.setRealname(userInfoDTO.getRealname());
            userDO.setGender(userInfoDTO.getGender());
            userDO.setFreeze2Date(userInfoDTO.getFreeze2Date());
            userDO.setMobile(userInfoDTO.getMobile());
            userDO.setRoleCode(userInfoDTO.getRoleCode());
            userDO.setState(userInfoDTO.getState());
            userDO.setAvatar(userInfoDTO.getAvatar());

            usrUserMapper.insert(userDO);
            return true;
        } catch (Exception e) {
            throw ExceptionFactory.getSqlException(MessageEnums.SQL_ERROR, "添加用户信息错误");
        }
    }

}
