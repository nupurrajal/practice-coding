package com.machinecoding.splitwise.entity;

import java.util.UUID;

public class User {

    private String userId;
    private String emailId;
    private String userName;
    private String phoneNo;

    public User(String emailId, String name, String phoneNo) {
        this.userId = UUID.randomUUID().toString();
        this.emailId = emailId;
        this.userName = name;
        this.phoneNo = phoneNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
