package com.zhongyong.springbootdemo2.controller;

import com.zhongyong.springbootdemo2.base.HttpResult;
import com.zhongyong.springbootdemo2.model.Sign;
import com.zhongyong.springbootdemo2.service.SignService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RequestMapping("sign")
@RestController
public class SignController {
    @Autowired
    private SignService mSignService;

    @GetMapping("/getAllSign")
    public HttpResult<List<Sign>> getAllSign() {
        List<Sign> list = mSignService.getAll();
        if (list != null && list.size() > 0) {
            return new HttpResult<>(200, "查询成功", list);
        } else {
            return new HttpResult<>(400, "没有更多数据", null);
        }
    }

    /**
     * 添加一条签到记录
     */
    @PostMapping("/addSign")
    public HttpResult<String> addSign(@RequestBody Sign sign) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = format.format(new Date());
        sign.setSignTime(date);
        try {
            mSignService.insertSign(sign);
            return new HttpResult<>(200, "插入数据成功", null);
        } catch (Exception e) {
            return new HttpResult<>(400, "插入失败", e.getMessage());
        }
    }

    /**
     * 删除一条签到记录
     */
    @PostMapping("/deleteSign")
    public HttpResult<Integer> deleteSign(@RequestParam int id) {
        int result = mSignService.deleteByPrimaryKey(id);
        if (result > 0) {
            return new HttpResult<>(200, "删除数据成功", result);
        } else {
            return new HttpResult<>(400, "删除失败", result);
        }


    }
}
