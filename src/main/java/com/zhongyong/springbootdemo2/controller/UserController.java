package com.zhongyong.springbootdemo2.controller;


import com.zhongyong.springbootdemo2.base.HttpResult;
import com.zhongyong.springbootdemo2.model.Users;
import com.zhongyong.springbootdemo2.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequestMapping("user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getAllUser")
    public HttpResult<List<Users>> getAllUser() {
        List<Users> list = userService.getAllUser();
        if (list != null && list.size() > 0) {
            return new HttpResult<>(200, "查询成功", list);
        } else {
            return new HttpResult<>(400, "没有更多数据", null);
        }
    }

    @GetMapping("/getAllUserByPage")
    public HttpResult<List<Users>> getAllUserByPage(@RequestParam int pageNum, @RequestParam int pageSize) {
        List<Users> list = userService.getAllUserByPage(pageNum, pageSize);
        if (list != null && list.size() > 0) {
            return new HttpResult<>(200, "查询成功", list);
        } else {
            return new HttpResult<>(400, "没有更多数据", null);
        }
    }

    @GetMapping("/selectByStaffId")
    public HttpResult<Users> selectByStaffId(@RequestParam String staffId) {
        Users user = userService.selectByStaffId(staffId);
        if (user != null) {
            return new HttpResult<>(200, "查询成功", user);
        } else {
            return new HttpResult<>(400, "该用户不存在", null);
        }
    }
}
