package com.zhongyong.springbootdemo2.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
public class Sign implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "staff_id")
    private String staffId;
    @Column(name = "group_id")
    private String groupId;
    @Column(name = "sign_time")
    private String signTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStaffId() {
        return staffId == null ? "" : staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getGroupId() {
        return groupId == null ? "" : groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getSignTime() {
        return signTime == null ? "" : signTime;
    }

    public void setSignTime(String signTime) {
        this.signTime = signTime;
    }
}
