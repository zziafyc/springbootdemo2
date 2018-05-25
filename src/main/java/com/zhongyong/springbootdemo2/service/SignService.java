package com.zhongyong.springbootdemo2.service;

import com.zhongyong.springbootdemo2.base.BaseService;
import com.zhongyong.springbootdemo2.model.Sign;

public interface SignService extends BaseService<Sign> {
    void insertSign(Sign sign);

}
