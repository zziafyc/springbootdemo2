package com.zhongyong.springbootdemo2.service.impl;

import com.zhongyong.springbootdemo2.base.BaseServiceImpl;
import com.zhongyong.springbootdemo2.mapper.SignMapper;
import com.zhongyong.springbootdemo2.model.Sign;
import com.zhongyong.springbootdemo2.service.SignService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignServiceImpl extends BaseServiceImpl<Sign> implements SignService {
    @Autowired
    SignMapper mSignMapper;

    //针对自增id，无法插入显示值，需要重新写插入数据
    @Override
    public void insertSign(Sign sign) {
         mSignMapper.insertSign(sign);
    }


}
