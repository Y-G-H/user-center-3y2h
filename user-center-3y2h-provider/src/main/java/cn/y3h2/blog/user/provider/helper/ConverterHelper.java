package cn.y3h2.blog.user.provider.helper;


import cn.y3h2.blog.user.common.dto.UserInfoDTO;
import cn.y3h2.blog.user.core.domain.UsrUserDO;

/**
 * @ClassName ConverterHelper
 * @Author kongming
 * @Date 2020/11/12 11:04 下午
 * @Description 类型转换器
 */
public class ConverterHelper {

    public static UserInfoDTO toUserInfoDTO(UsrUserDO usrUserDO) {
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setId(usrUserDO.getId());
        userInfoDTO.setPassword(usrUserDO.getPassword());
        userInfoDTO.setRealname(usrUserDO.getRealname());
        userInfoDTO.setState(usrUserDO.getState());
        userInfoDTO.setUsername(usrUserDO.getUsername());
        return userInfoDTO;
    }

}
