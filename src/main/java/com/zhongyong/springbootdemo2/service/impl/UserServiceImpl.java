package com.zhongyong.springbootdemo2.service.impl;


import com.zhongyong.springbootdemo2.base.BaseServiceImpl;
import com.zhongyong.springbootdemo2.mapper.UserMapper;
import com.zhongyong.springbootdemo2.model.Users;
import com.zhongyong.springbootdemo2.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends BaseServiceImpl<Users> implements UserService {
    //这个是自定义的userMapper（供一些特殊情况），baseMapper是公共的
    @Autowired
    private UserMapper mUserMapper;

    public List<Users> getAllUser() {
        return baseMapper.selectAll();
    }


    public Users selectByStaffId(String staffId) {
        return mUserMapper.selectByStaffId(staffId);
    }

    public List<Users> getAllUserByPage(int pageNum, int pageSize) {
        return selectPage(pageNum, pageSize);
    }

}
