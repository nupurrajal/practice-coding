package com.machinecoding.splitwise.entity;

import java.time.LocalDateTime;
import java.util.UUID;

public class Expense {
    private String id;
    private String userId;
    private String title;
    private LocalDateTime expenseDate;
    private ExpenseStatus expenseStatus;
    private double expenseAmount;
    private ExpenseGroup expenseGroup;

    public Expense(String title, LocalDateTime expenseDate, double expenseAmount, String userId) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.expenseAmount = expenseAmount;
        this.expenseDate = expenseDate;
        this.userId = userId;
        this.expenseStatus = ExpenseStatus.CREATED;
        this.expenseGroup = new ExpenseGroup();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(LocalDateTime expenseDate) {
        this.expenseDate = expenseDate;
    }

    public ExpenseStatus getExpenseStatus() {
        return expenseStatus;
    }

    public void setExpenseStatus(ExpenseStatus expenseStatus) {
        this.expenseStatus = expenseStatus;
    }

    public double getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(double expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public ExpenseGroup getExpenseGroup() {
        return expenseGroup;
    }

    public void setExpenseGroup(ExpenseGroup expenseGroup) {
        this.expenseGroup = expenseGroup;
    }
}
