package com.zhongyong.springbootdemo2.mapper;

import com.zhongyong.springbootdemo2.base.BaseMapper;
import com.zhongyong.springbootdemo2.model.Users;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper extends BaseMapper<Users> {
    Users selectByStaffId(@Param("staffId") String staffId);

}
