package com.csx.cxy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.csx.cxy.entity.User;
import org.apache.ibatis.annotations.Param;


public interface UserMapper extends BaseMapper<User> {
    User getUserInfo(@Param("userId") String userId);
}
