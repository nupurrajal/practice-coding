package com.machinecoding.splitwise.service;

import com.machinecoding.splitwise.entity.Expense;
import com.machinecoding.splitwise.entity.User;

public class NotificationService {
    public void notifyUser(User user, Expense expense) {
        System.out.println(user.getUserId() + " notified");
    }
}
