package cn.y3h2.blog.user.core.manager;

import cn.y3h2.blog.user.api.domain.req.FindPermissionCondition;
import cn.y3h2.blog.user.core.dao.UsrPermissionMapper;
import cn.y3h2.blog.user.core.dao.UsrRolePermissionMapper;
import cn.y3h2.blog.user.core.domain.UsrPermissionDO;
import cn.y3h2.blog.user.core.domain.UsrRolePermissionDO;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @ClassName UsrPermissionManager
 * @Author kongming
 * @Date 2020/11/13 11:13 下午
 * @Description 用户权限manager
 */
@Component
public class UsrPermissionManager {

    @Autowired
    private UsrPermissionMapper usrPermissionMapper;

    @Autowired
    private UsrRolePermissionMapper usrRolePermissionMapper;

    public UsrPermissionDO load(FindPermissionCondition condition) {
        LambdaQueryWrapper<UsrPermissionDO> queryWrapper = new LambdaQueryWrapper();
        if (Objects.nonNull(condition.getPermissionCode())) queryWrapper.eq(UsrPermissionDO::getCode, condition.getPermissionCode());
        return usrPermissionMapper.selectOne(queryWrapper);
    }

    public List<UsrPermissionDO> loadPermissionsByRole(FindPermissionCondition condition) {
        return usrPermissionMapper.loadByRole(condition);
    }

    public List<String> loadPermissionCodesByRole(FindPermissionCondition condition) {
        LambdaQueryWrapper<UsrRolePermissionDO> queryWrapper = new LambdaQueryWrapper();

        return usrRolePermissionMapper.selectList(queryWrapper).stream()
                .map(UsrRolePermissionDO::getPermissionCode).collect(Collectors.toList());
    }

}
