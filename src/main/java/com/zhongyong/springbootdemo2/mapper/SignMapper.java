package com.zhongyong.springbootdemo2.mapper;

import com.zhongyong.springbootdemo2.base.BaseMapper;
import com.zhongyong.springbootdemo2.model.Sign;

import org.springframework.stereotype.Component;

@Component
public interface SignMapper extends BaseMapper<Sign> {
    //sql server 针对有自增主键的表，需要重新编写插入sql语句，否则无法插入
    int insertSign(Sign sign);
}
