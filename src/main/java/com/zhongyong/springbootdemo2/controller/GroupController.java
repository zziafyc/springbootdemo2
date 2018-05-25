package com.zhongyong.springbootdemo2.controller;

import com.zhongyong.springbootdemo2.base.HttpResult;
import com.zhongyong.springbootdemo2.model.Groups;
import com.zhongyong.springbootdemo2.service.GroupService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("groups")
@RestController
public class GroupController {
    @Autowired
    private GroupService mGroupService;

    @GetMapping("/getAllGroups")
    public HttpResult<List<Groups>> getAllGroups() {
        List<Groups> list = mGroupService.getAll();
        if (list != null && list.size() > 0) {
            return new HttpResult<>(200, "查询成功", list);
        } else {
            return new HttpResult<>(400, "没有更多数据", null);
        }
    }
}
