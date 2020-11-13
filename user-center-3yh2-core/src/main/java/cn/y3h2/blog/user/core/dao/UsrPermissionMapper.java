package cn.y3h2.blog.user.core.dao;

import cn.y3h2.blog.user.api.domain.req.FindPermissionCondition;
import cn.y3h2.blog.user.core.domain.UsrPermissionDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UsrPermissionMapper extends BaseMapper<UsrPermissionDO> {

    public List<UsrPermissionDO> loadAll(FindPermissionCondition condition);

    public List<UsrPermissionDO> loadByRole(FindPermissionCondition condition);

}
