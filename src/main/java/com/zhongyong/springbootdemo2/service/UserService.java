package com.zhongyong.springbootdemo2.service;

import com.zhongyong.springbootdemo2.base.BaseService;
import com.zhongyong.springbootdemo2.model.Users;

import java.util.List;

public interface UserService extends BaseService<Users> {
    //得到所有用户
    List<Users> getAllUser();

    //根据员工id选择用户
    Users selectByStaffId(String staffId);

    //分页得到所有用户
    List<Users> getAllUserByPage(int pageNum, int pageSize);

}
